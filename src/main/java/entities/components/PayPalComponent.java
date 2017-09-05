package entities.components;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.CommonFunctions;
import utils.pepboys.BillingUser;

import static org.testng.Assert.assertTrue;

public class PayPalComponent extends BaseComponent {

    private By email = By.id("email");
    private By password = By.id("password");
    private By btnNext = By.id("btnNext");
    private By logInButton = By.xpath("//button[@id='login' or @id='btnLogin']");

    private By smartPayPal = By.linkText("Switch to old login");

    /**
     * Function to go to the sign in page.
     */
    public void clickLogin() {
        String frame = "automation-frame";
        By loginSection = By.className("loginRedirect");

        boolean iframe = isIframeExist(frame);

        if (iframe) {
            assertTrue(isIframeExist(frame), "PayPal iframe doesn't exist.");
            getDriver().switchTo().frame(frame);
        }

        if (isElementVisible(loginSection, 10)) {
            CommonFunctions.sleep(500);
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            js.executeScript("document.getElementsByClassName(\"btn full ng-binding\")[0].click();");
        }

        if (iframe) {
            getDriver().switchTo().defaultContent();
        }
    }

    /**
     * Function for PayPal sing in.
     *
     * @param user
     */
    public void doLogin(BillingUser user) {

        // Sometimes PayPay load old site version
        // Old site version work without iframe
        boolean isNewPayPal = isIframeExist("injectedUl");

        if (isElementVisible(smartPayPal, 5)) {
            fillField(email, user.getPaypalEmail());
            getDriver().findElement(btnNext).click();
            fillField(password, user.getPaypalPassword());
            getDriver().findElement(logInButton).click();
        } else {
            // By logInButton = isNewPayPal ? By.id("btnLogin") : By.id("login");

            if (isNewPayPal) {
                switchToIframe("injectedUl");
            }

            assertTrue(isElementVisible(logInButton) && isElementClickable(logInButton),
                    "PayPal Login button doesn't present on page.");

            fillField(email, user.getPaypalEmail());
            fillField(password, user.getPaypalPassword());

            // Disable focus from password field
            // Sometimes if we don't change focus get error 'Incorrect password'
            findElement(email).click();

            // Attache screenshot with filled data
            CommonFunctions.attachScreenshot("Login PayPal Page");

            getDriver().findElement(logInButton).click();
        }

        if (isNewPayPal) {
            // waiting for spinner
            switchToDefaultIframe();
            waitForElementVisible(By.id("spinner"));
            waitForElementInvisibility(By.id("spinner"));
        }

        CommonFunctions.attachScreenshot("Login PayPal Page after SignIn");
    }

    /**
     * Function for confirmation pay after sign in.
     */
    public void confirmationPay() {

        By confirm = By.id("confirmButtonTop");

        if (isElementVisible(confirm)) {
            waitForAjax();
            assertTrue(isElementClickable(confirm),
                    "PayPal confirmation button doesn't present on page or not clickable.");

            // experimental sleep
            CommonFunctions.sleep(1000);
            getDriver().findElement(confirm).click();
        }

    }

    /**
     * Log out from PayPal
     */
    public void logOut() {
        getDriver().navigate().to("https://sandbox.paypal.com/myaccount/logout");
    }

    private void fillField(By field, String value) {
        WebElement emailField = getDriver().findElement(field);
        emailField.clear();
        emailField.sendKeys(value);
    }

    @Override
    public boolean isExist() {
        return false;
    }

    @Override
    public boolean isExist(int timeout) {
        return false;
    }
}
