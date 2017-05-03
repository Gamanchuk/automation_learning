package entities.components;

import org.openqa.selenium.By;
import utils.CommonFunctions;

public class AddressVerificationComponent extends BaseComponent {
    public void chooseAddressType(String addressType) {
        By option = By.xpath("//div[@class='radio-list-option' and contains(., '" + addressType + "')]");
        if (isElementVisible(option, 5)) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            getDriver().findElement(option).click();
            CommonFunctions.attachScreenshot("Choose address type");
        }
    }
}
