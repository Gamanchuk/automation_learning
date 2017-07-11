package entities.pages.saatva;


import entities.pages.BasePage;
import org.openqa.selenium.By;
import utils.CommonFunctions;

public class SAATVAMainPage extends BasePage {
    private By logo = By.id("logo-container");

    @Override
    public boolean isPage() {
        CommonFunctions.sleep(2000);
        waitForDocumentReady();
        return isElementPresent(logo) && isElementClickable(logo);
    }

}
