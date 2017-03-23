package components.widgets;

import components.Component;
import org.openqa.selenium.By;
import utils.CommonFunctions;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class AddressDisplayWidget extends Component {
    private By deliveryApt = By.xpath("//div[@class='address-line2']");
    private By deliveryName = By.xpath("//div[@class='address-recipient']");
    private By deliveryStreetAddress = By.xpath("//div[@class='address-line1']");
    private By deliveryCityInfo = By.xpath("//div[@class='address-city-state-zip']");
    private By deliveryPhone = By.xpath("//a[@class='phone-display address-phone']");
    private By deliveryEmail = By.xpath("//div[@class='address-email']");

    public void checkBillingInfo(String name, String apt, String streetAddress, String cityInfo, String zip, String phone, String email) {
        waitForElementClickable(By.xpath("//div[contains(@class, 'radio-list') and contains(@class, 'radio-collapsed')]"));
        getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        checkFieldValue("Full Name", name);
        checkFieldValue("Street Address", streetAddress);
        checkFieldValue("Apt, Bldg.", apt);
        checkFieldValue("Email", email);

        checkCityInfo(cityInfo);
        checkPhone(phone);
        checkZip(zip);

        CommonFunctions.attachScreenshot("Billing info");
    }

    public void checkFieldValue(String fieldName, String expectedValue) {
        By field = getFieldByName(fieldName);
        String fieldValue = getDriver().findElement(field).getText();
        assertEquals(fieldValue, expectedValue, "Unexpected " + fieldName);
    }

    public void checkCityInfo(String expectedCityInfo) {
//        String cityInfo = getDriver().findElement(deliveryCityInfo).getText().split(" ");
        String cityInfo = getDriver().findElement(deliveryCityInfo).getText();
        assertEquals(cityInfo.split(",")[0], expectedCityInfo, "Unexpected city");
    }

    public void checkZip(String expectedZip) {
//        String cityInfo = getDriver().findElement(deliveryCityInfo).getText().split(" ");
        String cityInfo = getDriver().findElement(deliveryCityInfo).getText();
        String[] split = cityInfo.split(",")[1].trim().split(" ");
        String zip = split[split.length - 1];
        assertEquals(zip, expectedZip, "Unexpected zip code");
    }

    public void checkPhone(String expectedPhone) {
        String phone = getDriver().findElement(deliveryPhone).getText();
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
