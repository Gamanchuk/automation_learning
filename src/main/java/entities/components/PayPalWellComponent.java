package entities.components;

import org.openqa.selenium.By;

public class PayPalWellComponent extends BaseComponent {
    private By payPalWell = By.xpath("//div[contains(@class, 'paypal-display')]");

    public String getPayPalAccountText() {
        return getDriver().findElement(payPalWell).findElement(By.xpath("//div[@class='value']")).getText();
    }

    @Override
    public boolean isExist() {
        return isElementVisible(payPalWell);
    }

    @Override
    public boolean isExist(int timeout) {
        return isElementVisible(payPalWell, timeout);
    }
}
