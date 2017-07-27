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
        log.info(String.format("Suite \"%s\" started", iSuite.getName().toUpperCase()));
        log.info("PR pront");
        log.info(Config.PROJECT_TRACKING);
        runNewTesRailRun();
        log.info("PR");
    }

    @Override
    public void onFinish(ISuite iSuite) {
        log.info(String.format("Suite \"%s\" finished", iSuite.getName().toUpperCase()));
        DriverFactory.killAppium();
        DriverFactory.quitDriver();
    }

    private void runNewTesRailRun() {
        if (Config.PROJECT_TRACKING) {
            String runName = String.format("Run on %s - %s", Config.DEVICE_NAME, new Date().toString());
            log.info(runName);

            try {
                TestRailRunHelper.getInstance().startRun(runName);
            } catch (IOException e) {
                log.error(String.format("Cannot create TestRail Run: %s", e.getMessage()));
            }
        }
    }
}
