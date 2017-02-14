package components.pages.pepboys;

import org.openqa.selenium.By;

import static org.testng.Assert.assertTrue;

public class PepBoysProductPage extends PepBoysBasePage {

    public void setDeliveryOption(String deliveryOption) {
        By option = By.xpath("//label[contains(., '" + deliveryOption + "')]");
        waitForElementClickable(option);
        getDriver().findElement(option).click();
    }


    public void addToCart() {
        waitAndClick(By.xpath("//button[text()='Add to cart']"));
    }

    public boolean isInfoDialogOpened() {
        return isElementVisible(By.xpath("//h3[text()='Your item(s) have been added to the cart']"));
    }

    public void clickViewCartInAddToCartDialog() {
        getDriver().findElement(By.xpath("//button[text()='View Cart']")).click();
        assertTrue(isElementClickable(By.xpath("//a[text()='Pay Online']")));
    }
}
