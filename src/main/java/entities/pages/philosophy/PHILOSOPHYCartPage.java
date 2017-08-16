package entities.pages.philosophy;


import entities.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import utils.CommonFunctions;

import static org.testng.Assert.assertTrue;

public class PHILOSOPHYCartPage extends BasePage {

    private By checkout = By.name("dwfrm_cart_nodeluxe");
    private By payPalcheckout = By.name("dwfrm_cart_nodeluxepaypal");
    //private By sampleForm = By.className("sample-form");
    private By sampleForm = By.className("samples");

    @Override
    public boolean isPage() {
        return isElementVisible(checkout) || isElementClickable(checkout);
    }

    public void processToCheckout() {
        getDriver().findElement(checkout).click();

        assertTrue(isElementVisible(sampleForm, 5), "Looks like Modal with Samples was not opened.");
        javascriptScroll(400);

        CommonFunctions.sleep(500);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("document.getElementsByName(\"dwfrm_cart_nosamples\")[0].click();");
    }

    public void navigate() {
        getDriver().navigate().to(BASE_URL + "cart/cart.jsp");
    }

    public void processToPayPal() {
        getDriver().findElement(payPalcheckout).click();
    }
}
