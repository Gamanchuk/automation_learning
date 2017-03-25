package entities.components;


import entities.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonFunctions;
import utils.pepboys.BillingUser;

public class PayPalComponent extends Component {

    public void doLogin(BillingUser user) {

        switchToIframe("injectedUl");

        By logInButton = By.id("btnLogin");

        waitForElementClickable(logInButton);

        WebElement emailField = getDriver().findElement(By.id("email"));
        emailField.clear();
        emailField.sendKeys(user.getPaypalEmail());

        WebElement passwordField = getDriver().findElement(By.id("password"));
        passwordField.clear();
        passwordField.sendKeys(user.getPaypalPassword());

        CommonFunctions.attachScreenshot("Login PayPal Page");
        getDriver().findElement(logInButton).click();

        // waiting for spinner
        switchToDefaultIframe();
        waitForElementVisible(By.id("spinner"));
        waitForElementInvisibility(By.id("spinner"));

        CommonFunctions.attachScreenshot("Login PayPal Page after SignIn");
    }

    public void confirmationPay() {
        getDriver().findElement(By.id("confirmButtonTop")).click();
    }
}
