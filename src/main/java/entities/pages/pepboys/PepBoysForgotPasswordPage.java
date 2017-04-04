package entities.pages.pepboys;

import org.openqa.selenium.By;

public class PepBoysForgotPasswordPage extends PepBoysBasePage {


    public boolean isPage() {
        waitForElementVisible(By.id("emailAddress"));
        waitForElementVisible(By.id("confirmEmailAddress"));
        return true;
    }
}
