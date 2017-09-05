package entities.components;

import org.openqa.selenium.By;
import utils.CommonFunctions;

import static org.testng.Assert.assertTrue;

public class PaymentTypesComponent extends BaseComponent {

    private By payment = By.xpath("//div[contains(@class, 'payment-types')]//span//a");
    private By payPalLink = By.xpath("//a[@data-analytics-name='Paypal']");

    public void purchaseWithPayPal() {
        getDriver().findElement(payPalLink).click();
    }

    public void purchasePayment() {
        assertTrue(isElementVisible(payment), "Payment types component doesn't present on page.");
        getDriver().findElement(payment).click();
    }

    public void choicePaymentType(String type) {
        setRoot(null);
        By paymentType = By.xpath("//div[contains(@class, 'payment-methods-dropdown-item') and contains(.,'" + type + "')]");
        assertTrue(isElementVisible(paymentType), "Payment type '" + type + "'  doesn't present on page.");
        CommonFunctions.sleep(1000);
        getDriver().findElement(paymentType).click();
    }

    @Override
    public boolean isExist() {
        return isElementVisible(payPalLink);
    }

    @Override
    public boolean isExist(int timeout) {
        return isElementVisible(payPalLink, timeout);
    }
}
