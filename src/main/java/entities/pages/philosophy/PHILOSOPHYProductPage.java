package entities.pages.philosophy;


import entities.pages.BasePage;
import org.openqa.selenium.By;
import utils.CommonFunctions;

import static org.testng.Assert.assertTrue;

public class PHILOSOPHYProductPage extends BasePage {
    private By addToCart = By.id("add-to-cart");

    @Override
    public boolean isPage() {
        return isElementVisible(addToCart, 20) || isElementClickable(addToCart, 20);
    }

    public void openPage(String productUrl) {
        String fullPath = BASE_URL + productUrl;
        log.info("Full path: " + fullPath);
        getDriver().navigate().to(fullPath);
        CommonFunctions.sleep(2000);
        assertTrue(isPage(), "Looks like product page was not opened.");
    }

    public void addToCart() {
        getDriver().findElement(addToCart).click();
    }
}
