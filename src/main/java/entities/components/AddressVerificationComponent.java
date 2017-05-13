package entities.components;

import org.openqa.selenium.By;
import utils.CommonFunctions;

public class AddressVerificationComponent extends BaseComponent {
    public void chooseAddressType(String addressType) {
        By option = By.xpath("//label[@class='radio-list-option' and contains(., '" + addressType + "')]");
        if (isElementVisible(option, 5)) {
            findElement(option).click();
            CommonFunctions.attachScreenshot("Choose address type");
        }
    }
}
