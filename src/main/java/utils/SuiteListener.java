package utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.ISuite;
import org.testng.ISuiteListener;

public class SuiteListener implements ISuiteListener {
    private Log log = LogFactory.getLog(this.getClass());

    @Override
    public void onStart(ISuite iSuite) {
        log.info("Starring suite: " + iSuite.getName());
    }

    @Override
    public void onFinish(ISuite iSuite) {
        log.info("Finishing suite: " + iSuite.getName());
        DriverFactory.quitDriver();

    }
}
