package entities.pages.pepboys;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import static org.testng.Assert.assertTrue;

public class PepBoysProductPage extends PepBoysBasePage {
    private String productId;

    public boolean isPage() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return isElementVisible(By.xpath("//div[@class='mw-note-value' and text()='" + productId + "']"));
    }

    public void openProductPage(String productId) {
        this.productId = productId;
        getDriver().navigate().to(BASE_URL + "product/details/" + productId);
        assertTrue(isPage(), "Product page was not opened");
    }

    public void setDeliveryOption(String deliveryOption) {
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(0,500)", "");

        if (!deliveryOption.equals("Pick Up in Store")) {
            getDriver().findElement(By.xpath("//label[contains(., '" + deliveryOption + "')]")).click();
            waitForAjax();
        }
    }

    public void addToCart() {
        click(By.xpath("//button[text()='Add to cart']"));
    }

    public boolean isInfoDialogOpened() {
        return isElementVisible(By.xpath("//h3[text()='Your item(s) have been added to the cart']"));
    }

    public void clickViewCartInAddToCartDialog() {
        click(By.xpath("//button[text()='View Cart']"));
//        assertTrue(isElementClickable(By.xpath("//a[text()='Pay Online']")));
    }

    public void clickContinueInAddToCartDialog() {
        click(By.xpath("//button[text()='Continue Shopping']"));
    }

    public boolean isAvailableInStore() {
        return !isElementPresent(By.xpath("//div[contains(text(), 'Not Available')]"), 2);
    }
}
