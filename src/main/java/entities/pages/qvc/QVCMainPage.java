package entities.pages.qvc;

import entities.pages.BasePage;
import org.openqa.selenium.By;
import utils.CommonFunctions;

public class QVCMainPage extends BasePage {

    public boolean isPage() {
        CommonFunctions.sleep(2000);
        waitForDocumentReady();
        return isElementVisible(By.id("pageContent"));
    }

    public boolean isPage(int timeout) {
        CommonFunctions.sleep(2000);
        waitForDocumentReady();
        return isElementVisible(By.id("pageContent"), timeout);
    }
}




