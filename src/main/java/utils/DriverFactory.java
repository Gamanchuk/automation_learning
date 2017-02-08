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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class DriverFactory {
    private static EventFiringWebDriver driver;
    private static AppiumDriverLocalService service;
    private static WebDriverEventListener eventListener;
    private static Log log = LogFactory.getLog(DriverFactory.class);


    public static WebDriver getDriver() {

            startAppiumService();

            if (driver == null) {
                String browserName = System.getProperty("device.browser");
                String platformVersion = System.getProperty("device.platform.version");
                String platformName = System.getProperty("device.platform.name");
                String deviceName = System.getProperty("device.name");
                String deviceUdid = System.getProperty("device.uid");
                String iproxyPort = System.getProperty("iproxy.port");

                try {
                    log.info("****************************** CREATE REMOTE WEB DRIVER ********************************");
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

                    if (System.getProperty("device.platform.name").equals("iOS")) {
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

            return  driver;
        }

    private static void startAppiumService() {
        if (service == null) {

            System.out.println(System.getProperty("appium.port"));
            int appiumPort = Integer.parseInt(System.getProperty("appium.port"));
            String proxyPort = System.getProperty("proxy.port");

            log.info("");
            log.info("******************************* STARTING APPIUM SERVICE ********************************");
            log.info("APPIUM PORT: " + appiumPort);
            log.info("IOS WEB PROXY PORT: " + proxyPort);


            AppiumServiceBuilder serviceBuilder = new AppiumServiceBuilder();
            serviceBuilder.usingPort(appiumPort);
            if (System.getProperty("device.platform.name").equals("iOS")) {
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

//    private static WebDriver initChromeDriver() {
//        if(driver == null) {
//            System.setProperty("webdriver.chrome.driver", "/Users/eugene/Project/moovweb-automation/src/main/resources/chromedriver");
//            Map<String, String> mobileEmulation = new HashMap<String, String>();
//            mobileEmulation.put("deviceName", "Google Nexus 5");
//
//            Map<String, Object> chromeOptions = new HashMap<String, Object>();
//            chromeOptions.put("mobileEmulation", mobileEmulation);
//            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//            capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
//            eventListener = new MyWebDriverEventListener();
//
//            driver = new EventFiringWebDriver(new ChromeDriver(capabilities)).register(eventListener);
//        }
//        return driver;
//    }
}