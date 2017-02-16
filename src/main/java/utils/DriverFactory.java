package utils;

import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.appium.java_client.service.local.flags.IOSServerFlag;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
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

        startAppiumService();

        if (driver == null) {
            String browserName = Config.DEVICE_BROWSER;
            String platformVersion = Config.PLATFORM_VERSION;
            String platformName = Config.PLATFORM_NAME;
            String deviceName = Config.DEVICE_NAME;
            String deviceUdid = Config.DEVICE_UID;
            String iproxyPort = Config.IPROXY_PORT;
            try {
                log.info("****************************** CREATING REMOTE WEB DRIVER ******************************");
                log.info("PLATFORM NAME: " + platformName);
                log.info("PLATFORM VERSION: " + platformVersion);
                log.info("DEVICE NAME: " + deviceName);
                log.info("DEVICE BROWSER: " + browserName);
                log.info("DEVICE UDID: " + deviceUdid);
                log.info("DEVICE USB PORT: " + iproxyPort);
                log.info("APPIUM URL: " + service.getUrl());
                log.info("****************************************************************************************");
                log.info("");

                DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browserName);
                desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
                desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
                desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
                desiredCapabilities.setCapability(MobileCapabilityType.UDID, deviceUdid);
                desiredCapabilities.setCapability(MobileCapabilityType.TAKES_SCREENSHOT, "true");

                if (Config.PLATFORM_NAME.equals("iOS")) {
                    desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                    desiredCapabilities.setCapability("wdaLocalPort", Integer.parseInt(iproxyPort));
                    desiredCapabilities.setCapability(IOSMobileCapabilityType.LAUNCH_TIMEOUT, 500000);
                    desiredCapabilities.setCapability(IOSMobileCapabilityType.TAKES_SCREENSHOT, "true");
                    // desiredCapabilities.setCapability("realDeviceLogger", "/usr/local/lib/node_modules/deviceconsole/deviceconsole");
                }

                eventListener = new MyWebDriverEventListener();

                driver = new EventFiringWebDriver(new RemoteWebDriver(new URL(String.valueOf(service.getUrl())), desiredCapabilities)).register(eventListener);
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


            } catch (Exception e) {
                throw new AssertionError("Can't create driver: " + e.getMessage());
            }
        }

        return driver;
    }

    private static void startAppiumService() {
        if (service == null) {

            int appiumPort = Integer.parseInt(Config.APPIUM_PORT);
            String proxyPort = Config.PROXY_PORT;

            killAppiumServer(appiumPort);

            log.info("");
            log.info("******************************* STARTING APPIUM SERVICE ********************************");
            log.info("APPIUM PORT: " + appiumPort);
            log.info("IOS WEB PROXY PORT: " + proxyPort);


            AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
            serviceBuilder.usingPort(appiumPort);
            if (Config.PLATFORM_NAME.equals("iOS")) {
                serviceBuilder.withArgument(IOSServerFlag.WEBKIT_DEBUG_PROXY_PORT, proxyPort);
                // serviceBuilder.withArgument(GeneralServerFlag.LOG_LEVEL, "warn");
                serviceBuilder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
            }

            service = AppiumDriverLocalService.buildService(serviceBuilder);
            service.start();
            log.info("APPIUM URL: " + service.getUrl());
            log.info("****************************************************************************************");
            log.info("");
        }
    }

    public static void quitDriver() {

        log.info("DELETE DRIVER");

        driver.quit();
        if (service != null) {
            log.info("DELETE APPIUM");
            service.stop();
        }
    }

    public static void deleteAllCookies() {
        driver.manage().deleteAllCookies();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

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

                log.info("Appium Server killed");
            } else {
                log.info("Port: " + port + " is free");
            }

        } catch (IOException | InterruptedException | TimeoutException e) {
            e.printStackTrace();
        }
    }


//    private static void initChromeDriver() {
//        System.setProperty("tests.chrome.driver", "/../../resources/chromedriver");
//        Map<String, String> mobileEmulation = new HashMap<String, String>();
//        mobileEmulation.put("deviceName", "Google Nexus 5");
//
//        Map<String, Object> chromeOptions = new HashMap<String, Object>();
//        chromeOptions.put("mobileEmulation", mobileEmulation);
//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
//        eventListener = new MyWebDriverEventListener();
//
//        driver = new EventFiringWebDriver(new ChromeDriver(capabilities)).register(eventListener);
//    }
}