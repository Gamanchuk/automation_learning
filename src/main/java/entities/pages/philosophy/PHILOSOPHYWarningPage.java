package entities.pages.philosophy;


import entities.pages.BasePage;
import org.openqa.selenium.By;
import utils.CommonFunctions;
import utils.Config;

public class PHILOSOPHYWarningPage extends BasePage {

    private By warningOldIOS = By.id("ignore_this_warning");
    private By warningNewIOS = By.id("ignoreWarning");


    @Override
    public boolean isPage() {
        if (Config.SITE_NAME.equals("philosophy-stage")) {
            return isElementVisible(warningOldIOS, 20) || isElementVisible(warningNewIOS, 5);
        } else {
            return true;
        }
    }

    public boolean isPage(int timeout) {
        if (Config.SITE_NAME.equals("philosophy-stage")) {
            return isElementPresent(warningOldIOS, timeout) || isElementPresent(warningNewIOS, 5);
        } else {
            return true;
        }
    }

    public void ignoreWarning() {
        if (Config.SITE_NAME.equals("philosophy-stage")) {
            CommonFunctions.executeJavaScript("PhishingAlertController.ignoreWarningSelected();");
        }
    }
}
