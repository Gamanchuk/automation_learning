package components.pages.pepboys;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import utils.CommonFunctions;
import utils.pepboys.BillingUser;
import utils.pepboys.CreditCard;

import static org.testng.AssertJUnit.assertEquals;

public class PepBoysBillingPage extends PepBoysBasePage {

    private String data;
    private static Log log = LogFactory.getLog(PepBoysBillingPage.class);

    private By continueBtn = By.xpath("//button[text()='Continue']");
    private By placeOrderBtn = By.xpath("//div[@class='order-review-container']/div[@class='place-order-button well']/div[@class='component submit-button']/button[@class='main-button']");
    private By signInButton = By.xpath("//button[text()='Sign In']");
    private By signInCheckoutButton = By.xpath("//button[text()='Sign In & Checkout']");


    public void inputBillingInfo(BillingUser user) {
        getDriver().findElement(By.id("billing-name")).sendKeys(user.getName());
        getDriver().findElement(By.id("billing-address-line1")).sendKeys(user.getAddress());

        click(By.xpath("(//div[contains(., '" + user.getCityInfo() + "')]/../input[@name='addresses'])[1]"));

        waitForElementVisible(By.id("billing-address-line2"));
        getDriver().findElement(By.id("billing-address-line2")).sendKeys(user.getApartment());
        getDriver().findElement(By.id("billing-email")).sendKeys(user.getEmail());

        // Need to send phone number digit by digit
        sendKeysOneByOne(By.id("billing-tel"), user.getPhone());

        CommonFunctions.attachScreenshot("Billing info");

        // Disable focus from input field. ( Fix problem on iOS)
        getDriver().findElement(By.xpath("//div[@class='address-container well'][2]")).click();

        ((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(0,250)", "");
        getDriver().findElement(continueBtn).click();

        this.useRecommended();
    }

    public void selectShippingMethod(String shippingMethod) {

        waitForElementVisible(By.xpath("//h2[text()='Shipping Address']"));
        this.select(shippingMethod);

        //TODO: Getting shipping method price to recheck in order
//        String option = getDriver().findElement(shippingMethodOptionEl).getText();
//        float shippingPrice = CommonFunctions.getCurrency(option);
//        TestGlobalsManager.setTestGlobal("shippingPrice", shippingPrice);

        focusOut();
        CommonFunctions.attachScreenshot("Shipping method");
        click(continueBtn);
    }

    public void inputPaymentDetails(CreditCard card) {
        waitForElementVisible(By.id("cc-number"));

        getDriver().findElement(By.id("cc-number")).sendKeys(card.getNumber());
        getDriver().findElement(By.id("cc-exp")).sendKeys(card.getExpDate());
        getDriver().findElement(By.id("cc-csc")).sendKeys(card.getCvv());

        // Element must be displayed if you pay as registered user
        if (getDriver().findElement(By.id("-cc-name")).isDisplayed())
            getDriver().findElement(By.id("-cc-name")).sendKeys("");
        getDriver().findElement(By.id("-cc-name")).sendKeys(card.getCardholderName());


        CommonFunctions.attachScreenshot("Payment details");

        this.confirmsPurchase();
    }

    public void confirmsPurchase() {
        waitForElementClickable(placeOrderBtn);
        getDriver().findElement(By.xpath("//div[contains(@class, 'total-cost')]")).click();
        CommonFunctions.attachScreenshot("Confirms");
        getDriver().findElement(placeOrderBtn).click();
    }

    public void checkPaymentResult() {
        By thanksMsg = By.cssSelector("span.thankmsg");
        waitForElementVisible(thanksMsg);
        assertEquals(getDriver().findElement(thanksMsg).getText(), "Thank You for Your Order");
        CommonFunctions.attachScreenshot("Thank You Page");
    }

    public void doLogin(BillingUser user) {
        getDriver().findElement(signInButton).click();
        waitForElementClickable(signInCheckoutButton);

        getDriver().findElement(By.id("shipping-email")).sendKeys(user.getEmail());
        getDriver().findElement(By.id("password")).sendKeys(user.getPassword());
        focusOut();
        CommonFunctions.attachScreenshot("Login page");
        getDriver().findElement(signInCheckoutButton).click();
    }

    public void applyBillingInfo(String address) {
        waitForElementClickable(continueBtn);

        this.select(address);
        CommonFunctions.attachScreenshot("Billing info");
        getDriver().findElement(continueBtn).click();

        // If you long time on page appears a window with a choice 'Recommended Address'. May be it is bug or incorrect behavior
        //this.useRecommended();
    }

    private void select(String arg) {
        By shippingMethodOptionEl = By.xpath("//div[contains(text(), '" + arg + "')]");
        if (!isElementPresent(shippingMethodOptionEl)) {
            click(By.xpath("//div[contains(@class, 'radio-list') and contains(@class, 'radio-collapsed')]"));
            click(shippingMethodOptionEl);
        }
    }

    private void useRecommended() {
        By recommendedAddressRadio = By.xpath("//div[@class='radio-list-option' and contains(., 'Use Recommended Address')]");
        waitForElementVisible(recommendedAddressRadio);
        getDriver().findElement(recommendedAddressRadio).click();
    }
}
