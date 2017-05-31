package entities.pages.pepboys;

import entities.pages.BasePage;
import org.openqa.selenium.By;

import static org.testng.Assert.assertTrue;

public class PepBoysLoginPage extends BasePage {
    By toGuestCheckoutLink = By.xpath("//div[@class='guest-checkout-link']//a");

    public void proceedToGuestCheckout() {
        assertTrue(isElementClickable(toGuestCheckoutLink), "Proceed to guest checkout not clickable. Or doesn't exist");
        getDriver().findElement(toGuestCheckoutLink).click();
    }
}
