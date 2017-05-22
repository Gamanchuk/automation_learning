package entities.components;

import org.openqa.selenium.By;
import utils.CommonFunctions;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ErrorMessageComponent extends BaseComponent {
    private final String ERROR_MESSAGE = "//div[contains(@class, 'message-panel-form-error') or contains(@class, 'message-panel-error')]";

    private By errorTitleEl = By.xpath(ERROR_MESSAGE + "/h2");
    private By errorMessageEl = By.xpath(ERROR_MESSAGE + "/div");

    public void checkError(String title, String message) {
        javascriptScroll(-300);

        CommonFunctions.sleep(2500);

        assertTrue(isElementVisible(By.xpath(ERROR_MESSAGE)), "Error message was not displayed");

        String errorTitleText = getDriver().findElement(errorTitleEl).getText();
        String errorMessageText = getDriver().findElement(errorMessageEl).getText();

        CommonFunctions.attachScreenshot("Check error alert");

        assertEquals(errorTitleText, title, "Unexpected error title");
        assertEquals(errorMessageText, message, "Unexpected error message");

        javascriptScroll(300);
    }
}
