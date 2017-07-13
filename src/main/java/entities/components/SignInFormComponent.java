package entities.components;

import org.openqa.selenium.By;
import utils.CommonFunctions;

import static org.testng.Assert.assertTrue;

public class SignInFormComponent extends BaseComponent {
    //private By forgotPassword = By.xpath("//div[contains(@class,'login-buttons')]//a");
    private By forgotPassword = By.cssSelector("a.forgot-password-link");
    private By whereMyPassword = By.xpath("//div[@class='message-button']");
    private By whereMyPasswordContent = By.xpath("//div[@class='message-content']");

    private By emailField = By.id("shipping-email");
    //private By passwordField = By.id("password");
    private By passwordField = By.xpath("//input[@id='password' or @id='current-password']");
    private By toGuestCheckoutLink = By.xpath("//a[text()='Proceed to Guest Checkout']");

    final static String EMAIL = "email";
    final static String PASSWORD = "password";

    public boolean exists() {
        return isElementVisible(emailField);
    }

    public void signIn(String email, String password) {

        fillEmail(email);
        fillPassword(password);

        CommonFunctions.attachScreenshot("Login page");
    }

    public void proceedToGuestCheckout() {
        assertTrue(isElementClickable(toGuestCheckoutLink), "Proceed to guest checkout not clickable. Or doesn't exists");
        getDriver().findElement(toGuestCheckoutLink).click();
    }

    public void pressForgotPasswordLink() {
        assertTrue(isElementClickable(forgotPassword), "Forgot password link not clickable. Or doesn't exists");
        CommonFunctions.attachScreenshot("Login page: Forgot Password");
        getDriver().findElement(forgotPassword).click();
    }

    public void fillEmail(String value) {
        fillField(emailField, value);
    }

    public void fillPassword(String value) {
        fillField(passwordField, value);
    }

    public void pressWhereDoIEnterMyPassword() {
        assertTrue(isElementClickable(whereMyPassword), "'Where do I enter my password' link not clickable. Or doesn't exists");
        getDriver().findElement(whereMyPassword).click();
    }

    public String getContentAboutPasswordFill() {
        assertTrue(isElementVisible(whereMyPasswordContent, 5), "'Where do I enter my password' content doesn't exists.");
        return getDriver().findElement(whereMyPasswordContent).getText();
    }

    public boolean isPasswordFieldVisible() {
        return isElementVisible(passwordField, 5);
    }

    private void fillField(By field, String value) {

        //Need sleep because sometimes we catch element longer not attached
        CommonFunctions.sleep(5000);

        waitForDocumentReady();
        assertTrue(isElementVisible(field), "Field " + field.toString() + " doesn't present on page.");
        CommonFunctions.sleep(500);
        getDriver().findElement(field).clear();
        CommonFunctions.sleep(500);
        getDriver().findElement(field).sendKeys(value);

//        WebElement element = getDriver().findElement(field);
//        CommonFunctions.sleep(500);
//        element.clear();
//        CommonFunctions.sleep(500);
//        element.sendKeys(value);
    }
}
