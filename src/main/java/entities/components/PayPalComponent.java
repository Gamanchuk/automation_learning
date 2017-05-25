package entities.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonFunctions;
import utils.pepboys.BillingUser;

import static org.testng.Assert.assertTrue;

public class PayPalComponent extends BaseComponent {

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
