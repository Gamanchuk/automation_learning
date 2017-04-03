package entities.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonFunctions;

public class SignInFormComponent extends BaseComponent {
    private By signInButton = By.xpath("//div[contains(@class,'submit-button')]//button");
    private By emailField = By.id("shipping-email");
    private By passwordField = By.id("password");

    public void signIn(String email, String password) {
        waitForElementClickable(signInButton);

        WebElement emailFieldEl = getDriver().findElement(emailField);
        emailFieldEl.clear();
        emailFieldEl.sendKeys(email);

        WebElement passwordFieldEl = getDriver().findElement(passwordField);
        passwordFieldEl.clear();
        passwordFieldEl.sendKeys(password);

        focusOut();
        CommonFunctions.attachScreenshot("Login page");
        getDriver().findElement(signInButton).click();
    }
}
