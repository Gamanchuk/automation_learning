package entities.components;

import org.openqa.selenium.By;
import utils.CommonFunctions;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class AddressDisplayComponent extends BaseComponent {
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
        checkPhone(phone);
        checkZip(zip);

        CommonFunctions.attachScreenshot("Billing info");
    }

    public void checkStreetAddress(String expectedAddress) {
        String address = findElement(deliveryStreetAddress).getText();
        assertTrue("Unexpected apt. Expected: " + expectedAddress
                        + "Address: " + address,
                address.contains(expectedAddress));
    }

    public void checkApt(String expectedApt) {
        String address = findElement(deliveryStreetAddress).getText();
        String apt = findElement(deliveryApt).getText();
        assertTrue("Unexpected apt. Expected: " + expectedApt
                        + "Address: " + address
                        + "Apt: " + apt,
                address.contains(expectedApt) || apt.contains(expectedApt));
    }

    public void checkFieldValue(String fieldName, String expectedValue) {
        By field = getFieldByName(fieldName);
        if(isElementPresent(field, 1)) {
            String fieldValue = findElement(field).getText();
            assertEquals(fieldValue, expectedValue, "Unexpected " + fieldName);
        }
    }

    public void checkCityInfo(String expectedCityInfo) {
//        String cityInfo = getDriver().findElement(deliveryCityInfo).getText().split(" ");
        String cityInfo = findElement(deliveryCityInfo).getText();
        assertEquals(cityInfo.split(",")[0], expectedCityInfo, "Unexpected city");
    }

    public void checkZip(String expectedZip) {
//        String cityInfo = getDriver().findElement(deliveryCityInfo).getText().split(" ");
        String cityInfo = findElement(deliveryCityInfo).getText();
        String[] split = cityInfo.split(",")[1].trim().split(" ");
        String zip = split[split.length - 1];
        assertEquals(zip, expectedZip, "Unexpected zip code");
    }

    public void checkPhone(String expectedPhone) {
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

    private By getFieldByName(String fieldName) {
        switch (fieldName) {
            case "Full Name":
                return deliveryName;
            case "Street Address":
                return deliveryStreetAddress;
            case "Apt, Bldg.":
                return deliveryApt;
            // Add handle state popup
//            case "state":
//                break;
            case "Email":
                return deliveryEmail;
            default:
                throw new Error("Unknown field");
        }
    }
}
