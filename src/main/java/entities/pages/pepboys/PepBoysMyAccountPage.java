package entities.pages.pepboys;

import entities.pages.BasePage;
import org.openqa.selenium.By;

public class PepBoysMyAccountPage extends BasePage {

    public boolean isPage() {
        return isElementVisible(By.xpath("//div[contains(@class, 'eserveHeader')]//span"));
    }
}
