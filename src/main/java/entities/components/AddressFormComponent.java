package entities.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.CommonFunctions;

import static org.testng.Assert.assertTrue;

public class AddressFormComponent extends BaseComponent {

    private By nameField = By.cssSelector(".name-input input");
    private By addressField = By.cssSelector(".address-line1 input");
    private By apartmentField = By.cssSelector(".address-line2 input");
    private By phoneField = By.cssSelector(".phone-input input");
    private By cityField = By.cssSelector(".city-input input");
    private By stateField = By.cssSelector(".state-input select");
    private By zipField = By.cssSelector(".zip-input input");

    public void fillAddressForm(String fullName, String address, String cityInfo, String city, String apartment, String phone, String state, String zip, boolean autoFill) {
        fillField(nameField, fullName);
        fillField(addressField, address);

        CommonFunctions.sleep(1000);

        // Waiting for dropdown
        assertTrue(isElementVisible(By.cssSelector("a.manual")), "Input address manually link was not displayed");
        CommonFunctions.attachScreenshot("drop Down");
        if (autoFill) {
            findElementWithTextBy(cityInfo, By.cssSelector("div.radio-list-details p.subtext")).click();
        } else {
            click(By.cssSelector("a.manual"));
            //findElementWithTextBy("enter city", By.cssSelector("div.zip-message a")).click();
            fillField(cityField, city);
            fillField(zipField, zip);
            fillState(state);
        }

        // Need to sleep for second to avoid selenium exception
        CommonFunctions.sleep(1000);
        assertTrue(isElementVisible(apartmentField), "Apartment field doesn't present on page.");
        fillField(apartmentField, apartment);

        // Need to send phone number digit by digit
        fillPhone(phone);
        focusOut(findElement(phoneField));
    }

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

    public void inputValueIntoField(String value, String field) {
        By fieldEl = getFieldByName(field);
        fillField(fieldEl, value);
        focusOut(findElement(fieldEl));
    }

    public void fillPhone(String phone) {
        findElement(phoneField).clear();
        sendKeysOneByOne(phoneField, phone);
        focusOut(findElement(phoneField));
    }

    public void fillState(String state) {
        WebElement stateEl = findElement(stateField);
        javascriptScroll(stateEl);
        Select selectState = new Select(stateEl);
        selectState.selectByValue(state);
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
        WebElement element = findElement(field);
        javascriptScroll(element);
        element.clear();
        element.sendKeys(value);
    }
}
