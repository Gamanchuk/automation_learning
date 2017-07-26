package entities.pages.saatva;


import entities.pages.BasePage;
import org.openqa.selenium.By;

public class SAATVACartPage extends BasePage {

    private By checkout = By.className("pink_button");
    private By paypal = By.name("pp_express");
    private By paypalCredit = By.className("pp_credit");

    @Override
    public boolean isPage() {
        return isElementVisible(checkout) && isElementClickable(checkout);
    }

    public void processToCheckout() {
        getDriver().findElement(checkout).click();
    }

    public void checkOutWithPayPal() {
        getDriver().findElement(paypal).submit();
    }

    public void checkOutWithPayPalCredit() {
        getDriver().findElement(paypalCredit).submit();
    }
}

