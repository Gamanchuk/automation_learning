package entities.components;

import entities.Entity;
import org.openqa.selenium.By;
import utils.CommonFunctions;

public class AddressVerificationComponent extends BaseComponent {
    public void chooseAddressType(String addressType) {
        By option = By.xpath("//div[@class='radio-list-option' and contains(., '" + addressType + "')]");
        if (isElementVisible(option, 5)) {
            getDriver().findElement(option).click();
            CommonFunctions.attachScreenshot("Choose address type");
        }
    }
}
