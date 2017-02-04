package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertTrue;

public class BagWidget extends Component {

    private By searchBox = By.id("searchTextmobile");
    private By itemNumber = By.id("itemNumber");
    private By addToBagButton = By.id("submitButton");
    private By viewBagAndCheckOutButton = By.xpath("//li[@class='view-basket']/a");

    private int i = 2;
    private By fullName = By.xpath("//div[@class='mc-input-row mc-focus mc-has-tooltip']/div/div/input");
    // private By fullName = By.xpath("//input[@data-mc-help='Enter first and last name']");
    private By streetAddress = By.xpath("//input[@data-mc-widget-property-group='addressLine1Input']");
    private By aptAddress = By.xpath("//input[@data-mc-widget-property-group='addressLine2Input']");
    private By city = By.xpath("//input[@data-mc-widget-property-group='cityInput']");
    private By state = By.xpath("//input[@data-mc-widget-property-group='stateSelect']");
    private By zipCode = By.xpath("//input[@data-mc-widget-property-group='zipCodeInput']");
    private By telephone = By.xpath("//input[@data-mc-widget-property-group='phoneFullInput']");
    private By continueShipping = By.xpath("//button[@data-mc-widget-property-group='button']");
    private By topMenu = By.xpath("//span[@data-mc-widget-property-group='step" + i + ",activeStep']");

    private By radioButtonAddressVerification = By.xpath("//input[@name='tPAyxhPM']");
    private By continueAddressVerificationButton = By.xpath("//button[@data-mc-widget-property='useEnteredButton']");
    private By payPalPayLink = By.xpath("//a[@data-mc-widget-property='PayPal']");
    private By continueToPayment = By.xpath("//button[@value='CONTINUE TO PAYMENT']");

    private By couponField = By.id("couponField");
    private By applyCoupon = By.id("couponadd");
    private By removeCoupon = By.id("cuponremove");
    private By checkOutPayPal = By.xpath("//input[@class='paypal']");
    private By checkOut = By.xpath("//input[@class='final-checkout']");
    private By samples = By.xpath("//input[@class='samples-ckhbox']");
    private By skipSampleButton = By.xpath("//input[@class='nosamples']");
    private By applySampleButton = By.xpath("//input[@class='addSamples']");
    private By continueAsGuestButton = By.xpath("//div[@title='Continue as Guest']/button[@class='mc-arrow-button']");
    private By checkOutAsGuestButton = By.xpath("//button[@value='GUEST CHECKOUT']");
    private By guestEmail = By.xpath("//input[@data-mc-widget-property='guestEmailInput']");
    private By guestSubmitButton = By.xpath("//button[@data-mc-widget-property='guestSubmitButton']");
    private By iframe = By.id("mc-created-iframe");
    private By orderTotal = By.xpath("//div[@class='mc-total-cost']/span[@data-mc-widget-name='OrderSummarySubmitButton']");
    private By placeOrderButton = By.xpath("//button[contains(text(),'Place Order')]");


    @Override
    public boolean isPage() {
        waitForElementVisible(this.searchBox);
        return true;
    }

    public BagWidget goToPage(String url) {
        driver.navigate().to(url);
        assertTrue(this.isPage(), "User is not on main page");
        return this;
    }

    public BagWidget setTextInSearch(String searchText) {

         driver.findElement(this.searchBox).clear();
        //searchBox.clear();
        driver.findElement(this.searchBox).sendKeys(searchText);
        return this;
    }

    public BagWidget submitSearch() {
        driver.findElement(this.searchBox).submit();
        waitForElementPresence(this.addToBagButton);
        return this;
    }

    public BagWidget actionToBag() {
        waitForElementPresence(this.addToBagButton);
        driver.findElement(this.addToBagButton).click();
        waitForElementVisible(this.viewBagAndCheckOutButton);
        return this;
    }

    public BagWidget actionApplyCoupon() {
        driver.findElement(this.applyCoupon).click();
        waitForElementVisible(this.removeCoupon);
        return this;
    }

    public BagWidget actionApplySample() {
        waitForElementVisible(this.applySampleButton);
        driver.findElement(this.applySampleButton).click();
        return this;
    }

    public BagWidget actionSkipSample() {
        waitForElementVisible(this.skipSampleButton);
        driver.findElement(this.skipSampleButton).click();
        return this;
    }

    public BagWidget actionCheckOutPayPal() {
        waitForElementVisible(this.checkOutPayPal);
        driver.findElement(this.checkOutPayPal).click();
        return this;
    }

    public BagWidget goToPayPalPay() {
        waitForElementVisible(this.payPalPayLink);
        driver.findElement(this.payPalPayLink).click();
        return this;
    }

    public BagWidget placeOrderButtonClick() {
        waitForElementVisible(this.placeOrderButton);
        driver.findElement(this.placeOrderButton).click();
       
        return this;
    }

    public BagWidget actionCheckOut() {
        waitForElementVisible(this.checkOut);
        driver.findElement(this.checkOut).click();
        return this;
    }

    public BagWidget actionContinueCheckout() {
        driver.findElement(this.guestSubmitButton).click();
        return this;
    }

    public BagWidget actionViewBagAndCheckOut() {
        driver.findElement(this.viewBagAndCheckOutButton).click();
        return this;
    }

    public BagWidget actionContinueAddressVerificationButton() {
        waitForElementVisible(this.continueAddressVerificationButton);
        driver.findElement(this.continueAddressVerificationButton).click();
        return this;
    }

    public BagWidget continueAsGuest() {
        waitForElementVisible(this.continueAsGuestButton);
        driver.findElement(this.continueAsGuestButton).click();
        return this;
    }

    public BagWidget continueShipping() {
        waitForElementVisible(this.continueShipping);
        driver.findElement(this.continueShipping).click();
        return this;
    }

    public BagWidget continueToPayment() {
        waitForElementVisible(this.continueToPayment);
        driver.findElement(this.continueToPayment).click();
        return this;
    }

    public BagWidget checkOutAsGuest() {
        waitForElementVisible(this.checkOutAsGuestButton);
        driver.findElement(this.checkOutAsGuestButton).click();
        return this;
    }

    public BagWidget verificationAddress() {
        waitForElementVisible(this.radioButtonAddressVerification);
        List<WebElement> elements = driver.findElements(this.radioButtonAddressVerification);
        elements.get(1).click();
        return this;
    }

    public BagWidget switchToFrame() {
       // waitForElementPresence(iframe);
        driver.switchTo().frame(driver.findElement(iframe));
        return this;
    }

    public BagWidget switchToDefaultFrame() {
        driver.switchTo().defaultContent();
        return this;
    }

    public BagWidget setCoupon(String coupon) {
        waitForElementVisible(this.applyCoupon);
        WebElement element = driver.findElement(this.couponField);
        element.clear();
        element.sendKeys(coupon);
        return this;
    }

    public BagWidget setRandomSample() {
        waitForElementVisible(this.applySampleButton);
        List<WebElement> elements = driver.findElements(this.samples);
        elements.get(new Random().nextInt(elements.size())).click();
        return this;
    }

    public BagWidget setGuestEmail(String email) {

        waitForElementVisible(this.guestEmail);
        WebElement element = driver.findElement(this.guestEmail);
        element.clear();
        element.sendKeys(email);
        return this;
    }

    public String getOrderTotal() {
        waitForElementVisible(this.orderTotal);
        return driver.findElement(this.orderTotal).getText();
    }

    public String getItemNumber() {
        waitForElementVisible(this.addToBagButton);
        String item = driver.findElement(itemNumber).getText();
        return item.split(" #: ")[1];
    }

    public BagWidget setFullName(String fullName) {
        waitForElementVisible(this.fullName);
        WebElement element = driver.findElement(this.fullName);
        element.clear();
        element.sendKeys(fullName);
        return this;
    }

    public BagWidget setStreetAddress(String streetAddress) {
        waitForElementVisible(this.streetAddress);
        WebElement element = driver.findElement(this.streetAddress);
        element.clear();
        element.sendKeys(streetAddress);
        return this;
    }

    public BagWidget setAptAddress(String aptAddress) {
        waitForElementVisible(this.aptAddress);
        WebElement element = driver.findElement(this.aptAddress);
        element.clear();
        element.sendKeys(aptAddress);
        return this;
    }

    public BagWidget setCity(String city) {
        waitForElementVisible(this.city);
        WebElement element = driver.findElement(this.city);
        element.clear();
        element.sendKeys(city);
        return this;
    }

    public BagWidget setState(String state) {
        waitForElementVisible(this.state);
        new Select(driver.findElement(this.state)).selectByVisibleText(state);
        return this;
    }

    public BagWidget setZipCode(String zipCode) {
        waitForElementVisible(this.zipCode);
        WebElement element = driver.findElement(this.zipCode);
        element.clear();
        element.sendKeys(zipCode);
        return this;
    }

    public BagWidget setTelephone(String telephone) {
        waitForElementVisible(this.telephone);
        WebElement element = driver.findElement(this.telephone);
        element.clear();
        element.sendKeys(telephone);
        return this;
    }
}
