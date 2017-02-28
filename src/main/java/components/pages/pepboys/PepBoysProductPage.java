package components.pages.pepboys;

import org.openqa.selenium.By;

import static org.testng.Assert.assertTrue;

public class PepBoysProductPage extends PepBoysBasePage {
    private String productId;

    public boolean isPage() {
        waitForElementVisible(By.xpath("//div[@class='mw-note-value' and text()='" + productId + "']"));
        return true;
    }

    public void openProductPage(String productId) {
        this.productId = productId;
        getDriver().navigate().to(BASE_URL + "product/details/" + productId);

    }

    public void setDeliveryOption(String deliveryOption) {
        By option = By.xpath("//label[contains(., '" + deliveryOption + "')]");
        click(option);
    }

    public void addToCart() {
        click(By.xpath("//button[text()='Add to cart']"));
    }

    public boolean isInfoDialogOpened() {
        return isElementVisible(By.xpath("//h3[text()='Your item(s) have been added to the cart']"));
    }

    public void clickViewCartInAddToCartDialog() {
        click(By.xpath("//button[text()='View Cart']"));
        assertTrue(isElementClickable(By.xpath("//a[text()='Pay Online']")));
    }
}
