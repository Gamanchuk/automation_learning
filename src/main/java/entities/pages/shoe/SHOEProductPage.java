package entities.pages.shoe;


import entities.pages.BasePage;
import org.openqa.selenium.By;

import static org.testng.Assert.assertTrue;

public class SHOEProductPage extends BasePage {
    private By addToCart = By.xpath("//a[@id='atg_behavior_addItemToCart']");

    @Override
    public boolean isPage() {
        return isElementVisible(addToCart) && isElementClickable(addToCart);
    }

    public void openPage(String productUrl) {
        String fullPath = BASE_URL + productUrl;
        log.info("Full path: " + fullPath);
        getDriver().navigate().to(fullPath);

        assertTrue(isPage(), "Looks like product page was not opened.");
    }

    public void addToCart() {
        getDriver().findElement(addToCart).click();
    }


}
