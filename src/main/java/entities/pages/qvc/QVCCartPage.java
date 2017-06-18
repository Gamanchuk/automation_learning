package entities.pages.qvc;

import entities.pages.BasePage;
import org.openqa.selenium.By;

public class QVCCartPage extends BasePage {
    private By checkout = By.id("checkoutBtn");
    private By cart = By.id("divShoppingCart");

    public boolean isPage() {
        return isElementVisible(cart) && isElementPresent(cart);

    }

    public void processToCheckout() {
        getDriver().findElement(checkout).click();
    }


}
