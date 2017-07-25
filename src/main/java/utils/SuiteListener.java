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
        log.info("\n\n");
        log.info(String.format("**************************** Starting suite: %s ***************************", iSuite.getName().toUpperCase()));
        runNewTesRailRun();
        log.info("****************************************************************************************");
    }

    @Override
    public void onFinish(ISuite iSuite) {

    }

    private void runNewTesRailRun() {
        if (Config.PROJECT_TRACKING) {
            String runName = "Run on " + Config.DEVICE_NAME + " - " + new Date().toString();
            log.info(String.format("Running TestRail run with name: \"%s\"", runName));
            try {
                TestRailRunHelper.getInstance().startRun(runName);
            } catch (IOException e) {
                log.error("Cannot create TestRail Run [" + runName + "]: " + e.getLocalizedMessage());
            }
        }
    }
}
