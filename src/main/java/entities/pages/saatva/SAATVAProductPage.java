package entities.pages.saatva;


import entities.pages.BasePage;
import org.openqa.selenium.By;

import static org.testng.Assert.assertTrue;

public class SAATVAProductPage extends BasePage {
    private By addToCart = By.id("add_to_cart");

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


}
