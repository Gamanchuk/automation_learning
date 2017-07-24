package utils;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.ISuite;
import org.testng.ISuiteListener;

import java.io.IOException;
import java.util.Date;

public class SuiteListener implements ISuiteListener {
    private static Log log = LogFactory.getLog(SuiteListener.class.getSimpleName());

    @Override
    public void onStart(ISuite iSuite) {
        log.info(iSuite.getName());
        if (Config.PROJECT_TRACKING) {

            String runName = "Run on " + Config.DEVICE_NAME + " - " + new Date().toString();
            try {
                TestRailRunHelper.getInstance().startRun(runName);
            } catch (IOException e) {
                e.printStackTrace();
                log.error("Cannot create TestRail Run [" + runName + "]: " + e.getLocalizedMessage());
            }
        }
    }

    @Override
    public void onFinish(ISuite iSuite) {
//        DriverFactory.quitDriver();
//        DriverFactory.killAppium();
//        if (Config.PLATFORM_NAME.equals("iOS")) {
//            DriverFactory.killiOSProxy(Integer.parseInt(Config.PROXY_PORT));
//        }
    }
}
