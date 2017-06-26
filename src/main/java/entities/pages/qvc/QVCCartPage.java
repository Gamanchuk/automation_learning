package entities.pages.qvc;

import entities.pages.BasePage;
import org.openqa.selenium.By;

public class QVCCartPage extends BasePage {
    private By checkout = By.id("checkoutBtn");
    private By cart = By.id("divShoppingCart");

    public boolean isPage() {
        return isElementVisible(cart, 110) && isElementPresent(cart);

    }

    public void processToCheckout() {
        getDriver().findElement(checkout).click();
    }


    public String getErrorMessage() {
        return getDriver().findElement(By.xpath("//p[contains(@class, 'idleMessageBottom')]")).getText();
    }
}
