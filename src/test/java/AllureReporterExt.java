import gherkin.formatter.model.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.yandex.qatools.allure.Allure;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.cucumberjvm.AllureReporter;
import utils.DriverFactory;
import utils.JiraHelper;

import java.io.IOException;

public class AllureReporterExt extends AllureReporter {
    private static Log log = LogFactory.getLog(DriverFactory.class);
    private Scenario scenario;
    Allure allure = Allure.LIFECYCLE;




    @Override
    public void scenario(Scenario scenario) {
        this.scenario = scenario;
    }


    @Override
    public void result(Result result) {
        if ("failed".equals(result.getStatus())) {

            attachScreenshot("failure screenshot");
            log.info("Sena: " + scenario.getName());


            if (Boolean.valueOf(System.getProperty("projectTracking"))) {

                String ticketId = "";

                try {
                    ticketId = JiraHelper.publishJira(
                            "Automation - \"" + scenario.getName() + "\" failed",
                            "{noformat}" + result.getError()+ "\n" + scenario.getId() +  "{noformat}");

                    log.info("ticketId: " + ticketId);

                } catch (IOException e) {
                    e.printStackTrace();
                }

//                if (testMethod.isAnnotationPresent(TestCase.class)) {
//                    int caseId = Integer.parseInt(testMethod.getAnnotation(TestCase.class).value());
//                    try {
//                        TestRailRunHelper.getInstance().setTestResult(caseId, TestRailStatus.FAILED, iTestResult.getThrowable().getMessage(), ticketId);
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
            }

        }
        super.result(result);
    }


    @Attachment(value = "{0}", type = "image/png")
    public static byte[] attachScreenshot(String name) {
        return ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
