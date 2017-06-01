package entities.pages.qvc;

import entities.pages.BasePage;
import org.openqa.selenium.By;

public class QVCCartPage extends BasePage {
    private By checkout = By.id("checkoutBtn");

    public boolean isPage() {
        return isElementVisible(checkout) || isElementClickable(checkout);
    }

    public void processToCheckout() {
        getDriver().findElement(checkout).click();
    }


}
