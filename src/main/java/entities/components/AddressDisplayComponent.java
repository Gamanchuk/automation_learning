package entities.components;

import org.openqa.selenium.By;
import utils.CommonFunctions;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AddressDisplayComponent extends BaseComponent {
    private By addressDisplay = By.cssSelector("div.address-display");
    private By deliveryApt = By.cssSelector("div.address-line2");
    private By deliveryName = By.cssSelector("div.address-recipient");
    private By deliveryStreetAddress = By.cssSelector("div.address-line1");
    private By deliveryCityInfo = By.cssSelector("div.address-city-state-zip");
    private By deliveryPhone = By.cssSelector("a.phone-display.address-phone");
    private By deliveryEmail = By.cssSelector("div.address-email");

    public void checkInfo(String name, String apt, String streetAddress, String cityInfo, String zip, String phone) {
//        waitForElementClickable(By.xpath("//div[contains(@class, 'radio-list') and contains(@class, 'radio-collapsed')]"));
        getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        checkFieldValue("Full Name", name);
        checkFieldValue("Street Address", streetAddress);

        checkStreetAddress(streetAddress);
        checkApt(apt);
        checkCityInfo(cityInfo);

        if (isElementPresent(deliveryPhone, 3)) {
            checkPhone(phone);
        }

        checkZip(zip);

        CommonFunctions.attachScreenshot("Info");
    }

    public void checkStreetAddress(String expectedAddress) {
        assertTrue(isElementVisible(deliveryStreetAddress, 1), "Field: StreetAddress doesn't present on page.");
        String address = findElement(deliveryStreetAddress).getText();
        assertTrue(address.contains(expectedAddress), "Unexpected address. Expected apt: " + expectedAddress
                + ". Actual address: " + address);
    }

    public void checkApt(String expectedApt) {
        assertTrue(isElementVisible(deliveryStreetAddress, 1)
                        && isElementVisible(deliveryApt, 1),
                "Field: StreetAddress or Apt doesn't present on page.");

        String address = findElement(deliveryStreetAddress).getText();
        String apt = findElement(deliveryApt).getText();

        assertTrue(address.contains(expectedApt) || apt.contains(expectedApt),
                "Unexpected apt. Expected apt: " + expectedApt
                        + ". Actual Address doesn't have apt : " + address
                        + ". Actual Apt: " + apt);

    }

    public void checkFieldValue(String fieldName, String expectedValue) {
        By field = getFieldByName(fieldName);
        assertTrue(isElementPresent(field, 1), "Field: " + fieldName + " doesn't present on page.");
        String fieldValue = findElement(field).getText();
        assertEquals(fieldValue, expectedValue, "Unexpected " + fieldName);


    }

    public void checkCityInfo(String expectedCityInfo) {
        assertTrue(isElementVisible(deliveryCityInfo, 1), "Field: City info doesn't present on page.");
//        String cityInfo = getDriver().findElement(deliveryCityInfo).getText().split(" ");
        String cityInfo = findElement(deliveryCityInfo).getText();
        assertEquals(cityInfo.split(",")[0], expectedCityInfo, "Unexpected city");
    }

    public void checkZip(String expectedZip) {
        assertTrue(isElementVisible(deliveryCityInfo, 1), "Field: City info doesn't present on page.");
//        String cityInfo = getDriver().findElement(deliveryCityInfo).getText().split(" ");
        String cityInfo = findElement(deliveryCityInfo).getText();
        String[] split = cityInfo.split(",")[1].trim().split(" ");
        String zip = split[split.length - 1];
        assertEquals(zip, expectedZip, "Unexpected zip code");
    }

    public void checkPhone(String expectedPhone) {
        assertTrue(isElementVisible(deliveryPhone, 1), "Field: Phone doesn't present on page.");
        String phone = findElement(deliveryPhone).getText();
        String result = null;

        try {
            MaskFormatter maskFormatter = new MaskFormatter("(###) ###-####");
            maskFormatter.setValueContainsLiteralCharacters(false);
            result = maskFormatter.valueToString(expectedPhone);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        assertEquals(phone, result, "Incorrect phone number was saved");
    }

    public String getAddressDisplayData() {
        return findElement(addressDisplay).getText();
    }

    private By getFieldByName(String fieldName) {
        switch (fieldName) {
            case "Full Name":
                return deliveryName;
            case "Street Address":
                return deliveryStreetAddress;
            case "Apt, Bldg.":
                return deliveryApt;
            case "Email":
                return deliveryEmail;
            default:
                throw new Error("Address display component: Unknown field");
        }
    }
}
