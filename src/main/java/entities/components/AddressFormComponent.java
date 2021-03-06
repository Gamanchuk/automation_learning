package entities.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.CommonFunctions;

import static org.testng.Assert.assertTrue;

public class AddressFormComponent extends BaseComponent {

    private By nameField = By.cssSelector(".name-input input");
    private By emailField = By.cssSelector(".email-input input");
    private By addressField = By.cssSelector(".address-line1 input");
    private By apartmentField = By.cssSelector(".address-line2 input");
    private By phoneField = By.cssSelector(".phone-input input");
    private By cityField = By.cssSelector(".city-input input");
    private By stateSelect = By.cssSelector(".state-input select");
    private By stateField = By.cssSelector(".state-input input");
    private By zipField = By.cssSelector(".zip-input input");
    private By title = By.xpath("//div[contains(@class, 'component-input')]//select");
    private By manualLink = By.cssSelector("a.manual");

    public void fillAddressForm(String fullName, String address, String cityInfo, String city, String apartment, String phone, String state, String zip, boolean autoFill, boolean canadian) {

        boolean apartmentPresent = isElementVisible(apartmentField, 3);

        fillField(nameField, fullName);
        fillField(addressField, address);

        CommonFunctions.sleep(1000);

        if (!apartmentPresent) {
            // Waiting for dropdown
            assertTrue(isElementPresent(manualLink, 30), "Input address manually link was not displayed");
            CommonFunctions.attachScreenshot("drop Down");

            // Need wait. Sometimes we have NoSuchElement
            CommonFunctions.sleep(1000);
        }

        if (autoFill) {
            findElementWithTextBy(city, By.cssSelector("div.radio-list-details p.subtext")).click();
        } else {
            if (!apartmentPresent) {
                WebElement manualLinkEl = findElement(manualLink);
                scroll(manualLinkEl);
                manualLinkEl.click();
            }

            fillField(cityField, city);
            fillField(zipField, zip);

            if (canadian) {
                fillField(stateField, state);
            } else {
                fillState(state);
            }
        }

        // Need to sleep for second to avoid selenium exception
        CommonFunctions.sleep(1000);
        assertTrue(isElementVisible(apartmentField), "Apartment field doesn't present on page.");
        fillField(apartmentField, apartment);

        // Need to send phone number digit by digit
        if (isElementPresent(phoneField, 2)) {
            fillPhone(phone);
        }
    }

    public void fillAddress(String fullName, String address, String cityInfo, String city, String apartment, String state, String zip, boolean autoFill) {

        boolean apartmentPresent = isElementVisible(apartmentField, 3);

        fillField(nameField, fullName);
        fillField(addressField, address);

        CommonFunctions.sleep(1000);

        if (!apartmentPresent) {
            // Waiting for dropdown
            assertTrue(isElementVisible(manualLink), "Input address manually link was not displayed");
            CommonFunctions.attachScreenshot("drop Down");

            // Need wait. Sometimes we have NoSuchElement
            CommonFunctions.sleep(1000);
        }

        if (autoFill) {
            findElementWithTextBy(cityInfo, By.cssSelector("div.radio-list-details p.subtext")).click();
        } else {
            if (!apartmentPresent) {
                click(manualLink);
            }

            fillField(cityField, city);
            fillField(zipField, zip);
            fillState(state);
        }

        // Need to sleep for second to avoid selenium exception
        CommonFunctions.sleep(1000);
        assertTrue(isElementVisible(apartmentField), "Apartment field doesn't present on page.");
        fillField(apartmentField, apartment);
    }

    public void inputValueIntoField(String value, String field) {
        By fieldEl = getFieldByName(field);
        fillField(fieldEl, value);
        CommonFunctions.sleep(500);
        focusOut(findElement(fieldEl));
    }

    public void fillPhone(String phone) {
        findElement(phoneField).clear();
        sendKeysOneByOne(phoneField, phone);
        CommonFunctions.sleep(500);
        focusOut(findElement(phoneField));
    }

    public void fillState(String state) {
        WebElement stateEl;

//        if (international) {
//            stateEl = findElement(stateField);
//            scroll(stateEl);
//            stateEl.sendKeys(state);
//        } else {
        stateEl = findElement(stateSelect);
        scroll(stateEl);
        Select selectState = new Select(stateEl);
        selectState.selectByValue(state);
        // }
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
                return stateSelect;
            case "Zip Code":
                return zipField;
            case "Phone Number":
                return phoneField;
            case "Email":
                return emailField;
            default:
                throw new Error("Unknown field name: " + name);
        }
    }

    private void fillField(By field, String value) {
        WebElement element = findElement(field);
        scroll(element);
        CommonFunctions.sleep(500);
        element.clear();
        CommonFunctions.sleep(1000);
        element.sendKeys(value);
        CommonFunctions.sleep(500);
    }

    public void selectTitle(String value) {
        WebElement titleEl = findElement(title);
        scroll(titleEl);
        Select selectState = new Select(titleEl);
        selectState.selectByVisibleText(value);
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
