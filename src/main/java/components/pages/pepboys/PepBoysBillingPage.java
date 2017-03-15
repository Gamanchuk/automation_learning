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
    private By billingCity = By.id("billing-locality");
    private By billingState = By.id("billing-address-level1");
    private By billingZip = By.id("billing-postal-code");

    private By deliveryApt = By.xpath("//div[@class='address-line2']");
    private By deliveryName = By.xpath("//div[@class='address-recipient']");

    public void inputBillingInfo(BillingUser user) {
        getDriver().findElement(billingName).sendKeys(user.getFullName());
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
        getDriver().findElement(billingName).sendKeys(user.getFullName());
        getDriver().findElement(billingAddress).sendKeys(user.getFullAddress());

        click(By.xpath("//a[@class='manual']"));

        waitForElementVisible(billingApartment);
        getDriver().findElement(billingApartment).sendKeys(user.getApartment());

        getDriver().findElement(billingCity).sendKeys(user.getCity());

        WebElement state = getDriver().findElement(billingState);
        state.click();

        Select selectState = new Select(state);
        selectState.selectByValue(user.getState());

        getDriver().findElement(billingZip).sendKeys(user.getZipCode());

        // Need to send phone number digit by digit
        sendKeysOneByOne(billingPhone, user.getPhone());
        getDriver().findElement(billingEmail).sendKeys(user.getEmail());

        CommonFunctions.attachScreenshot("Billing info manually");

        focusOut();
    }

    public void inputBillingInfoOneByOne(String value, String field) {

        WebElement element = null;

        switch (field) {
            case "name":
                element = getDriver().findElement(billingName);
                element.clear();
                element.sendKeys(value);
                break;
            case "last name":
                element = getDriver().findElement(billingName);
                element.clear();
                element.sendKeys(value);
                break;
            case "street address":
                element = getDriver().findElement(billingAddress);
                element.clear();
                element.sendKeys(value);
                break;
            case "apt":
                element = getDriver().findElement(billingApartment);
                element.clear();
                element.sendKeys(value);
                break;
            case "city":
                element = getDriver().findElement(billingCity);
                element.clear();
                element.sendKeys(value);
                break;
            case "state":
                WebElement state = getDriver().findElement(billingState);
                state.click();

                Select selectState = new Select(state);
                selectState.selectByValue(value);
                break;
            case "zip":
                element = getDriver().findElement(billingZip);
                element.clear();
                element.sendKeys(value);
                break;
            case "phone":
                element = getDriver().findElement(billingPhone);
                element.clear();
                sendKeysOneByOne(billingPhone, value);
                break;
            case "email":
                element = getDriver().findElement(billingEmail);
                element.clear();
                element.sendKeys(value);
                break;
        }


    }

    public void checkBillingInfo(BillingUser user) {
        waitForElementClickable(By.xpath("//div[contains(@class, 'radio-list') and contains(@class, 'radio-collapsed')]"));

        getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        String userName = getDriver().findElement(deliveryName).getText();
        String fullAddress = getDriver().findElement(By.xpath("//div[@class='address-line1']")).getText();
        String cityInfo = getDriver().findElement(By.xpath("//div[@class='address-city-state-zip']")).getText();
        String phone = getDriver().findElement(By.xpath("//a[@class='phone-display address-phone']")).getText();
        String email = getDriver().findElement(By.xpath("//div[@class='address-email']")).getText();

        CommonFunctions.attachScreenshot("Billing info");

        String[] address = fullAddress.split(" ");
        fullAddress = address[0] + " " + address[1] + " " + address[2];


        assertEquals(userName, user.getFullName());
        assertTrue(user.getFullAddress().toLowerCase().contains(fullAddress.toLowerCase()));
        assertEquals(cityInfo, user.getCity() + ", " + user.getState() + " " + user.getZipCode());
        assertEquals(phone, user.getFormattedPhone());
        assertEquals(email, user.getEmail());
    }

    public void checkBillingInfo(String field, String value) {
        waitForElementClickable(By.xpath("//div[contains(@class, 'radio-list') and contains(@class, 'radio-collapsed')]"));


        getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
//        String userName = getDriver().findElement(By.xpath("//div[@class='address-recipient']")).getText();
//        String fullAddress = getDriver().findElement(By.xpath("//div[@class='address-line1']")).getText();
//        String cityInfo = getDriver().findElement(By.xpath("//div[@class='address-city-state-zip']")).getText();
//        String phone = getDriver().findElement(By.xpath("//a[@class='phone-display address-phone']")).getText();
//        String email = getDriver().findElement(By.xpath("//div[@class='address-email']")).getText();

        CommonFunctions.attachScreenshot("Billing info");
//
//        String[] address = fullAddress.split(" ");
//        fullAddress = address[0] + " " + address[1] + " " + address[2];


        switch (field) {
            case "name":
                String name = getDriver().findElement(deliveryName).getText();
                assertEquals(name, value);
                break;
            case "last name":

                break;
            case "street address":

                break;
            case "apt":
                String apt = getDriver().findElement(deliveryApt).getText();
                assertEquals(apt, value);
                break;
            case "city":

                break;
            case "state":

                break;
            case "zip":

                break;
            case "phone":

                break;
            case "email":

                break;
        }
    }

    public void navigateToBillingTab(String tab) {
        getDriver().findElement(By.xpath("//div[@class='component breadcrumbs']/a[text()='" + tab + "']")).click();

        switch (tab) {
            case "Billing & Shipping":
                waitForElementClickable(billingName);
                break;
            case "Delivery Method":
                break;
            case "Payment & Review":
                break;
        }
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

        // TODO: Re-work this function
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

    public void chooseAddressType(String addressType) {

        By item = By.xpath("//div[@class='radio-list-option' and contains(., '" + addressType + "')]");

        if (isElementVisible(item, 5)) {
            getDriver().findElement(item).click();
            CommonFunctions.attachScreenshot("Choice address type");
        }
    }

    public void checkBillingInfoFormError() {
        String path = "//div[@class='component message-panel message-panel-form-error']";
        String errorTitle = getDriver().findElement(By.xpath(path + "/h2")).getText();
        String errorMessage = getDriver().findElement(By.xpath(path + "/div")).getText();

        assertEquals(errorTitle.toLowerCase(), "form errors");
        assertEquals(errorMessage.toLowerCase(), "please review all inputs.");
    }

    private void select(String arg) {
        By shippingMethodOptionEl = By.xpath("//div[contains(text(), '" + arg + "')]");
        if (!isElementPresent(shippingMethodOptionEl)) {
            click(By.xpath("//div[contains(@class, 'radio-list') and contains(@class, 'radio-collapsed')]"));
            click(shippingMethodOptionEl);
        }
    }
}

