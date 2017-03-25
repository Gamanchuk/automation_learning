package entities.components;

import entities.Component;
import org.openqa.selenium.By;

public class PaymentTypesComponent extends Component {
    public void purchaseWithPayPal() {
        By payPalLink = By.xpath("//a[@data-analytics-name='Paypal']");
        waitForElementVisible(payPalLink);
        getDriver().findElement(payPalLink).click();
    }
}
