package entities.pages.philosophy;


import entities.pages.BasePage;
import org.openqa.selenium.By;
import utils.CommonFunctions;

public class PHILOSOPHYMainPage extends BasePage {
    private By feature = By.id("home-feature-collection");

    @Override
    public boolean isPage() {
        CommonFunctions.sleep(2000);
        waitForDocumentReady();
        return isElementPresent(feature);
    }

    public void navigate() {
        getDriver().navigate().to(BASE_URL + COOKIES);
    }
}
