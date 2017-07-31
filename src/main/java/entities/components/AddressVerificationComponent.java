package entities.components;

import org.openqa.selenium.By;
import utils.CommonFunctions;

import static org.testng.Assert.assertTrue;

public class AddressVerificationComponent extends BaseComponent {

    By addressVerification = By.xpath("//div[contains(@class, 'address-verification')]");


    public void chooseAddressType(String addressType) {
        By option = getComponent(addressType);

        assertTrue(isElementVisible(option), "Address verification popup doesn't present");
        CommonFunctions.sleep(1000);

        getDriver().findElement(option).click();


        CommonFunctions.attachScreenshot("Choose address type");
        CommonFunctions.sleep(2000);
    }

    public boolean exists() {
        return isElementVisible(addressVerification);
    }

    public boolean exists(int timeout) {
        return isElementVisible(addressVerification, timeout);
    }

    private By getComponent(String addressType) {
        return By.xpath("//label[@class='radio-list-option' and contains(., '" + addressType + "')]");
    }


}
