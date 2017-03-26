package entities.components;

import entities.Entity;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import utils.CommonFunctions;

import static org.testng.Assert.assertEquals;

public class ErrorMessageComponent extends BaseComponent {
    private final String PATH_BASE = "//div[contains(@class, 'message-panel-form-error')]";

    private By errorTitleEl = By.xpath(PATH_BASE + "/h2");
    private By errorMessageEl = By.xpath(PATH_BASE + "/div");

    public void checkError(String title, String message) {
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(0,-300)", "");

        waitForElementVisible(errorMessageEl);

        String errorTitleText = getDriver().findElement(errorTitleEl).getText();
        String errorMessageText = getDriver().findElement(errorMessageEl).getText();

        CommonFunctions.attachScreenshot("Check error alert");

        assertEquals(errorTitleText, title, "Unexpected error title");
        assertEquals(errorMessageText, message, "Unexpected error message");

//        deleteElementFromDom(errorTitleEl);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
