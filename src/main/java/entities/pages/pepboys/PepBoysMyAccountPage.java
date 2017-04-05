package entities.pages.pepboys;

import org.openqa.selenium.By;

public class PepBoysMyAccountPage extends PepBoysBasePage {

    public boolean isPage() {
        waitForElementVisible(By.xpath("//div[contains(@class, 'eserveHeader')]//span"));
        return true;
    }


}
