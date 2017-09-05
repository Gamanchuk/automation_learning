package entities.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DiscountComponent extends BaseComponent {
    private By giftNumber = By.xpath("//div[contains(@class, 'discount-left-input')]//input");
    private By pinCode = By.xpath("//div[contains(@class, 'discount-right-input')]//input");


    public void fillDiscount(String number, String pin) {
        WebElement giftNumberEl = getDriver().findElement(giftNumber);
        giftNumberEl.clear();
        giftNumberEl.sendKeys(number);

        WebElement pinCodeEl = getDriver().findElement(pinCode);
        pinCodeEl.clear();
        pinCodeEl.sendKeys(pin);
    }

    @Override
    public boolean isExist() {
        return false;
    }

    @Override
    public boolean isExist(int timeout) {
        return false;
    }
}
