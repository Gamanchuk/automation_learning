package entities.pages.pepboys;

import entities.pages.BasePage;
import org.openqa.selenium.By;

public class PepBoysForgotPasswordPage extends BasePage {
    public boolean isPage() {
        return isElementVisible(By.id("emailAddress")) && isElementVisible(By.id("confirmEmailAddress"));
    }
}
