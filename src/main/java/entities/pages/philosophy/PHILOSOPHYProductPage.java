package entities.pages.philosophy;


import entities.pages.BasePage;
import org.openqa.selenium.By;
import utils.CommonFunctions;
import utils.Config;

import static io.appium.java_client.remote.MobilePlatform.IOS;
import static org.testng.Assert.assertTrue;

public class PHILOSOPHYProductPage extends BasePage {

    private By addToCart = By.id("add-to-cart");
    private PHILOSOPHYWarningPage philosophyWarningPage = new PHILOSOPHYWarningPage();

    @Override
    public boolean isPage() {
        return isElementVisible(addToCart, 20) || isElementClickable(addToCart, 20);
    }

    public void openPage(String productUrl) {
        String fullPath;
        fullPath = BASE_URL + productUrl;


        getDriver().navigate().to(fullPath);
        log.info("Full path: " + fullPath);

        CommonFunctions.sleep(2000);

        if (Config.PLATFORM_NAME.equals(IOS) && philosophyWarningPage.isPage(3)) {
            philosophyWarningPage.ignoreWarning();
        }

        assertTrue(isPage(), "Looks like product page was not opened.");
    }

    public void addToCart() {
        getDriver().findElement(addToCart).click();
    }
}
