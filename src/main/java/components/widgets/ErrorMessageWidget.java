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
        waitForElementVisible(errorTitleEl);
        getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        String errorTitleText = getDriver().findElement(errorTitleEl).getText();
        String errorMessageText = getDriver().findElement(errorMessageEl).getText();

        assertEquals(errorTitleText, title, "Unexpected error title");
        assertEquals(errorMessageText, message, "Unexpected error message");
    }
}
