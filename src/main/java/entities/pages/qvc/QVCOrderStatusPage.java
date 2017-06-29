package entities.pages.qvc;

import entities.pages.BasePage;
import org.openqa.selenium.By;

public class QVCOrderStatusPage extends BasePage {
    private By title = By.id("divPageTitle");

    public boolean isPage() {
        return isElementVisible(title) && isElementPresent(title);
    }
}
