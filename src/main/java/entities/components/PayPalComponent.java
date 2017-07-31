package entities.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonFunctions;
import utils.pepboys.BillingUser;

import static org.testng.Assert.assertTrue;

public class PayPalComponent extends BaseComponent {

    private By payPalEmail = By.xpath("//input[@id='email']");
    private By payPalPassword = By.xpath("//input[@id='password']");

    public void signIn(String email, String password) {

        fillPayPalEmail(email);
        fillPayPalPassword(password);

        CommonFunctions.attachScreenshot("Login page");
    }

    public void doLogin(BillingUser user) {

        boolean isNewPayPal = isIframeExist("injectedUl");
        By logInButton = isNewPayPal ? By.id("btnLogin") : By.id("login");

        if (isNewPayPal) {
            switchToIframe("injectedUl");
        }

        assertTrue(isElementVisible(logInButton) && isElementClickable(logInButton),
                "PayPal Login button doesn't present on page or not clickable.");

        WebElement emailField = getDriver().findElement(By.id("email"));
        emailField.clear();
        emailField.sendKeys(user.getPaypalEmail());

        WebElement passwordField = getDriver().findElement(By.id("password"));
        passwordField.clear();
        passwordField.sendKeys(user.getPaypalPassword());

        emailField.click();

        CommonFunctions.attachScreenshot("Login PayPal Page");
        getDriver().findElement(logInButton).click();

        if (isNewPayPal) {
            // waiting for spinner
            switchToDefaultIframe();
            waitForElementVisible(By.id("spinner"));
            waitForElementInvisibility(By.id("spinner"));
        }

        CommonFunctions.attachScreenshot("Login PayPal Page after SignIn");
    }

    public void confirmationPay() {

        if (isElementVisible(By.id("confirmButtonTop"))) {
            waitForAjax();
            assertTrue(isElementClickable(By.id("confirmButtonTop")),
                    "PayPal confirmation button doesn't present on page or not clickable.");
            getDriver().findElement(By.id("confirmButtonTop")).click();
        }

    }

    public void clickLogin() {
        CommonFunctions.sleep(20000);
        By login = By.xpath("//a[contains(@class, 'btn') and text()='Log In']");
        assertTrue(isElementClickable(login), "PayPal login button doesn't present on page.");
        getDriver().findElement(login).click();
    }

    public void logOut() {
        getDriver().navigate().to("https://sandbox.paypal.com/myaccount/logout");
    }

    public boolean existsPayPalEmail() {
        return isElementVisible(payPalEmail);
    }

    public boolean existsPayPalPassword() {
        return isElementVisible(payPalPassword);
    }

    private void fillPayPalEmail(String value) {
        fillField(payPalEmail, value);
    }

    private void fillPayPalPassword(String value) {
        fillField(payPalPassword, value);
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
    }


}
