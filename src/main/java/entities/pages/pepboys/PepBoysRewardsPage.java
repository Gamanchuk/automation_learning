package entities.pages.pepboys;

import org.openqa.selenium.By;
import utils.TestGlobalsManager;

public class PepBoysRewardsPage extends PepBoysBasePage {
    public boolean isPage() {

        if (TestGlobalsManager.getTestGlobal("authorised") != null) {

        } else {
            waitForElementVisible(By.id("contentContainer"));
        }


        return true;
    }
}
