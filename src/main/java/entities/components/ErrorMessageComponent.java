package entities.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

        assertTrue(isExist(), "Error message was not displayed");
        CommonFunctions.attachScreenshot("Check error alert");

        assertEquals(getDriver().findElement(errorTitleEl).getText(), title, "Unexpected error title");
        assertEquals(getDriver().findElement(errorMessageEl).getText(), message, "Unexpected error message");

        javascriptScroll(300);
    }

    public boolean hasErrorTooltipWithMessage(String error) {
        assertTrue(isElementVisible(By.cssSelector("div.tooltip.error")), "Error tooltip doesn't present.");

        // Have to use complex selector, because label can be either on span or on div
        String selector = "div.tooltip.error div.tooltip-contents span, div.tooltip.error div.tooltip-contents div";
        WebElement messageEl = findElementWithTextBy(error, By.cssSelector(selector));
        return messageEl != null;
    }

    @Override
    public boolean isExist() {
        return isElementVisible(By.xpath(ERROR_MESSAGE));
    }

    @Override
    public boolean isExist(int timeout) {
        return isElementVisible(By.xpath(ERROR_MESSAGE), timeout);
    }
}
