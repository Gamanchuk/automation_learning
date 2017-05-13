package entities.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonFunctions;

public class SignInFormComponent extends BaseComponent {
    private By forgotPassword = By.xpath("//div[contains(@class,'login-buttons')]//a");
    private By emailField = By.id("shipping-email");
    private By passwordField = By.id("password");

    public void signIn(String email, String password) {
        WebElement emailFieldEl = getDriver().findElement(emailField);
        emailFieldEl.clear();
        emailFieldEl.sendKeys(email);

        WebElement passwordFieldEl = getDriver().findElement(passwordField);
        passwordFieldEl.clear();
        passwordFieldEl.sendKeys(password);

        focusOut(passwordFieldEl);
        CommonFunctions.attachScreenshot("Login page");
    }

    public void pressForgotPasswordLink() {
        waitForElementClickable(forgotPassword);
        CommonFunctions.attachScreenshot("Login page: Forgot Password");
        getDriver().findElement(forgotPassword).click();
    }

    public boolean exist() {
        waitForElementVisible(passwordField);
        return true;
    }
}
