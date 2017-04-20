package entities.pages.pepboys;

import org.openqa.selenium.By;

public class PepBoysTrackingPage extends PepBoysBasePage {

    public boolean isPage() {
        return isElementVisible(By.id("tracking"));
    }

}
