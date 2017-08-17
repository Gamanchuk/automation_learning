package entities.pages.philosophy;


import entities.pages.BasePage;
import org.openqa.selenium.By;
import utils.CommonFunctions;
import utils.Config;

public class PHILOSOPHYMainPage extends BasePage {
    private By feature = By.id("home-feature-collection");

    @Override
    public boolean isPage() {
        CommonFunctions.sleep(2000);
        waitForDocumentReady();
        return isElementPresent(feature);
    }

    public void navigate() {
        String url;

        if (Config.SITE_NAME.equals("philosophy-stage")) {
            url = "https://storefront:phil123@staging-store-coty.demandware.net/" + COOKIES;
        } else {
            url = BASE_URL + COOKIES;
        }

        getDriver().navigate().to(url);
    }
}
