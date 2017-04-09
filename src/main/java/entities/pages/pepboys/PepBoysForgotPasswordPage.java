package entities.pages.pepboys;

import org.openqa.selenium.By;

public class PepBoysForgotPasswordPage extends PepBoysBasePage {
    public boolean isPage() {
        return isElementVisible(By.id("emailAddress")) && isElementVisible(By.id("confirmEmailAddress"));
    }
}
