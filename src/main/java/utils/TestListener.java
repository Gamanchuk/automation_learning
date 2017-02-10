package utils;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.util.Date;

public class TestListener implements ITestListener {
    private static Log log = LogFactory.getLog(TestListener.class);


    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }


    @Override
    public void onTestFailure(ITestResult iTestResult) {

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        if (Boolean.valueOf(System.getProperty("projectTracking"))) {

            String runName = "Run on " + Config.DEVICE_NAME + " - " + new Date().toString();
            try {
                TestRailRunHelper.getInstance().startRun(runName);
                log.info("Create Run in TestRail with name: [" + runName +"]");
            } catch (IOException e) {
                e.printStackTrace();
                log.error("Cannot create TestRail Run [" + runName + "]: " + e.getLocalizedMessage());
            }
        }
    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
