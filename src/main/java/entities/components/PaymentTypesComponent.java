package entities.components;

import org.openqa.selenium.By;

import static org.testng.Assert.assertTrue;

public class PaymentTypesComponent extends BaseComponent {
    By payment = By.xpath("//div[contains(@class, 'payment-types')]//span//a");

    public void purchaseWithPayPal() {
        By payPalLink = By.xpath("//a[@data-analytics-name='Paypal']");
        waitForElementVisible(payPalLink);
        getDriver().findElement(payPalLink).click();
    }

    public void purchasePayment() {
        assertTrue(isElementVisible(payment), "Payment types component doesn't present on page.");
        getDriver().findElement(payment).click();
    }

    public void choisePaymentType(String type) {
        By paymentType = By.xpath("//div[contains(text(), '" + type + "')]");
        assertTrue(isElementVisible(paymentType), "Payment type '" + type + "'  doesn't present on page.");
        getDriver().findElement(paymentType).click();
    }
}
