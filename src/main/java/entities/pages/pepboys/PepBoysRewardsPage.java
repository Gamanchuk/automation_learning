package entities.pages.pepboys;

import org.openqa.selenium.By;

public class PepBoysRewardsPage extends PepBoysBasePage {
    public boolean isPage() {
        return isElementVisible(By.id("contentContainer"));
    }
}
