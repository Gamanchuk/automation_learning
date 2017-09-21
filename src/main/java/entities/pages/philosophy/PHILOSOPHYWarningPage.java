package entities.pages.philosophy;


import entities.pages.BasePage;
import org.openqa.selenium.By;
import utils.CommonFunctions;
import utils.Config;

public class PHILOSOPHYWarningPage extends BasePage {

    private By warning = By.id("ignoreWarning");
    private By warningOldIOS = By.id("ignore_this_warning");
    private By warningNewIOS = By.id("ignoreWarning");


    @Override
    public boolean isPage() {
        if (Config.SITE_NAME.equals("philosophy-prod")) {
            return true;
        } else {
            return isElementVisible(warningOldIOS, 20) || isElementVisible(warningNewIOS, 5);
        }
    }

    public boolean isPage(int timeout) {
        if (Config.SITE_NAME.equals("philosophy-prod")) {
            return true;
        } else {
            return isElementPresent(warningOldIOS, timeout) || isElementPresent(warningNewIOS, 5);
        }
    }

    public void ignoreWarning() {
        if (Config.SITE_NAME.equals("philosophy-prod")) {
            CommonFunctions.executeJavaScript("PhishingAlertController.ignoreWarningSelected();");
        }
    }
}
