package entities.components;

import entities.Entity;
import org.openqa.selenium.By;

public class PaymentTypesComponent extends BaseComponent {
    public void purchaseWithPayPal() {
        By payPalLink = By.xpath("//a[@data-analytics-name='Paypal']");
        waitForElementVisible(payPalLink);
        getDriver().findElement(payPalLink).click();
    }
}
