package entities.pages.saatva;


import entities.pages.BasePage;
import org.openqa.selenium.By;

public class SAATVAMainPage extends BasePage {
    private By logo = By.id("logo-container");

    @Override
    public boolean isPage() {
        return isElementVisible(logo) && isElementClickable(logo);
    }

}
