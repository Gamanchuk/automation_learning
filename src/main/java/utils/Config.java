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
    public static final String APPIUM_PORT;
    public static final String PROXY_PORT;
    public static final String IPROXY_PORT;
    public static final String BOOTSTRAP_PORT;
    public static final String CHROMEDRIVER_PORT;
    public static final String BASE_URL;
    public static final String COOKIES;
    public static final String SITE_NAME;
    public static final String STORE_ID;
    public static final String ADB_PORT;

    public static final String ANALYTICS_URL = "http://mc-events.moovweb.net";

    private static Log log = LogFactory.getLog(Config.class.getSimpleName());

    static {
        Properties props = new Properties();
        String propsPath = "./profiles/envs/" + System.getProperty("environment.name") + "/" + System.getProperty("properties.file.name") + ".properties";
        try {
            props = PropertiesLoaderUtils.loadAllProperties(propsPath);
        } catch (IOException e) {
            System.out.println("'" + propsPath + "' was not found");
            e.printStackTrace();
        }


        PLATFORM_NAME = props.getProperty("platform.name");
        PLATFORM_VERSION = props.getProperty("platform.version");
        DEVICE_NAME = props.getProperty("device.name");
        DEVICE_UID = props.getProperty("device.uid");
        DEVICE_BROWSER = props.getProperty("device.browser");
        APPIUM_PORT = props.getProperty("appium.port");
        PROXY_PORT = props.getProperty("proxy.port");
        IPROXY_PORT = props.getProperty("iproxy.port");
        BOOTSTRAP_PORT = props.getProperty("bootstrap.port");
        CHROMEDRIVER_PORT = props.getProperty("chromedriver.port");
        ADB_PORT = props.getProperty("adb.port");

        BASE_URL = System.getProperty("base.url");
        COOKIES = System.getProperty("cookies");
        SITE_NAME = System.getProperty("site.name");
        STORE_ID = System.getProperty("store.key");
    }
}
