package entities.pages.pepboys;

import entities.pages.BasePage;
import org.openqa.selenium.By;

public class PepBoysTrackingPage extends BasePage {

    public boolean isPage() {
        return isElementVisible(By.id("tracking"));
    }

}
