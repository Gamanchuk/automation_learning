package entities.pages.pepboys;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonFunctions;
import utils.Config;

import static org.testng.Assert.assertTrue;

public class PepBoysProductPage extends PepBoysBasePage {
    private String productId;
    private By addToCart = By.xpath("//button[contains(@class, 'j-addItem')]");

    //    public boolean isPage() {
//        CommonFunctions.sleep(2000);
//        waitForAjax();
//        return isElementVisible(By.xpath("//div[@class='mw-note-value' and text()='" + productId + "']"));
//    }
    public boolean isPage() {
        CommonFunctions.sleep(2000);
        return isElementVisible(addToCart) && isElementClickable(addToCart);
    }

    public void openProductPage(String productId) {
        this.productId = productId;
        getDriver().navigate().to(BASE_URL + "product/details/" + productId + "/" + Config.STORE_ID);
        assertTrue(isPage(), "Product page was not opened.");
    }

    public void setDeliveryOption(String deliveryOption) {
        By deliveryOptionXpath = By.xpath("//label[contains(., '" + deliveryOption + "')]");

        assertTrue(isElementVisible(deliveryOptionXpath), "Delivery options " + deliveryOption + " doesn't present on page.");
        WebElement deliveryOptionEl = getDriver().findElement(deliveryOptionXpath);
        javascriptScroll(deliveryOptionEl);

        if (!deliveryOption.equals("Pick Up in Store")) {
            deliveryOptionEl.click();
            waitForAjax();
        }
    }

    public void addToCart() {
        click(addToCart);
    }

    public boolean isInfoDialogOpened() {
        return isElementVisible(By.xpath("//h3[text()='Your item(s) have been added to the cart']"));
    }

    public boolean isInfoDialogOpened(int timeout) {
        return isElementVisible(By.xpath("//h3[text()='Your item(s) have been added to the cart']"), timeout);
    }

    public void clickViewCartInAddToCartDialog() {
        click(By.xpath("//button[text()='View Cart']"));
    }

    public void clickContinueInAddToCartDialog() {
        click(By.xpath("//button[text()='Continue Shopping']"));
    }

    public boolean isAvailableInStore() {
        return !isElementPresent(By.xpath("//h4[contains(text(), 'Not Available')]"), 5) &&
                !isElementPresent(By.xpath("//h4[contains(text(), 'Available tomorrow')]"), 5) &&
                !isElementPresent(By.xpath("//h4[contains(text(), 'Available today after')]"), 5) &&
                !isElementPresent(By.xpath("//h4[contains(text(), 'days after')]"), 5) &&
                isElementPresent(By.xpath("//h4[contains(text(), 'Available today')]"), 5) &&
                isElementPresent(By.xpath("//div[contains(text(), 'Pay in Store Available')]"), 5);
    }
}
