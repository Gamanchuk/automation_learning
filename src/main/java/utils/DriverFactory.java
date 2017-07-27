package utils;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.AndroidServerFlag;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.appium.java_client.service.local.flags.IOSServerFlag;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.zeroturnaround.exec.ProcessExecutor;
import org.zeroturnaround.exec.ProcessResult;
import org.zeroturnaround.process.PidProcess;
import org.zeroturnaround.process.Processes;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static io.appium.java_client.remote.AutomationName.IOS_XCUI_TEST;
import static io.appium.java_client.remote.MobilePlatform.ANDROID;
import static io.appium.java_client.remote.MobilePlatform.IOS;

public class DriverFactory {
    private static EventFiringWebDriver driver;
    private static AppiumDriverLocalService service;
    private static WebDriverEventListener eventListener;
    private static Log log = LogFactory.getLog(DriverFactory.class.getSimpleName());


    public static WebDriver getDriver() {

        if (driver == null) {
            startAppiumService();
            String browserName = Config.DEVICE_BROWSER;
            String platformVersion = Config.PLATFORM_VERSION;
            String platformName = Config.PLATFORM_NAME;
            String deviceName = Config.DEVICE_NAME;
            String deviceUdid = Config.DEVICE_UID;
            String iproxy = Config.IPROXY_PORT;
            boolean xcode_logs = Config.XCODE_LOGS;


            try {
                log.info("\n");
                log.info("**************************** CREATING REMOTE WEB DRIVER ***************************");
                log.info(String.format("PLATFORM NAME: %s", platformName));
                log.info(String.format("PLATFORM VERSION: %s", platformVersion));
                log.info(String.format("DEVICE NAME: %s", deviceName));
                log.info(String.format("DEVICE BROWSER: %s", browserName));
                log.info(String.format("DEVICE UDID: %s", deviceUdid));
                log.info(String.format("DEVICE USB PORT: %s", iproxy));
                log.info("***********************************************************************************");
                log.info("\n");

                DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

                /* Default сapabilities for Android and iOS */
                desiredCapabilities.setCapability(MobileCapabilityType.UDID, deviceUdid);
                desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
                desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browserName);
                desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
                desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);


                if (Config.PLATFORM_NAME.equals(IOS)) {

                    /* Capabilities for use new XCUITest framework */
                    desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, IOS_XCUI_TEST);

                    /* Capabilities for clear and disabled cache/logs */
                    desiredCapabilities.setCapability(IOSMobileCapabilityType.SHOW_IOS_LOG, xcode_logs);
                    desiredCapabilities.setCapability(MobileCapabilityType.CLEAR_SYSTEM_FILES, true);
                    desiredCapabilities.setCapability(IOSMobileCapabilityType.PREVENT_WDAATTACHMENTS, true);

                    /* Capabilities for WebDriverAgentRunner (WDAServer) */
                    desiredCapabilities.setCapability(IOSMobileCapabilityType.USE_NEW_WDA, true);
                    desiredCapabilities.setCapability(IOSMobileCapabilityType.WDA_LOCAL_PORT, Integer.parseInt(iproxy));
                    desiredCapabilities.setCapability(IOSMobileCapabilityType.SIMPLE_ISVISIBLE_CHECK, true);

                    /* Capabilities for timouts */
                    desiredCapabilities.setCapability("webkitResponseTimeout", 50000);
                    desiredCapabilities.setCapability(IOSMobileCapabilityType.LAUNCH_TIMEOUT, 500000);

                    /* Capabilities for automatically sinning WebDriverAgentRunner */
                    desiredCapabilities.setCapability(IOSMobileCapabilityType.XCODE_ORG_ID, "Y95G5M3Q84");
                    desiredCapabilities.setCapability(IOSMobileCapabilityType.XCODE_SIGNING_ID, "iPhone Developer");
                    desiredCapabilities.setCapability(IOSMobileCapabilityType.UPDATE_WDA_BUNDLEID, "com.moovweb.WebDriverAgentRunner");
                }

                if (Config.PLATFORM_NAME.equals(ANDROID)) {

                    /* Chrome Capabilities for disable google translate */
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("disable-translate");
                    desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);

                    /* Capabilities for android keyboard */
                    desiredCapabilities.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
                    desiredCapabilities.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);

                    /* Capabilities for disables android watchers */
                    desiredCapabilities.setCapability(AndroidMobileCapabilityType.DISABLE_ANDROID_WATCHERS, true);
                    desiredCapabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
                }

                eventListener = new MyWebDriverEventListener();
                driver = new EventFiringWebDriver(new RemoteWebDriver(new URL(String.valueOf(service.getUrl())), desiredCapabilities)).register(eventListener);
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

                CommonFunctions.startVideoRecording();

                /* Clean before test started */
                TestGlobalsManager.setTestGlobal("authorised", null);

            } catch (Exception e) {
                throw new AssertionError("Can't create driver: " + e.getMessage());
            }
        }
        return driver;
    }

    /**
     * Function for creating appium service
     */
    private static void startAppiumService() {

        if (service == null) {

            int appiumPort = Config.APPIUM_PORT;
            int proxyPort = Config.PROXY_PORT;

            boolean xcode_logs = Config.XCODE_LOGS;
            boolean appium_logs = Config.APPIUM_LOGS;
            boolean project_tracking = Config.PROJECT_TRACKING;

            if (Config.PLATFORM_NAME.equals(IOS)) {
                iOSProxyRunner(proxyPort);
            }

            killAppiumServer(appiumPort);

            log.info("\n");
            log.info("******************************* STARTING APPIUM SERVICE ****************************");
            log.info(String.format("APPIUM PORT: %d", appiumPort));
            log.info(String.format("IOS WEB PROXY PORT: %d", proxyPort));
            log.info(String.format("XCODE LOGS: %s", xcode_logs));
            log.info(String.format("APPIUM LOGS: %s", appium_logs));
            log.info(String.format("PROJECT TRACKING: %s", project_tracking));

            AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();

            /* Default flags */
            serviceBuilder.usingPort(appiumPort);
            serviceBuilder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
            serviceBuilder.withArgument(GeneralServerFlag.LOG_TIMESTAMP);

            if (!Config.APPIUM_LOGS) {

                /* Flag for disabled appium server logs  */
                serviceBuilder.withArgument(GeneralServerFlag.LOG_LEVEL, "warn");
            }

            if (Config.PLATFORM_NAME.equals(IOS)) {

                /* Flag for bind ios_webkit_debug_proxy to appium server */
                serviceBuilder.withArgument(IOSServerFlag.WEBKIT_DEBUG_PROXY_PORT, String.valueOf(proxyPort));
            }

            if (Config.PLATFORM_NAME.equals(ANDROID)) {

                /* Flag for bind ios_webkit_debug_proxy to appium server */
                serviceBuilder.withArgument(AndroidServerFlag.CHROME_DRIVER_PORT, Config.CHROMEDRIVER_PORT);
                serviceBuilder.withArgument(AndroidServerFlag.BOOTSTRAP_PORT_NUMBER, Config.BOOTSTRAP_PORT);
            }

            service = AppiumDriverLocalService.buildService(serviceBuilder);
            service.start();

            log.info(String.format("APPIUM URL: %s", service.getUrl()));
            log.info("***********************************************************************************");
            log.info("\n");
        }
    }

    /**
     * Function serves for deleting process appium
     *
     * @param port for communication with device
     */
    private static void killAppiumServer(int port) {
        try {
            log.info("Look for the launched appium server on port: " + port);
            ProcessResult processResult = new ProcessExecutor().command("lsof", "-ti", "tcp:" + port)
                    .readOutput(true).execute();

            if (processResult.getExitValue() == 0) {
                log.info("Killing Appium Server");

                Pattern pattern = Pattern.compile("[0-9]+");
                Matcher matcher = pattern.matcher(processResult.outputUTF8());
                matcher.find();

                int PID = Integer.parseInt(matcher.group(0));
                log.info("Found PID Appium Server: " + PID);

                PidProcess process = Processes.newPidProcess(PID);
                process.destroyGracefully();
                CommonFunctions.sleep(3000);

                log.info("Appium Server killed");
            } else {
                log.info("Port: " + port + " is free");
            }

        } catch (IOException | InterruptedException | TimeoutException e) {
            e.printStackTrace();
        }
    }

    /**
     * Function for creating ios_webkit_debug_proxy service
     * <p>
     * The ios_webkit_debug_proxy (aka iwdp) proxies requests from usbmuxd daemon over a websocket connection,
     * allowing developers to send commands to MobileSafari and UIWebViews on real and simulated iOS devices.
     *
     * @param port for communication with "proxy"
     */
    private static void iOSProxyRunner(int port) {
        if (Config.PLATFORM_NAME.equals("iOS")) {

            killiOSProxy(port);

            CommandLine iOSProxyCommand = new CommandLine("ios_webkit_debug_proxy");
            iOSProxyCommand.addArgument("-c");
            iOSProxyCommand.addArgument(Config.DEVICE_UID + ":" + port);
            iOSProxyCommand.addArgument("-F");

            DefaultExecuteResultHandler executeResultHandler = new DefaultExecuteResultHandler();
            DefaultExecutor executor = new DefaultExecutor();
            executor.setExitValue(0);

            try {
                log.info("Execute command: " + Arrays.toString(iOSProxyCommand.toStrings()));
                executor.execute(iOSProxyCommand, executeResultHandler);
                CommonFunctions.sleep(2000);
                log.info("iOS Proxy started.");
            } catch (IOException e) {
                log.error("Cannot execute command: " + Arrays.toString(iOSProxyCommand.toStrings()));
            }
        }
    }

    /**
     * Function serves for deleting process ios_webkit_debug_proxy
     *
     * @param port for communication with "proxy"
     */
    static void killiOSProxy(int port) {
        log.info("Look for the launched iOS proxy on port: " + port);
        try {
            ProcessResult processResult = new ProcessExecutor().command("lsof", "-ti", "tcp:" + port)
                    .readOutput(true).execute();

            if (processResult.getExitValue() == 0) {
                log.info("Killing iOS Proxy");

                Pattern pattern = Pattern.compile("[0-9]+");
                Matcher matcher = pattern.matcher(processResult.outputUTF8());
                matcher.find();

                int PID = Integer.parseInt(matcher.group(0));
                log.info("Found PID iOS Proxy: " + PID);

                PidProcess process = Processes.newPidProcess(PID);
                process.destroyGracefully();
                CommonFunctions.sleep(700);

                log.info("iOS Proxy killed");
            } else {
                log.info("Port: " + port + " is free");
            }

        } catch (IOException | InterruptedException | TimeoutException e) {
            e.printStackTrace();
        }
    }

    static void quitDriver() {
        try {
            if (driver != null) {
                log.info("DELETE DRIVER");
                driver.close();
                driver.quit();
                driver = null;
            }
        } catch (Exception e) {
            driver = null;
        }
    }

    static void killAppium() {
        if (Config.PLATFORM_NAME.equals(IOS)) {
            iOSProxyRunner(Config.PROXY_PORT);
        }

        try {
            if (service != null) {
                log.info("DELETE APPIUM");
                service.stop();
                service = null;
            }
        } catch (Exception e) {
            service = null;
        }
    }
}


