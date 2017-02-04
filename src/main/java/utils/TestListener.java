package utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.yandex.qatools.allure.Allure;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

import java.lang.reflect.Method;

/**
 * Created by vnaksimenko on 27.11.16.
 */
public class TestListener implements ITestListener {
    private Log log = LogFactory.getLog(this.getClass());
    Allure lifecycle = Allure.LIFECYCLE;

    @Override
    public void onTestStart(ITestResult iTestResult) {
        log.info("");
        log.info("Starring test: " + iTestResult.getName());
        log.info("");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
//        Method testMethod = iTestResult.getMethod().getConstructorOrMethod().getMethod();
//        if (testMethod.isAnnotationPresent(TestCase.class)) {
//            int caseId = Integer.parseInt(testMethod.getAnnotation(TestCase.class).value());
//            try {
//                TestRailRunHelper.getInstance().setTestResult(caseId, TestRailStatus.PASSED, "", "");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }

    @Step("Test failed, see screenshot")
    @Override
    public void onTestFailure(ITestResult iTestResult) {
        attachScreenshot("failure_" + iTestResult.getName());
        String trace = "Class Name: " + Thread.currentThread().getStackTrace()[1].getClassName()
                + "Method: " + " " + Thread.currentThread().getStackTrace()[1].getMethodName()
                + "Line: " + " " + Thread.currentThread().getStackTrace()[1].getLineNumber();

       // CommonFunctions.log("trace", trace);

        Method testMethod = iTestResult.getMethod().getConstructorOrMethod().getMethod();
        String errorMessage = iTestResult.getThrowable().getMessage();
        String ticketId = "";

//        try {
//            ticketId = JiraHelper.publishJira(
//                    "Automation - \"" + testMethod.getName() + "\" failed",
//                    "{noformat}" + errorMessage + "{noformat}");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        if (testMethod.isAnnotationPresent(TestCase.class)) {
//            int caseId = Integer.parseInt(testMethod.getAnnotation(TestCase.class).value());
//            try {
//                TestRailRunHelper.getInstance().setTestResult(caseId, TestRailStatus.FAILED, iTestResult.getThrowable().getMessage(), ticketId);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
//        try {
//            TestRailRunHelper.getInstance().startRun(
//                    "Run on " + System.getProperty("device.name") + " - " + new Date().toString()
//            );
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        //DriverFactory.quitDriver();
    }

    @Attachment(value = "{0}", type = "image/png")
    public static byte[] attachScreenshot(String name) {
        return ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    protected Allure getLifecycle() {
        return lifecycle;
    }

}
