package entities.pages.philosophy;


import entities.pages.BasePage;
import org.openqa.selenium.By;

public class PHILOSOPHYWarningPage extends BasePage {
    private By warning = By.id("ignore_this_warning");

    @Override
    public boolean isPage() {
        return isElementVisible(warning);
    }

    public boolean isPage(int timeout) {
        return isElementPresent(warning, timeout);
    }

    public void ignoreWarning() {
        getDriver().findElement(warning).click();
    }
}
