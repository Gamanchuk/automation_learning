package entities.pages.shoe;


import entities.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import utils.CommonFunctions;

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
        CommonFunctions.sleep(3000);
        assertTrue(isPage(), "Looks like product page was not opened.");
    }

    public void addToCart() {
        By sizeSelector = By.id("select_size_width");

        if (isElementVisible(sizeSelector)) {
            Select size = new Select(findElement(sizeSelector));
            size.selectByVisibleText("5M");
            CommonFunctions.sleep(6000);
        }

        getDriver().findElement(addToCart).click();
    }
}
