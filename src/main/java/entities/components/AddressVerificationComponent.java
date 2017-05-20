package entities.components;

import org.openqa.selenium.By;
import utils.CommonFunctions;

import static org.testng.Assert.assertTrue;

public class AddressVerificationComponent extends BaseComponent {
    public void chooseAddressType(String addressType) {
        By option = By.xpath("//label[@class='radio-list-option' and contains(., '" + addressType + "')]");
        assertTrue(isElementVisible(option), "Address verification popup doesn't present");
        CommonFunctions.sleep(1000);

        getDriver().findElement(option).click();
        CommonFunctions.attachScreenshot("Choose address type");
    }
}
