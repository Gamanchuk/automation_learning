package components.widgets;

import components.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import utils.CommonFunctions;

import static org.testng.Assert.assertEquals;

public class ErrorMessageWidget extends Component {
    private final String PATH_BASE = "//div[contains(@class, 'message-panel-form-error')]";

    private By errorTitleEl = By.xpath(PATH_BASE + "/h2");
    private By errorMessageEl = By.xpath(PATH_BASE + "/div");

    public void checkError(String title, String message) {
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(0,-300)", "");

        waitForElementVisible(errorTitleEl);

        String errorTitleText = getDriver().findElement(errorTitleEl).getText();
        String errorMessageText = getDriver().findElement(errorMessageEl).getText();

        CommonFunctions.attachScreenshot("Check error alert");

        assertEquals(errorTitleText, title, "Unexpected error title");
        assertEquals(errorMessageText, message, "Unexpected error message");

        deleteElementFromDom(By.xpath(PATH_BASE));


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
