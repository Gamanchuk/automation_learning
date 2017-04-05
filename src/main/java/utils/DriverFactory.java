package utils;

import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.appium.java_client.service.local.flags.IOSServerFlag;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DriverFactory {
    private static EventFiringWebDriver driver;
    private static AppiumDriverLocalService service;
    private static WebDriverEventListener eventListener;
    private static Log log = LogFactory.getLog(DriverFactory.class);


    public static WebDriver getDriver() {

        if (!Boolean.valueOf(System.getProperty("use.desktop.browser"))) {
            startAppiumService();
        }

        if (driver == null) {

            String browserName = Config.DEVICE_BROWSER;
            String platformVersion = Config.PLATFORM_VERSION;
            String platformName = Config.PLATFORM_NAME;
            String deviceName = Config.DEVICE_NAME;
            String deviceUdid = Config.DEVICE_UID;
            String iproxyPort = Config.IPROXY_PORT;

            try {
                if (Boolean.valueOf(System.getProperty("use.desktop.browser"))) {
                    initChromeDriver();
                } else {

                    log.info("**************************** CREATING REMOTE WEB DRIVER ***************************");
                    log.info("PLATFORM NAME: " + platformName);
                    log.info("PLATFORM VERSION: " + platformVersion);
                    log.info("DEVICE NAME: " + deviceName);
                    log.info("DEVICE BROWSER: " + browserName);
                    log.info("DEVICE UDID: " + deviceUdid);
                    log.info("DEVICE USB PORT: " + iproxyPort);
                    log.info("APPIUM URL: " + service.getUrl());
                    log.info("***********************************************************************************");
                    log.info("");

                    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                    desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browserName);
                    desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
                    desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
                    desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
                    desiredCapabilities.setCapability(MobileCapabilityType.UDID, deviceUdid);

                    if (Config.PLATFORM_NAME.equals("iOS")) {
                        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                        desiredCapabilities.setCapability("wdaLocalPort", Integer.parseInt(iproxyPort));
                        desiredCapabilities.setCapability(IOSMobileCapabilityType.LAUNCH_TIMEOUT, 500000);
                        desiredCapabilities.setCapability("useNewWDA", true);
                        //desiredCapabilities.setCapability("startIWDP", true);
                        desiredCapabilities.setCapability("preventWDAAttachments", true);
                        desiredCapabilities.setCapability("xcodeOrgId", "Y95G5M3Q84");
                        desiredCapabilities.setCapability("xcodeSigningId", "iPhone Developer");
                        desiredCapabilities.setCapability("updatedWDABundleId", "com.moovweb.WebDriverAgentRunner");


                    }

                    eventListener = new MyWebDriverEventListener();

                    driver = new EventFiringWebDriver(new RemoteWebDriver(new URL(String.valueOf(service.getUrl())), desiredCapabilities)).register(eventListener);
                    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                }

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

            int appiumPort = Integer.parseInt(Config.APPIUM_PORT);
            int proxyPort = Integer.parseInt(Config.PROXY_PORT);

            if (Config.PLATFORM_NAME.equals("iOS")) {
                iOSProxyRunner(proxyPort);
            }

            killAppiumServer(appiumPort);

            log.info("");
            log.info("******************************* STARTING APPIUM SERVICE ***********************************");
            log.info("APPIUM PORT: " + appiumPort);
            log.info("IOS WEB PROXY PORT: " + proxyPort);


            AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
            serviceBuilder.usingPort(appiumPort);
            if (Config.PLATFORM_NAME.equals("iOS")) {
                serviceBuilder.withArgument(IOSServerFlag.WEBKIT_DEBUG_PROXY_PORT, String.valueOf(proxyPort));
                //serviceBuilder.withArgument(GeneralServerFlag.LOG_LEVEL, "warn");
                serviceBuilder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
            }

            service = AppiumDriverLocalService.buildService(serviceBuilder);
            service.start();
            log.info("APPIUM URL: " + service.getUrl());
            log.info("*******************************************************************************************");
            log.info("");
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
                Thread.sleep(3000);

                log.info("Appium Server killed");
            } else {
                log.info("Port: " + port + " is free");
            }

        } catch (IOException | InterruptedException | TimeoutException e) {
            e.printStackTrace();
        }
    }

    /**
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
                Thread.sleep(3000);
                log.info("iOS Proxy started.");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Function serves for deleting process ios_webkit_debug_proxy
     *
     * @param port for communication with "proxy"
     */
    public static void killiOSProxy(int port) {
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
                Thread.sleep(700);

                log.info("iOS Proxy killed");
            } else {
                log.info("Port: " + port + " is free");
            }

        } catch (IOException | InterruptedException | TimeoutException e) {
            e.printStackTrace();
        }
    }

    public static void quitDriver() {
        log.info("DELETE DRIVER");
        driver.close();
        driver.quit();
        driver = null;
    }

    public static void killAppium() {
        if (service != null) {
            log.info("DELETE APPIUM");
            service.stop();
            service = null;
        }
    }

    public static void startVideoRecording() {
        log.info("Start video recording.");

        CommandLine recorderStart = new CommandLine("/usr/local/bin/flick");
        recorderStart.addArgument("video");
        recorderStart.addArgument("-a");
        recorderStart.addArgument("start");
        recorderStart.addArgument("-p");
        recorderStart.addArgument(Config.PLATFORM_NAME.toLowerCase());
        recorderStart.addArgument("-u");
        recorderStart.addArgument(Config.DEVICE_UID);
        recorderStart.addArgument("-e");
        recorderStart.addArgument("true");

        DefaultExecuteResultHandler executeResultHandler = new DefaultExecuteResultHandler();
        DefaultExecutor executor = new DefaultExecutor();
        executor.setExitValue(0);

        try {
            System.out.println("Waiting for executing. Command: " + Arrays.toString(recorderStart.toStrings()));
            executor.execute(recorderStart, executeResultHandler);
            executeResultHandler.waitFor(5000);
            System.out.println("Command executed. Exit code: " + executeResultHandler.getExitValue());
        } catch (InterruptedException | IOException e) {
            log.error("Cannot execute command: " + Arrays.toString(recorderStart.toStrings()));
        }
    }

    public static void stopScreenVideo() {
        log.info("Stop video recording. Move temp video file to: " + System.getProperty("user.dir"));

        CommandLine recorderStop = new CommandLine("/usr/local/bin/flick");
        recorderStop.addArgument("video");
        recorderStop.addArgument("-a");
        recorderStop.addArgument("stop");
        recorderStop.addArgument("-p");
        recorderStop.addArgument(Config.PLATFORM_NAME.toLowerCase());
        recorderStop.addArgument("-u");
        recorderStop.addArgument(Config.DEVICE_UID);
        recorderStop.addArgument("-e");
        recorderStop.addArgument("true");
        recorderStop.addArgument("-o");
        recorderStop.addArgument(System.getProperty("user.dir"));
        recorderStop.addArgument("-f");
        recorderStop.addArgument("mp4");
        recorderStop.addArgument("-t");

        DefaultExecuteResultHandler executeResultHandler = new DefaultExecuteResultHandler();
        DefaultExecutor executor = new DefaultExecutor();
        executor.setExitValue(0);

        try {
            System.out.println("Waiting for executing. Command: " + Arrays.toString(recorderStop.toStrings()));
            executor.execute(recorderStop, executeResultHandler);
            executeResultHandler.waitFor(20000);
            Thread.sleep(40000);
            System.out.println("Command executed. Exit code: " + executeResultHandler.getExitValue());
        } catch (InterruptedException | IOException e) {
            log.error("Cannot execute command: " + Arrays.toString(recorderStop.toStrings()));
        }

    }

    //TODO: add functionality delete cookies
    public static void deleteAllCookies() {

    }

    private static void initChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        Map<String, String> mobileEmulation = new HashMap<String, String>();
        mobileEmulation.put("deviceName", "Google Nexus 5");

        Map<String, Object> chromeOptions = new HashMap<String, Object>();
        chromeOptions.put("mobileEmulation", mobileEmulation);
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        eventListener = new MyWebDriverEventListener();

        driver = new EventFiringWebDriver(new ChromeDriver(capabilities)).register(eventListener);
    }
}


