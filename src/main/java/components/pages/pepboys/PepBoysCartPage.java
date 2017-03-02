package components.pages.pepboys;

import org.openqa.selenium.By;
import utils.CommonFunctions;

public class PepBoysCartPage extends PepBoysBasePage {
    public void payUsingPaymentMethod(String method) {
        if (method.equals("Pay Online")) {
            click(By.id("j-payOnline"));

            CommonFunctions.attachScreenshot("Payment method");
            waitForElementVisible(By.xpath("//button[text()='Continue']"));
            waitForElementClickable(By.xpath("//button[text()='Continue']"));
        } else if (method.equals("PayPal")) {
            click(By.id("j-payPalCheckout"));

            CommonFunctions.attachScreenshot("Payment method");
        }

    }
}
