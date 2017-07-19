package utils;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.net.UrlChecker;

import java.io.*;
import java.net.InetAddress;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;


public class WDAServer {

    private static final Log log = LogFactory.getLog(WDAServer.class.getSimpleName());

    private static final int MAX_REAL_DEVICE_RESTART_RETRIES = 1;
    private static final Timedelta REAL_DEVICE_RUNNING_TIMEOUT = Timedelta.ofMinutes(4);
    private static final Timedelta RESTART_TIMEOUT = Timedelta.ofMinutes(1);

    // These settings are needed to properly sign WDA for real device tests
    // See https://github.com/appium/appium-xcuitest-driver for more details
    private static final File KEYCHAIN = new File(String.format("%s/%s",
            System.getProperty("user.home"), "/Library/Keychains/MyKeychain.keychain"));
    private static final String KEYCHAIN_PASSWORD = "underwood";

    private static final File IPROXY_EXECUTABLE = new File("/usr/local/bin/iproxy");
    private static final File XCODEBUILD_EXECUTABLE = new File("/usr/bin/xcodebuild");
    private static final File WDA_PROJECT =
            new File("/usr/local/lib/node_modules/appium/node_modules/appium-xcuitest-driver/" +
                    "WebDriverAgent/WebDriverAgent.xcodeproj");
    private static final String WDA_SCHEME = "WebDriverAgentRunner";
    private static final String WDA_CONFIGURATION = "Debug";
    private static final File XCODEBUILD_LOG = new File("/usr/local/var/log/appium/build.log");
    private static final File IPROXY_LOG = new File("/usr/local/var/log/appium/iproxy.log");

    private static final int PORT = 8100;
    public static final String SERVER_URL = String.format("http://127.0.0.1:%d", PORT);

    private static final String[] IPROXY_CMDLINE = new String[]{
            IPROXY_EXECUTABLE.getAbsolutePath(),
            Integer.toString(PORT),
            Integer.toString(PORT),
            String.format("> %s 2>&1 &", IPROXY_LOG.getAbsolutePath())
    };

    private static WDAServer instance = null;
    private final boolean isRealDevice;
    private final String deviceId;
    private final String platformVersion;
    private int failedRestartRetriesCount = 0;

    private WDAServer() {
        try {
            this.isRealDevice = true;
            final String udid;
            if (isRealDevice) {
                udid = Config.DEVICE_UID;
            } else {
                // udid = IOSSimulatorHelpers.getId();
                udid = null;
            }
            this.deviceId = udid;
            this.platformVersion = Config.PLATFORM_VERSION;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        ensureToolsExistence();
        ensureParentDirExistence();
    }

    public synchronized static WDAServer getInstance() {
        if (instance == null) {
            instance = new WDAServer();
        }
        return instance;
    }

    private boolean waitUntilIsRunning(Timedelta timeout) throws Exception {
        final URL status = new URL(SERVER_URL + "/status");
        try {
            if (timeout.asSeconds() > 5) {
                log.debug(String.format("Waiting max %s until WDA server starts responding...", timeout));
            }
            new UrlChecker().waitUntilAvailable(timeout.asMillis(), TimeUnit.MILLISECONDS, status);
            return true;
        } catch (UrlChecker.TimeoutException e) {
            return false;
        }
    }

    private static void ensureParentDirExistence() {
        if (!XCODEBUILD_LOG.getParentFile().exists()) {
            if (!XCODEBUILD_LOG.getParentFile().mkdirs()) {
                throw new IllegalStateException(String.format(
                        "The script has failed to create '%s' folder for Appium logs. " +
                                "Please make sure your account has correct access permissions on the parent folder(s)",
                        XCODEBUILD_LOG.getParentFile().getAbsolutePath()));
            }
        }
    }

    private void ensureToolsExistence() {
        if (isRealDevice && !IPROXY_EXECUTABLE.exists()) {
            throw new IllegalStateException(String.format("%s tool is expected to be installed (`npm install -g iproxy`)",
                    IPROXY_EXECUTABLE.getAbsolutePath()));
        }
        if (!XCODEBUILD_EXECUTABLE.exists()) {
            throw new IllegalStateException(String.format("xcodebuild tool is not detected on the current system at %s",
                    XCODEBUILD_EXECUTABLE.getAbsolutePath()));
        }
        if (!WDA_PROJECT.exists()) {
            throw new IllegalStateException(String.format("WDA project is expected to exist at %s",
                    WDA_PROJECT.getAbsolutePath()));
        }
    }

    private List<String> generateXcodebuildCmdline() {
        final List<String> result = new ArrayList<>();
        result.add(XCODEBUILD_EXECUTABLE.getAbsolutePath());
        result.add("clean build test");
        result.add(String.format("-project %s", WDA_PROJECT.getAbsolutePath()));
        result.add(String.format("-scheme %s", WDA_SCHEME));
        result.add(String.format("-destination id=%s", deviceId));
        result.add(String.format("-configuration %s", WDA_CONFIGURATION));
        result.add(String.format("IPHONEOS_DEPLOYMENT_TARGET=%s", platformVersion));
        result.add(String.format("> %s 2>&1 &", XCODEBUILD_LOG.getAbsolutePath()));
        return result;
    }

    private static List<String> generateKeychainUnlockCmdlines() throws Exception {
        final List<String> result = new ArrayList<>();
        result.add(String.format("/usr/bin/security -v list-keychains -s %s", KEYCHAIN.getAbsolutePath()));
        result.add(String.format("/usr/bin/security -v unlock-keychain -p %s %s",
                KEYCHAIN_PASSWORD, KEYCHAIN.getAbsolutePath()));
        result.add(String.format("/usr/bin/security set-keychain-settings -t 3600 %s", KEYCHAIN.getAbsolutePath()));
        return result;
    }

    public synchronized void restart() throws Exception {
        if (isRealDevice && failedRestartRetriesCount >= MAX_REAL_DEVICE_RESTART_RETRIES) {
            throw new IllegalStateException(String.format(
                    "WDA server cannot start on the connected device with udid %s after %s retries. " +
                            "Reboot the device manually and try again", deviceId, MAX_REAL_DEVICE_RESTART_RETRIES));
        }

        final String hostname = InetAddress.getLocalHost().getHostName();
        log.info(String.format("Trying to (re)start WDA server on %s:%s...", hostname, PORT));
        UnixProcessHelpers.killProcessesGracefully(IPROXY_EXECUTABLE.getName(), XCODEBUILD_EXECUTABLE.getName());

        final File scriptFile = File.createTempFile("script", ".sh");
        try {
            final List<String> scriptContent = new ArrayList<>();
            scriptContent.add("#!/bin/bash");
            //    if (isRealDevice && isRunningInJenkinsNetwork()) {
            //     scriptContent.add(String.join("\n", generateKeychainUnlockCmdlines()));
            //    }
            if (isRealDevice) {
                scriptContent.add(String.join(" ", IPROXY_CMDLINE));
            }
            final String wdaBuildCmdline = String.join(" ", generateXcodebuildCmdline());
            log.debug(String.format("Building WDA with command line:\n%s\n", wdaBuildCmdline));
            scriptContent.add(wdaBuildCmdline);
            try (Writer output = new BufferedWriter(new FileWriter(scriptFile))) {
                output.write(String.join("\n", scriptContent));
            }
            new ProcessBuilder("/bin/chmod", "u+x", scriptFile.getCanonicalPath())
                    .redirectErrorStream(true).start().waitFor(5, TimeUnit.SECONDS);
            final ProcessBuilder pb = new ProcessBuilder("/bin/bash", scriptFile.getCanonicalPath());
            final Map<String, String> env = pb.environment();
            // This is needed for Jenkins
            env.put("BUILD_ID", "dontKillMe");
            log.info(String.format("Waiting max %s for WDA to be (re)started on %s:%s...", RESTART_TIMEOUT.toString(),
                    hostname, PORT));
            final Timedelta started = Timedelta.now();
            pb.redirectErrorStream(true).start().waitFor(RESTART_TIMEOUT.asMillis(), TimeUnit.MILLISECONDS);
            if (!waitUntilIsRunning(RESTART_TIMEOUT)) {
                ++failedRestartRetriesCount;
                throw new IllegalStateException(
                        String.format("WDA server has failed to start after %s timeout on server '%s'.\n"
                                        + "Please make sure that iDevice is properly connected and you can build "
                                        + "WDA manually from XCode.\n"
                                        + "Xcodebuild logs:\n\n%s\n\n\niproxy logs:\n\n%s\n\n\n",
                                RESTART_TIMEOUT, hostname,
                                getLog(XCODEBUILD_LOG).orElse("EMPTY"), getLog(IPROXY_LOG).orElse("EMPTY"))
                );
            }

            log.info(String.format("WDA server has been successfully (re)started after %s " +
                    "and now is listening on %s:%s", Timedelta.now().diff(started), hostname, PORT));
        } finally {
            scriptFile.delete();
        }
    }

    public boolean isRunning() throws Exception {
        if (!isProcessRunning(XCODEBUILD_EXECUTABLE.getName())
                || (isRealDevice && !isProcessRunning(IPROXY_EXECUTABLE.getName()))) {
            return false;
        }
        return waitUntilIsRunning(isRealDevice ? REAL_DEVICE_RUNNING_TIMEOUT : Timedelta.ofSeconds(3));
    }

    public Optional<String> getLog(File logFile) {
        if (logFile.exists()) {
            try {
                return Optional.of(new String(Files.readAllBytes(logFile.toPath()), Charset.forName("UTF-8")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return Optional.empty();
    }

    public void resetLogs() {
        for (File logFile : new File[]{XCODEBUILD_LOG, IPROXY_LOG}) {
            if (logFile.exists()) {
                try {
                    final PrintWriter writer = new PrintWriter(logFile);
                    writer.print("");
                    writer.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}