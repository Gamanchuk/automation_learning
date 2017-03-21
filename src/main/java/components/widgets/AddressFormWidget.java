package components.widgets;

import components.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddressFormWidget extends Component {

    private By nameField = By.id("billing-name");
    private By addressField = By.id("billing-address-line1");
    private By apartmentField = By.id("billing-address-line2");
    private By phoneField = By.id("billing-tel");
    private By cityField = By.id("billing-locality");
    private By stateField = By.id("billing-address-level1");
    private By zipField = By.id("billing-postal-code");


//    private By continueBtn = By.xpath("//button[text()='Continue']");
//    private By placeOrderBtn = By.xpath("//div[@class='order-review-container']/div[@class='place-order-button well']/div[@class='component submit-button']/button[@class='main-button']");
//    private By signInButton = By.xpath("//button[text()='Sign In']");
//    private By signInCheckoutButton = By.xpath("//button[text()='Sign In & Checkout']");
//    private By ccNumber = By.id("cc-number");

    // Billing info: element path


    public void fillAddressForm(String fullName, String address, String cityInfo, String city, String apartment, String phone, String state, String zip, boolean autoFill) {
        fillField(nameField, fullName);
        fillField(addressField, address);

        if (autoFill) {
            // Waiting for dropdown
            click(By.xpath("(//div[contains(., '" + cityInfo + "')]/../input[@name='addresses'])[1]"));
        } else {
            click(By.xpath("//a[@class='manual']"));
            fillField(cityField, city);
            fillField(zipField, zip);
            fillZip(zip);
        }

        waitForElementVisible(apartmentField);
        fillField(apartmentField, apartment);

        // Need to send phone number digit by digit
        sendKeysOneByOne(phoneField, phone);
        focusOut();
    }

//    public void checkBillingInfo(BillingUser user) {
//        waitForElementClickable(By.xpath("//div[contains(@class, 'radio-list') and contains(@class, 'radio-collapsed')]"));
//
//        getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
//        String userName = getDriver().findElement(deliveryName).getText();
//        String fullAddress = getDriver().findElement(deliveryStreetAddress).getText();
//        String cityInfo = getDriver().findElement(deliveryCityInfo).getText();
//        String phone = getDriver().findElement(deliveryPhone).getText();
//        String email = getDriver().findElement(deliveryEmail).getText();
//
//        CommonFunctions.attachScreenshot("Billing info");
//
//        String[] address = fullAddress.split(" ");
//        fullAddress = address[0] + " " + address[1] + " " + address[2];
//
//
//        assertEquals(userName, user.getFullName());
//        assertTrue(user.getFullAddress().toLowerCase().contains(fullAddress.toLowerCase()));
//        assertEquals(cityInfo, user.getCity() + ", " + user.getState() + " " + user.getZipCode());
//        assertEquals(phone, user.getFormattedPhone());
//        assertEquals(email, user.getEmail());
//    }
//
//    public void checkBillingInfo(String field, String value) {
//        waitForElementClickable(By.xpath("//div[contains(@class, 'radio-list') and contains(@class, 'radio-collapsed')]"));
//        String[] cityInfo;
//
//        getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
//
//        CommonFunctions.attachScreenshot("Billing info");
//
//        switch (field) {
//            case "name":
//                String name = getDriver().findElement(deliveryName).getText();
//                assertEquals(name, value);
//                break;
//            case "street address":
//                String streetAddress = getDriver().findElement(deliveryStreetAddress).getText();
//                assertEquals(streetAddress, value);
//                break;
//            case "apt":
//                String apt = getDriver().findElement(deliveryApt).getText();
//                assertEquals(apt, value);
//                break;
//            case "cityInfo":
//                cityInfo = getDriver().findElement(deliveryCityInfo).getText().split(" ");
//                assertEquals(cityInfo[0].split(",")[0], value);
//                break;
//            case "state":
//                // Add handle state popup
//                break;
//            case "zip":
//                cityInfo = getDriver().findElement(deliveryCityInfo).getText().split(" ");
//                assertEquals(cityInfo[cityInfo.length - 1], value);
//                break;
//            case "phone":
//                String phone = getDriver().findElement(deliveryPhone).getText();
//
//                String mask = "(###) ###-####";
//                String result = null;
//
//                try {
//                    MaskFormatter maskFormatter = new MaskFormatter(mask);
//                    maskFormatter.setValueContainsLiteralCharacters(false);
//                    result = maskFormatter.valueToString(value);
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//
//                assertEquals(phone, result);
//
//                break;
//            case "email":
//                String email = getDriver().findElement(deliveryEmail).getText();
//                assertEquals(email, value);
//                break;
//        }
//    }

//    public void navigateToBillingTab(String tab) {
//        getDriver().findElement(By.xpath("//div[@class='component breadcrumbs']/a[text()='" + tab + "']")).click();
//
//        switch (tab) {
//            case "Billing & Shipping":
//                waitForElementClickable(nameField);
//                break;
//            case "Delivery Method":
//                break;
//            case "Payment & Review":
//                break;
//        }
//    }
//
//    public void selectShippingMethod(String shippingMethod) {
//
//        waitForElementVisible(By.xpath("//h2[text()='Shipping Address']"));
//        this.select(shippingMethod);
//
//        focusOut();
//        CommonFunctions.attachScreenshot("Shipping method");
//        click(continueBtn);
//    }
//
//    public void inputPaymentDetails(CreditCard card) {
//        waitForElementVisible(ccNumber);
//
//        getDriver().findElement(By.id("cc-number")).sendKeys(card.getNumber());
//        getDriver().findElement(By.id("cc-exp")).sendKeys(card.getExpDate());
//        getDriver().findElement(By.id("cc-csc")).sendKeys(card.getCvv());
//
//        // Element must be displayed if you pay as registered user
//        if (getDriver().findElement(By.id("-cc-name")).isDisplayed())
//            getDriver().findElement(By.id("-cc-name")).sendKeys("");
//        getDriver().findElement(By.id("-cc-name")).sendKeys(card.getCardholderName());
//
//        CommonFunctions.attachScreenshot("Payment details");
//    }
//
//    public void purchaseWithPayPal() {
//        waitForElementVisible(ccNumber);
//        getDriver().findElement(By.xpath("//a[@data-analytics-name='Paypal']")).click();
//    }
//
//    public void confirmsPurchase() {
//        waitForElementClickable(placeOrderBtn);
//        getDriver().findElement(By.xpath("//div[contains(@class, 'total-cost')]")).click();
//        CommonFunctions.attachScreenshot("Confirms");
//        getDriver().findElement(placeOrderBtn).click();
//    }
//
//    public void checkPaymentResult() {
//        By thanksMsg = By.xpath("//div[@class='order-thank-you inset-all']/div");
//        waitForElementVisible(thanksMsg, 100);
//
//        String message = getDriver().findElement(thanksMsg).getText().toLowerCase();
//        assertTrue(message.contains("thank you for your order"));
//
//        CommonFunctions.attachScreenshot("Thank You Page");
//    }
//
//    public void doLogin(BillingUser user) {
//        getDriver().findElement(signInButton).click();
//        waitForElementClickable(signInCheckoutButton);
//
//        WebElement emailField = getDriver().findElement(By.id("shipping-email"));
//        emailField.clear();
//        emailField.sendKeys(user.getEmail());
//
//        WebElement passwordField = getDriver().findElement(By.id("password"));
//        passwordField.clear();
//        passwordField.sendKeys(user.getPassword());
//
//        focusOut();
//        CommonFunctions.attachScreenshot("Login page");
//        getDriver().findElement(signInCheckoutButton).click();
//    }
//
//    public void applyBillingInfo(String address) {
//
//        // TODO: Re-work this function
//        //  waitForElementClickable(continueBtn);
//
//        try {
//            Thread.sleep(30000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        // TODO: There's an issue which address dropdown, the wrong address is selected by default.
//        // Need to handle it somehow
//        this.select(address);
//        CommonFunctions.attachScreenshot("Billing info");
//    }
//
//    private void select(String arg) {
//        By shippingMethodOptionEl = By.xpath("//div[contains(text(), '" + arg + "')]");
//        if (!isElementPresent(shippingMethodOptionEl)) {
//            click(By.xpath("//div[contains(@class, 'radio-list') and contains(@class, 'radio-collapsed')]"));
//            click(shippingMethodOptionEl);
//        }
//    }
//
//    public void chooseAddressType(String addressType) {
//
//        By item = By.xpath("//div[@class='radio-list-option' and contains(., '" + addressType + "')]");
//
//        if (isElementVisible(item, 5)) {
//            getDriver().findElement(item).click();
//            CommonFunctions.attachScreenshot("Choice address type");
//        }
//    }
//

    public void inputValueIntoField(String value, String field) {
        By fieldEl = getFieldByName(field);
        fillField(fieldEl, value);
    }

    public void fillPhone(String phone) {
        getDriver().findElement(phoneField).clear();
        sendKeysOneByOne(phoneField, phone);
    }

    public void fillZip(String zip) {
        WebElement state = getDriver().findElement(stateField);
        state.click();

        Select selectState = new Select(state);
        selectState.selectByValue(zip);
    }

    private By getFieldByName(String name) {
        switch (name) {
            case "Full Name":
                return nameField;
            case "Street Address":
                return addressField;
            case "Apt, Bldg.":
                return apartmentField;
            case "City":
                return cityField;
            case "State":
                return stateField;
            case "Zip Code":
                return zipField;
            case "Phone Number":
                return phoneField;
            default:
                throw new Error("Unknown field name: " + name);
        }
    }

    private void fillField(By field, String value) {
        WebElement element = getDriver().findElement(field);
        element.clear();
        element.sendKeys(value);
    }
}
