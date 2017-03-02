package components.pages.pepboys;


import components.Component;
import org.openqa.selenium.By;
import utils.CommonFunctions;
import utils.pepboys.BillingUser;

public class PayPalLoginPage extends Component {

    public void doLogin(BillingUser user) {

        switchToIframe("injectedUl");

        By logInButton = By.id("btnLogin");

        waitForElementClickable(logInButton);

        getDriver().findElement(By.id("email")).sendKeys(user.getPaypalEmail());
        getDriver().findElement(By.id("password")).sendKeys(user.getPaypalPassword());

        CommonFunctions.attachScreenshot("Login PayPal Page");
        getDriver().findElement(logInButton).click();

        // waiting for spinner
        switchToDefaultIframe();
        waitForElementVisible(By.id("spinner"));
        waitForElementInvisibility(By.id("spinner"));

        CommonFunctions.attachScreenshot("Login PayPal Page after SignIn");
    }

   public void confirmationPay(){

       //switchToIframe("injectedUl");
        By continueButton = By.id("confirmButtonTop");

        waitForElementClickable(continueButton);

        getDriver().findElement(continueButton).click();

    }
}
