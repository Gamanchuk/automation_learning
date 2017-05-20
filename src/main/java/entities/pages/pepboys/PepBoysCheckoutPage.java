package entities.pages.pepboys;

import org.openqa.selenium.By;
import utils.Config;

public class PepBoysCheckoutPage extends PepBoysBasePage {
    public void waitForPepBoysPage() {
        waitForElementVisible(By.xpath("//*[contains(text(), 'The Pep Boys')]"));
    }

    public void checkURL() {
        if(!getDriver().getCurrentUrl().contains(Config.BASE_URL)) {
            String endpoint = getDriver().getCurrentUrl().split("pepboys.com/")[1];
            getDriver().get(Config.BASE_URL + endpoint);
        }
    }
}
