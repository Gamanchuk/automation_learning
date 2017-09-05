package entities.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertTrue;


public class CheckoutMethodsComponent extends BaseComponent {
    private By checkoutMethods = By.xpath("//div[contains(@class, 'checkout-methods')]");
    private By guestAccount = By.xpath("//div[contains(@class, 'guest-login-accordion')]//button");
    private By existingAccount = By.xpath("//div[contains(@class, 'returning-user-accordion')]//button");

    public void checkoutAs(String type) {
        assertTrue(isExist(), "Looks like checkout methods does not present.");
        getMethod(type).click();
    }

    private WebElement getMethod(String type) {
        switch (type) {
            case "Guest":
                return getDriver().findElement(guestAccount);
            case "Existing Account":
                return getDriver().findElement(existingAccount);
            default:
                throw new Error("[CheckoutMethodsComponent] Unknown type name: " + type);
        }
    }

    public boolean isOpen() {
        return getMethod("Existing Account").getAttribute("class").contains("expanded");
    }

    @Override
    public boolean isExist() {
        return isElementVisible(checkoutMethods);
    }

    @Override
    public boolean isExist(int timeout) {
        return isElementVisible(checkoutMethods, timeout);
    }
}
