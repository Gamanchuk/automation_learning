package utils;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Properties;

@Component
public class Config {

    public static final String PLATFORM_NAME;
    public static final String PLATFORM_VERSION;
    public static final String DEVICE_NAME;
    public static final String DEVICE_UID;
    public static final String DEVICE_BROWSER;
    public static final int APPIUM_PORT;
    public static final int PROXY_PORT;
    public static final int IPROXY_PORT;
    public static final String BOOTSTRAP_PORT;
    public static final String CHROMEDRIVER_PORT;

    public static final String BASE_URL;
    public static final String COOKIES;
    public static final String SITE_NAME;
    public static final String STORE_ID;

    public static final boolean XCODE_LOGS;
    public static final boolean APPIUM_LOGS;
    public static final boolean PROJECT_TRACKING;

    public static final String PR_NUMBER;
    public static final boolean PR_LOADER;

    static final int TESTRAIL_PROJECT_ID;


    public static final String ANALYTICS_URL = "http://mc-events.moovweb.net";


    private static Log log = LogFactory.getLog(Config.class.getSimpleName());

    static {
        Properties props = new Properties();
        String propsPath = "./profiles/envs/" + System.getProperty("environment.name") + "/" + System.getProperty("properties.file.name") + ".properties";
        try {
            props = PropertiesLoaderUtils.loadAllProperties(propsPath);
        } catch (IOException e) {
            log.error("'" + propsPath + "' was not found");
            log.error(e.getMessage());
        }


        /* Device property */
        PLATFORM_NAME = props.getProperty("platform.name");
        PLATFORM_VERSION = props.getProperty("platform.version");
        DEVICE_NAME = props.getProperty("device.name");
        DEVICE_UID = props.getProperty("device.uid");
        DEVICE_BROWSER = props.getProperty("device.browser");

        /* Appium property */
        log.info(props.getProperty("appium.port"));
        APPIUM_PORT = Integer.parseInt(props.getProperty("appium.port"));
        PROXY_PORT = Integer.parseInt(props.getProperty("proxy.port"));
        log.info(props.getProperty("iproxy.port"));
        IPROXY_PORT = Integer.parseInt(props.getProperty("iproxy.port"));
        BOOTSTRAP_PORT = props.getProperty("bootstrap.port");
        CHROMEDRIVER_PORT = props.getProperty("chromedriver.port");
        XCODE_LOGS = Boolean.parseBoolean(System.getProperty("xcode.logs"));
        APPIUM_LOGS = Boolean.parseBoolean(System.getProperty("appium.logs"));
        PROJECT_TRACKING = Boolean.parseBoolean(System.getProperty("project.tracking"));

        /* Site (Dev) property */
        PR_NUMBER = System.getProperty("mw.pr.number");
        PR_LOADER = Boolean.parseBoolean(System.getProperty("mw.pr.loader"));

        /* Site property */
        BASE_URL = System.getProperty("base.url");
        COOKIES = System.getProperty("cookies");
        SITE_NAME = System.getProperty("site.name");
        STORE_ID = System.getProperty("store.key");

        TESTRAIL_PROJECT_ID = Integer.parseInt(System.getProperty("testrail.id"));
    }
}
