package entities.components;

import org.openqa.selenium.By;

public class ForgotPasswordComponent extends BaseComponent {
    private By forgotPasswordAssistance = By.xpath("//div[contains(@class, 'component') and contains(@class, 'forgot-password')]");

    @Override
    public boolean isExist() {
        return isElementVisible(forgotPasswordAssistance);
    }

    @Override
    public boolean isExist(int timeout) {
        return isElementVisible(forgotPasswordAssistance, timeout);
    }
}
