package components.pages.pepboys;

import org.openqa.selenium.By;

public class PepBoysCartPage extends PepBoysBasePage {
    public void payUsingPaymentMethod(String method) {
        if (method.equals("Pay Online")) {
            click(By.id("j-payOnline"));
        } else if(method.equals("PayPal")) {
            click(By.id("j-payPalCheckout"));
        }
        waitForElementVisible(By.xpath("//*[text()='Secure Checkout']"));
    }
}
