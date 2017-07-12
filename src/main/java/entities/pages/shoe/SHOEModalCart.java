package entities.pages.shoe;


import entities.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertTrue;

public class SHOEModalCart extends BasePage {

    private By checkout = By.xpath("//a[@id='checkoutNow']");
    private By iframe = By.xpath("//div[@class='jBox-content']//iframe");

    @Override
    public boolean isPage() {
        return isElementVisible(checkout) && isElementClickable(checkout);
    }

    public void processToCart() {
        getDriver().findElement(checkout).click();
        getDriver().switchTo().defaultContent();
    }

    public void switchToFrame() {
        assertTrue(isElementVisible(iframe), "Looks like iframe with checkout button doesn't present.");
        WebElement iframeEl = getDriver().findElement(iframe);
        getDriver().switchTo().frame(iframeEl);
    }

    public void switchToDefaultFrame() {
        getDriver().switchTo().defaultContent();
    }


}
