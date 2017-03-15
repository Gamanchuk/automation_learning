package components.pages.pepboys;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.CommonFunctions;
import utils.pepboys.BillingUser;
import utils.pepboys.CreditCard;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class PepBoysBillingPage extends PepBoysBasePage {

    private By continueBtn = By.xpath("//button[text()='Continue']");
    private By placeOrderBtn = By.xpath("//div[@class='order-review-container']/div[@class='place-order-button well']/div[@class='component submit-button']/button[@class='main-button']");
    private By signInButton = By.xpath("//button[text()='Sign In']");
    private By signInCheckoutButton = By.xpath("//button[text()='Sign In & Checkout']");
    private By ccNumber = By.id("cc-number");

    // Billing info: element path
    private By billingName = By.id("billing-name");
    private By billingAddress = By.id("billing-address-line1");
    private By billingApartment = By.id("billing-address-line2");
    private By billingPhone = By.id("billing-tel");
    private By billingEmail = By.id("billing-email");


    public void inputBillingInfo(BillingUser user) {
        getDriver().findElement(billingName).sendKeys(user.getName());
        getDriver().findElement(billingAddress).sendKeys(user.getFullAddress());

        click(By.xpath("(//div[contains(., '" + user.getCityInfo() + "')]/../input[@name='addresses'])[1]"));

        waitForElementVisible(billingApartment);
        getDriver().findElement(billingApartment).sendKeys(user.getApartment());

        // Need to send phone number digit by digit
        sendKeysOneByOne(billingPhone, user.getPhone());
        getDriver().findElement(billingEmail).sendKeys(user.getEmail());

        CommonFunctions.attachScreenshot("Billing info");

        focusOut();
    }

    public void inputBillingInfoManually(BillingUser user) {
        getDriver().findElement(billingName).sendKeys(user.getName());
        getDriver().findElement(billingAddress).sendKeys(user.getFullAddress());

        click(By.xpath("//a[@class='manual']"));

        waitForElementVisible(billingApartment);
        getDriver().findElement(billingApartment).sendKeys(user.getApartment());

        getDriver().findElement(By.id("billing-locality")).sendKeys(user.getCity());

        WebElement state = getDriver().findElement(By.id("billing-address-level1"));
        state.click();

        Select selectState = new Select(state);
        selectState.selectByValue(user.getState());

        getDriver().findElement(By.id("billing-postal-code")).sendKeys(user.getZipCode());

        // Need to send phone number digit by digit
        sendKeysOneByOne(billingPhone, user.getPhone());
        getDriver().findElement(billingEmail).sendKeys(user.getEmail());

        CommonFunctions.attachScreenshot("Billing info manually");

        focusOut();
    }

    public void checkBillingInfo(BillingUser user) {
        waitForElementClickable(By.xpath("//div[contains(@class, 'radio-list') and contains(@class, 'radio-collapsed')]"));

        getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        String userName = getDriver().findElement(By.xpath("//div[@class='address-recipient']")).getText();
        String fullAddress = getDriver().findElement(By.xpath("//div[@class='address-line1']")).getText();
        String cityInfo = getDriver().findElement(By.xpath("//div[@class='address-city-state-zip']")).getText();
        String phone = getDriver().findElement(By.xpath("//a[@class='phone-display address-phone']")).getText();
        String email = getDriver().findElement(By.xpath("//div[@class='address-email']")).getText();

        CommonFunctions.attachScreenshot("Billing info");

        String[] address = fullAddress.split(" ");
        fullAddress = address[0] + " " + address[1] + " " + address[2];


        assertEquals(userName, user.getName());
        assertTrue(user.getFullAddress().toLowerCase().contains(fullAddress.toLowerCase()));
        assertEquals(cityInfo, user.getCity() + ", " + user.getState() + " " + user.getZipCode());
        assertEquals(phone, user.getFormattedPhone());
        assertEquals(email, user.getEmail());


    }

    public void confirmBillingInfo(String confirmMethod) {
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(0,300)", "");

        if (confirmMethod.equals("Continue")) {
            CommonFunctions.attachScreenshot("Shipping info");
            getDriver().findElement(continueBtn).click();
        } else if (confirmMethod.equals("Place Order")) {
            getDriver().findElement(By.xpath("//div[contains(@class, 'total-cost')]")).click();
            CommonFunctions.attachScreenshot("Billing info");
            getDriver().findElement(placeOrderBtn).click();
        }

    }

    public void selectShippingMethod(String shippingMethod) {

        waitForElementVisible(By.xpath("//h2[text()='Shipping Address']"));
        this.select(shippingMethod);

        focusOut();
        CommonFunctions.attachScreenshot("Shipping method");
        click(continueBtn);
    }

    public void inputPaymentDetails(CreditCard card) {
        waitForElementVisible(ccNumber);

        getDriver().findElement(By.id("cc-number")).sendKeys(card.getNumber());
        getDriver().findElement(By.id("cc-exp")).sendKeys(card.getExpDate());
        getDriver().findElement(By.id("cc-csc")).sendKeys(card.getCvv());

        // Element must be displayed if you pay as registered user
        if (getDriver().findElement(By.id("-cc-name")).isDisplayed())
            getDriver().findElement(By.id("-cc-name")).sendKeys("");
        getDriver().findElement(By.id("-cc-name")).sendKeys(card.getCardholderName());

        CommonFunctions.attachScreenshot("Payment details");
    }

    public void purchaseWithPayPal() {
        waitForElementVisible(ccNumber);
        getDriver().findElement(By.xpath("//a[@data-analytics-name='Paypal']")).click();
    }

    public void confirmsPurchase() {
        waitForElementClickable(placeOrderBtn);
        getDriver().findElement(By.xpath("//div[contains(@class, 'total-cost')]")).click();
        CommonFunctions.attachScreenshot("Confirms");
        getDriver().findElement(placeOrderBtn).click();
    }

    public void checkPaymentResult() {
        By thanksMsg = By.xpath("//div[@class='order-thank-you inset-all']/div");
        waitForElementVisible(thanksMsg, 100);

        String message = getDriver().findElement(thanksMsg).getText().toLowerCase();
        assertTrue(message.contains("thank you for your order"));

        CommonFunctions.attachScreenshot("Thank You Page");
    }

    public void doLogin(BillingUser user) {
        getDriver().findElement(signInButton).click();
        waitForElementClickable(signInCheckoutButton);

        WebElement emailField = getDriver().findElement(By.id("shipping-email"));
        emailField.clear();
        emailField.sendKeys(user.getEmail());

        WebElement passwordField = getDriver().findElement(By.id("password"));
        passwordField.clear();
        passwordField.sendKeys(user.getPassword());

        focusOut();
        CommonFunctions.attachScreenshot("Login page");
        getDriver().findElement(signInCheckoutButton).click();
    }

    public void applyBillingInfo(String address) {
        //  waitForElementClickable(continueBtn);

        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // TODO: There's an issue which address dropdown, the wrong address is selected by default.
        // Need to handle it somehow
        this.select(address);
        CommonFunctions.attachScreenshot("Billing info");
    }

    private void select(String arg) {
        By shippingMethodOptionEl = By.xpath("//div[contains(text(), '" + arg + "')]");
        if (!isElementPresent(shippingMethodOptionEl)) {
            click(By.xpath("//div[contains(@class, 'radio-list') and contains(@class, 'radio-collapsed')]"));
            click(shippingMethodOptionEl);
        }
    }

    public void chooseAddressType(String addressType) {

        By item = By.xpath("//div[@class='radio-list-option' and contains(., '" + addressType + "')]");

        if (isElementVisible(item, 5)) {
            getDriver().findElement(item).click();
            CommonFunctions.attachScreenshot("Choice address type");
        }
    }
}

