package entities.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonFunctions;
import utils.pepboys.BillingUser;

import static org.testng.Assert.assertTrue;

public class PayPalComponent extends BaseComponent {




    private By payPalEmail = By.xpath("//input[@id='email']");
    private By payPalPassword = By.xpath("//input[@id='password']");
    private By iframeName = By.xpath("//div[@id='injectedUnifiedLogin']/frame[@name='injectedUl']");


    //private WebElement payPalFrame =

     //       driver.switchTo().frame("injectedUl");


    //driver.switchTo().frame("injectedUl");
    //WebElement we = m_driver.findElement(By.xpath(".//*[@id='email']"));

    public void switchToFrame() {
        WebElement iframePayPal = getDriver().findElement(iframeName);
        getDriver().switchTo().frame("injectedUl");
        assertTrue(isElementVisible(iframeName), "Looks like iframe with checkout button doesn't present.");
    }

    public boolean existsPayPalEmail() {
        return isElementVisible(payPalEmail);
    }

    public boolean existsPayPalPassword() {
        return isElementVisible(payPalPassword);
    }

    public void fillPayPalEmail(String value) {
        fillField(payPalEmail, value);
    }

    public void fillPayPalPassword(String value) {
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

//        WebElement element = getDriver().findElement(field);
//        CommonFunctions.sleep(500);
//        element.clear();
//        CommonFunctions.sleep(500);
//        element.sendKeys(value);
    }

    public void signIn(String email, String password) {

        fillPayPalEmail(email);
        fillPayPalPassword(password);

        CommonFunctions.attachScreenshot("Login page");
    }















    public void doLogin(BillingUser user) {
        //boolean isNewPayPal = isIframeExist("injectedUl");
        boolean isNewPayPal = isElementVisible(By.id("btnLogin"));
        By logInButton = isNewPayPal ? By.id("btnLogin") : By.id("login");

//        if (isNewPayPal) {
//            switchToIframe("injectedUl");
//        }

        assertTrue(isElementVisible(logInButton) && isElementClickable(logInButton),
                "PayPal Login button doesn't present on page or not clickable.");

        WebElement emailField = getDriver().findElement(By.id("email"));
        emailField.clear();
        emailField.sendKeys(user.getPaypalEmail());

        WebElement passwordField = getDriver().findElement(By.id("password"));
        passwordField.clear();
        passwordField.sendKeys(user.getPaypalPassword());

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
        assertTrue(isElementClickable(By.id("confirmButtonTop")),
                "PayPal confirmation button doesn't present on page or not clickable.");
        getDriver().findElement(By.id("confirmButtonTop")).click();
    }

    public void logOut() {
        getDriver().navigate().to("https://sandbox.paypal.com/myaccount/logout");
    }
}
