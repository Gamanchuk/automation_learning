package entities.pages.pepboys;

import org.openqa.selenium.By;

public class PepBoysMyAccountPage extends PepBoysBasePage {

    public boolean isPage() {
        return isElementVisible(By.xpath("//div[contains(@class, 'eserveHeader')]//span"));
    }
}
