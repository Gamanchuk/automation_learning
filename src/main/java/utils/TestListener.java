package utils;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.*;
import org.testng.annotations.ITestAnnotation;
import ru.yandex.qatools.allure.Allure;
import ru.yandex.qatools.allure.events.TestCaseFinishedEvent;
import ru.yandex.qatools.allure.events.TestCasePendingEvent;
import utils.retries.IAllureRetryAnalyzer;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Iterator;

public class TestListener implements ITestListener, IAnnotationTransformer {
    private static Log log = LogFactory.getLog(TestListener.class);
    private Allure lifecycle = Allure.LIFECYCLE;

    public void transform(ITestAnnotation annotation, Class testClass,
                          Constructor testConstructor, Method testMethod) {

//        IRetryAnalyzer retry = annotation.getRetryAnalyzer();
//        if (retry == null) {
//            annotation.setRetryAnalyzer(Retry.class);
//        }
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }


    @Override
    public void onTestFailure(ITestResult iTestResult) {
        //fireRetryTest("The test has been failed then retried.", iTestResult);
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
//        Iterator<ITestResult> listOfFailedTests = iTestContext.getFailedTests().getAllResults().iterator();
//        while (listOfFailedTests.hasNext()) {
//            ITestResult failedTest = listOfFailedTests.next();
//            ITestNGMethod method = failedTest.getMethod();
//            if (iTestContext.getPassedTests().getResults(method).size() > 0) {
//                listOfFailedTests.remove();
//            }
//        }

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
