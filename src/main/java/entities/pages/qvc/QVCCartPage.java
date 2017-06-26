package entities.pages.qvc;

import entities.pages.BasePage;
import org.openqa.selenium.By;

public class QVCCartPage extends BasePage {
    private By checkout = By.id("checkoutBtn");
    private By cart = By.id("divShoppingCart");
    private By speedBuy = By.xpath("//span[contains(@class, 'primaryWrapBtn') and  contains(., 'Speed buy')]//input");

    public boolean isPage() {
        return isElementVisible(cart, 110) && isElementPresent(cart);
    }

    public void processToCheckout() {
        getDriver().findElement(checkout).click();
    }

    public void processToSpeedBuy() {
        getDriver().findElement(speedBuy).click();
    }

    public String getErrorMessage() {
        return getDriver().findElement(By.xpath("//p[contains(@class, 'idleMessageBottom')]")).getText();
    }
}
