import gherkin.formatter.model.Result;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.cucumberjvm.AllureReporter;
import utils.DriverFactory;

public class AllureReporterExt extends AllureReporter {
    @Override
    public void result(Result result) {
        if ("failed".equals(result.getStatus())) {
            attachScreenshot("failure_");
        }
        super.result(result);
    }

    @Attachment(value = "{0}", type = "image/png")
    public static byte[] attachScreenshot(String name) {
        return ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
