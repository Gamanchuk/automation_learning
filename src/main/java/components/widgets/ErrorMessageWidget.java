package components.widgets;

import components.Component;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class ErrorMessageWidget extends Component {
    private final String PATH_BASE = "//div[contains(@class, 'message-panel-form-error')]";

    private By errorTitleEl = By.xpath(PATH_BASE + "/h2");
    private By errorMessageEl = By.xpath(PATH_BASE + "/div");

    public void checkError(String title, String message) {
        getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        String errorTitleText = getDriver().findElement(errorTitleEl).getText();
        String errorMessageText = getDriver().findElement(errorMessageEl).getText();

        assertEquals("Unexpected error title", title, errorTitleText);
        assertEquals("Unexpected error message", message, errorMessageText);
    }
}
