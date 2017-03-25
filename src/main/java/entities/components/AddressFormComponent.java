package entities.components;

import entities.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddressFormComponent extends Component {

    private By nameField = By.id("billing-name");
    private By addressField = By.id("billing-address-line1");
    private By apartmentField = By.id("billing-address-line2");
    private By phoneField = By.id("billing-tel");
    private By cityField = By.id("billing-locality");
    private By stateField = By.id("billing-address-level1");
    private By zipField = By.id("billing-postal-code");

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
