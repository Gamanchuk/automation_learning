package entities.pages.philosophy;


import entities.pages.BasePage;
import org.openqa.selenium.By;

public class PHILOSOPHYWarningPage extends BasePage {
    private By warning = By.id("ignore_this_warning");

    @Override
    public boolean isPage() {
        return isElementPresent(warning);
    }

    public void ignoreWarning() {
        getDriver().findElement(warning).click();
    }

    public void navigate() {
        getDriver().navigate().to(BASE_URL + COOKIES);
    }
}
