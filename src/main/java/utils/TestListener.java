package utils;


import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;
import org.testng.*;
import org.testng.annotations.ITestAnnotation;
import ru.yandex.qatools.allure.Allure;
import ru.yandex.qatools.allure.events.TestCaseFinishedEvent;
import ru.yandex.qatools.allure.events.TestCasePendingEvent;
import utils.retries.IAllureRetryAnalyzer;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

public class TestListener implements ITestListener, IAnnotationTransformer {
    private static Log log = LogFactory.getLog(TestListener.class);
    private Allure lifecycle = Allure.LIFECYCLE;

    public void transform(ITestAnnotation annotation, Class testClass,
                          Constructor testConstructor, Method testMethod) {

        IRetryAnalyzer retry = annotation.getRetryAnalyzer();
        if (retry == null) {
            annotation.setRetryAnalyzer(Retry.class);
        }
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {

        if (Config.DEVICE_NAME.equals("Android")) {
            BrowserConsoleLogAggregator.startCapturing();
        }
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        BrowserConsoleLogAggregator.stopCapturing();
        String caseName = (String) TestGlobalsManager.getTestGlobal("caseName");
        log.info("Test \"" + caseName + "\" completed in "
                + countDuration(iTestResult.getEndMillis() - iTestResult.getStartMillis()));
        if (Boolean.valueOf(System.getProperty("projectTracking"))) {
            setTestResults(TestRailStatus.PASSED, "", "");
        }
        DriverFactory.quitDriver();
    }

    @NotNull
    private String countDuration(long milis) {
        int durationInSeconds = Math.round(milis / 1000);
        int minutes = Math.round(durationInSeconds / 60);
        int seconds = durationInSeconds % 60;
        return minutes + ":" + seconds;
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        BrowserConsoleLogAggregator.stopCapturing();
        File androidLog = new File("android_browser.log");

        String caseName = (String) TestGlobalsManager.getTestGlobal("caseName");
        String dom = CommonFunctions.attachDomThree(DriverFactory.getDriver().getPageSource());
        String errorMessage = String.valueOf(iTestResult.getThrowable().getMessage());

        log.info("Test \"" + iTestResult.getName() + "\" failed in "
                + countDuration(iTestResult.getEndMillis() - iTestResult.getStartMillis()));

        if (Boolean.valueOf(System.getProperty("projectTracking"))) {
            String ticketId = setJiraIssues(caseName, errorMessage);
            try {
                File attachment = File.createTempFile("attachment", ".html");
                FileUtils.writeStringToFile(attachment, dom, "UTF-8");
                JiraHelper.addAttachment(ticketId, attachment);
                JiraHelper.addAttachment(ticketId, androidLog);
            } catch (IOException e) {
                e.printStackTrace();
            }
            setTestResults(TestRailStatus.FAILED, errorMessage, JiraHelper.doLinkToIssue(ticketId));
        }

        DriverFactory.quitDriver();
        fireRetryTest("The test has been failed then retried.", iTestResult);
    }

    private void setTestResults(TestRailStatus status, String error, String issuesLink) {
        try {
            ArrayList<String> ids = (ArrayList<String>) TestGlobalsManager.getTestGlobal("testCaseIds");
            if (ids != null) {
                for (String id : ids) {
                    TestRailRunHelper.getInstance().setTestResult(id, status, error, issuesLink);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String setJiraIssues(String caseName, String result) {
        String ticketId = null;

        try {
            ticketId = JiraHelper.publishJira(
                    "Automation - \"" + caseName + "\" failed",
                    "{noformat}\n" + result + "\n{noformat}",
                    Config.DEVICE_NAME + " " + Config.PLATFORM_NAME + " " + Config.PLATFORM_VERSION,
                    caseName,
                    result);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return ticketId;
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        BrowserConsoleLogAggregator.stopCapturing();
        log.info("Test \"" + iTestResult.getTestName() + "\" skipped");
        DriverFactory.quitDriver();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        fireRetryTest("The test has been failed (within success percentage) then retried.", iTestResult);
        BrowserConsoleLogAggregator.stopCapturing();
        DriverFactory.quitDriver();
    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        Iterator<ITestResult> listOfFailedTests = iTestContext.getFailedTests().getAllResults().iterator();
        while (listOfFailedTests.hasNext()) {
            ITestResult failedTest = listOfFailedTests.next();
            ITestNGMethod method = failedTest.getMethod();
            if (iTestContext.getPassedTests().getResults(method).size() > 0) {
                listOfFailedTests.remove();
            }
        }

    }

    /**
     * Fires Retry test if it allowed by <code>RetryAnalyzer</code>
     * and set 'Pending' status for test result.
     *
     * @param message <code>String</code> message which will thrown like explanation
     * @param result  <code>ITestResult</code> containing information about the run test
     */
    protected void fireRetryTest(String message, ITestResult result) {
        if (((IAllureRetryAnalyzer) result.getMethod().getRetryAnalyzer()).retry(result, true)) {
            getLifecycle().fire(new TestCasePendingEvent().withMessage(message));
            getLifecycle().fire(new TestCaseFinishedEvent());
        }
    }

    /**
     * Get current Allure lifecycle
     *
     * @return current Allure lifecycle
     */
    protected Allure getLifecycle() {
        return lifecycle;
    }
}
