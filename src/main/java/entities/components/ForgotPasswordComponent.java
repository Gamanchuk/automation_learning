package entities.components;

import org.openqa.selenium.By;

public class ForgotPasswordComponent extends BaseComponent {
    private By forgotPasswordAssistance = By.xpath("//div[contains(@class, 'component') and contains(@class, 'forgot-password')]");

    public boolean exists() {
        return isElementVisible(forgotPasswordAssistance);
    }
}
