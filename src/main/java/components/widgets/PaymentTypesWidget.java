package components.widgets;

import components.Component;
import org.openqa.selenium.By;

public class PaymentTypesWidget extends Component {
    public void purchaseWithPayPal() {
        By payPalLink = By.xpath("//a[@data-analytics-name='Paypal']");
        waitForElementVisible(payPalLink);
        getDriver().findElement(payPalLink).click();
    }
}
