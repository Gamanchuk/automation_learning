package utils;


import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriverException;
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

import static io.appium.java_client.remote.MobilePlatform.ANDROID;

public class TestListener implements ITestListener, IAnnotationTransformer {
    private static Log log = LogFactory.getLog(TestListener.class.getSimpleName());
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
        log.info("\n\n");
        log.info(String.format("Starting TestCase: %s", iTestResult.getTestName()));

        if (Config.DEVICE_NAME.equals("Android")) {
            BrowserConsoleLogAggregator.startCapturing();
        }
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        String caseName = (String) TestGlobalsManager.getTestGlobal("caseName");
        String duration = countDuration(iTestResult.getEndMillis() - iTestResult.getStartMillis());

        // If test success we don't need console logs
        BrowserConsoleLogAggregator.stopCapturing();

        log.info(String.format("Test \"%s\" completed in %s", caseName, duration));

        if (Config.PROJECT_TRACKING) {
            setTestResults(TestRailStatus.PASSED, "", "");
        }

        DriverFactory.quitDriver();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

        String caseName = (String) TestGlobalsManager.getTestGlobal("caseName");
        log.info(String.format("Looks like Test \"%s\" failed and skipped for retry", caseName));

        try {
            BrowserConsoleLogAggregator.stopCapturing();
            File androidLog = new File("android_browser.log");
            CommonFunctions.attachFile("Browser console log", androidLog);

            // Checking driver state.
            CommonFunctions.attachDomThree(DriverFactory.getDriver().getPageSource());

        } catch (WebDriverException e) {
            log.error("[SKIPPED] looks like we have problem with WebDriver/Appium/WDAServer/ios-webkit. Restart services and test");
            log.error(e.getMessage());

            DriverFactory.quitDriver();
            DriverFactory.killAppium();
            fireRetryTest("The test has been failed then retried.", iTestResult);
        }
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        try {
            String ticketId;
            String caseName = (String) TestGlobalsManager.getTestGlobal("caseName");
            String duration = countDuration(iTestResult.getEndMillis() - iTestResult.getStartMillis());
            log.error(String.format("Test \"%s\" failed in %s", caseName, duration));


            String errorMessage = String.valueOf(iTestResult.getThrowable().getMessage());

            // Create Jira issue and sets TestRail status
            if (Config.PROJECT_TRACKING) {

                //Create Jira issue and get ticket id
                ticketId = setJiraIssues(caseName, errorMessage);

                // Set result in TestRail
                setTestResults(TestRailStatus.FAILED, errorMessage, JiraHelper.doLinkToIssue(ticketId));

                // Attache in to issue: logs , video
                attachIssueData(ticketId, caseName, errorMessage);

                // Attache Dom Xml
                String dom = CommonFunctions.attachDomThree(DriverFactory.getDriver().getPageSource());
                sendDomXml(ticketId, dom);
            }

        } catch (WebDriverException e) {
            log.info("[FAILED] looks like we have problem with WebDriver/Appium/WDAServer/ios-webkit. Restart services and test");
        } finally {
            DriverFactory.quitDriver();
            // DriverFactory.killAppium();
            fireRetryTest("The test has been failed then retried.", iTestResult);
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

    @NotNull
    private String countDuration(long milis) {
        int durationInSeconds = Math.round(milis / 1000);
        int minutes = Math.round(durationInSeconds / 60);
        int seconds = durationInSeconds % 60;
        return minutes + ":" + seconds;
    }

    @SuppressWarnings(value = "unchecked")
    private void setTestResults(TestRailStatus status, String error, String issuesLink) {
        try {
            ArrayList<String> ids = (ArrayList<String>) TestGlobalsManager.getTestGlobal("testCaseIds");
            if (ids != null) {
                for (String id : ids) {
                    TestRailRunHelper.getInstance().setTestResult(id, status, error, issuesLink);
                }
            }
        } catch (IOException e) {
            log.error("Problem with setting test result. Error: " + e.getMessage());
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
            log.error("Problem with creating jira issue. Error: " + e.getMessage());
        }

        return ticketId;
    }

    private void attachIssueData(String ticketId, String caseName, String errorMessage) {
        BrowserConsoleLogAggregator.stopCapturing();
        File androidLog = new File("android_browser.log");
        CommonFunctions.attachFile("Browser console log", androidLog);

        if (Config.PROJECT_TRACKING) {

            // Attach test video
            File video = new File(System.getProperty("user.dir") + "/target/" + Config.DEVICE_UID + ".mp4");
            JiraHelper.addAttachment(ticketId, video);

            // Attach android logs
            if (Config.PLATFORM_NAME.equals(ANDROID)) {
                JiraHelper.addAttachment(ticketId, androidLog);
            }
        }
    }

    private void sendDomXml(String ticketId, String domXml) {
        if (Config.PROJECT_TRACKING) {
            // Attach page DOM XML
            JiraHelper.addAttachment(ticketId, createTempDomXML(domXml));
        }
    }

    private File createTempDomXML(String dom) {
        File attachment = null;
        try {
            attachment = File.createTempFile("attachment", ".html");
            FileUtils.writeStringToFile(attachment, dom, "UTF-8");
        } catch (IOException e) {
            log.error("Problems with creating temp .html file.");
        }
        return attachment;
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        log.info("onTestFailedButWithinSuccessPercentage");
        fireRetryTest("The test has been failed (within success percentage) then retried.", iTestResult);
        BrowserConsoleLogAggregator.stopCapturing();
        DriverFactory.quitDriver();
    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}

