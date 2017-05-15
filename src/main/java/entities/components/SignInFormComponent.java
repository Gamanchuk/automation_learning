package entities.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonFunctions;

import static org.testng.Assert.assertTrue;

public class SignInFormComponent extends BaseComponent {
    private By forgotPassword = By.xpath("//div[contains(@class,'login-buttons')]//a");
    private By emailField = By.id("shipping-email");
    private By passwordField = By.id("password");

    public void signIn(String email, String password) {
        log.info("Email: " + email);
        log.info("Password: " + password);

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
        assertTrue(isElementClickable(forgotPassword), "Forgot password link not clickable. Or doesn't exist");
        CommonFunctions.attachScreenshot("Login page: Forgot Password");
        getDriver().findElement(forgotPassword).click();
    }

    public boolean exist() {
        return isElementVisible(passwordField);
    }
}
