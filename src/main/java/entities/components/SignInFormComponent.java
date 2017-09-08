package entities.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonFunctions;

import static org.testng.Assert.assertTrue;

public class SignInFormComponent extends BaseComponent {

    private By forgotPassword = By.cssSelector("a.forgot-password-link");
    private By whereMyPassword = By.xpath("//div[@class='message-button']");
    private By whereMyPasswordContent = By.xpath("//div[@class='message-content']");

    //private By emailField = By.id("shipping-email");
    private By passwordField = By.xpath("//input[@id='password' or @id='current-password']");
    private By toGuestCheckoutLink = By.xpath("//a[text()='Proceed to Guest Checkout']");

    private EmailComponent emailComponent = new EmailComponent();

    public void signIn(String email, String password) {

        fillEmail(email);
        fillPassword(password);
        CommonFunctions.attachScreenshot("Login page with filled fields");
    }

    public void proceedToGuestCheckout() {
        assertTrue(isElementClickable(toGuestCheckoutLink), "Proceed to guest checkout not clickable. Or doesn't isExist");
        getDriver().findElement(toGuestCheckoutLink).click();
    }

    public void pressForgotPasswordLink() {
        assertTrue(isElementClickable(forgotPassword), "Forgot password link not clickable. Or doesn't isExist");
        CommonFunctions.attachScreenshot("Login page: Forgot Password");
        getDriver().findElement(forgotPassword).click();
    }

    public void fillEmail(String value) {
        emailComponent.fillEmailField(value);
    }

    public void fillPassword(String value) {
        WebElement passEl = findElement(passwordField);
        passEl.clear();
        CommonFunctions.sleep(1000);
        passEl.sendKeys(value);
        focusOut(passEl);
        CommonFunctions.sleep(1000);
    }

    public void pressWhereDoIEnterMyPassword() {
        assertTrue(isElementClickable(whereMyPassword), "'Where do I enter my password' link not clickable. Or doesn't isExist");
        getDriver().findElement(whereMyPassword).click();
    }

    public String getContentAboutPasswordFill() {
        assertTrue(isElementVisible(whereMyPasswordContent, 5), "Content doesn't isExist.");
        return getDriver().findElement(whereMyPasswordContent).getText();
    }

    @Override
    public boolean isExist(int timeout) {
        return isElementVisible(forgotPassword, timeout) || emailComponent.isExist(timeout);
    }

    @Override
    public boolean isExist() {
        return isElementVisible(forgotPassword) || emailComponent.isExist(5);
    }

    public boolean isPasswordFieldVisible() {
        return isElementVisible(passwordField, 5);
    }
}
