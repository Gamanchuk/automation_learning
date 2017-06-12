package entities.pages.qvc;

import entities.pages.BasePage;
import org.openqa.selenium.By;

public class QVCForgotPasswordPage extends BasePage {
    public boolean isPage() {
        return isElementVisible(By.id("txtEmailAddress"));
    }
}
