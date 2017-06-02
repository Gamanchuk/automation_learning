package entities.pages.pepboys;

import entities.pages.BasePage;
import org.openqa.selenium.By;

public class PepBoysRewardsPage extends BasePage {
    public boolean isPage() {
        return isElementVisible(By.id("contentContainer"));
    }
}
