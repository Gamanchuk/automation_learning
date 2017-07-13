package entities.pages.shoe;


import entities.pages.BasePage;
import org.openqa.selenium.By;

public class SHOECartPage extends BasePage {

    private By signIn = By.className("cart-item");
    private By checkout = By.id("atg_store_checkout");

    @Override
    public boolean isPage() {
        return isElementVisible(signIn) && isElementClickable(signIn);
    }

    public void processToShoeCheckout() {
        getDriver().findElement(checkout).click();
    }
}
