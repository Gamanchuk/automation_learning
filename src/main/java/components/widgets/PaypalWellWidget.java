package components.widgets;

import components.Component;
import org.openqa.selenium.By;

import static org.testng.Assert.assertEquals;

public class PaypalWellWidget extends Component {

    public void checkPayPalAccount(String account) {
        By payPalWell = By.xpath("//div[contains(@class, 'paypal-well')]");
        waitForElementVisible(payPalWell);
        assertEquals(
                getDriver().findElement(payPalWell).findElement(By.xpath("//div[@class='value']")).getText(), account, "Unexpected account used");
    }
}
