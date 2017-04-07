package entities.pages.pepboys;

import org.openqa.selenium.By;
import utils.CommonFunctions;

import static org.testng.AssertJUnit.assertTrue;

public class PepBoysThankYouPage extends PepBoysBasePage {


    public void checkPaymentResult() {
        By thanksMsg = By.xpath("//div[contains(@class, 'order-thank-you')]/div");
        waitForElementVisible(thanksMsg, 100);

        String message = getDriver().findElement(thanksMsg).getText().toLowerCase();
        assertTrue(message.contains("thank you for your order"));

        CommonFunctions.attachScreenshot("Thank You Page");
    }




}
