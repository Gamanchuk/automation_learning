package entities.pages.shoe;


import entities.pages.BasePage;
import org.openqa.selenium.By;
import utils.CommonFunctions;

public class SHOEMainPage extends BasePage {
    private By logo = By.id("mini-cart-trigger");

    @Override
    public boolean isPage() {
        CommonFunctions.sleep(2000);
        waitForDocumentReady();
        return isElementPresent(logo) && isElementClickable(logo);
    }

}
