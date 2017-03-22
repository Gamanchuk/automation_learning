package components.widgets;

import components.Component;
import org.openqa.selenium.By;
import utils.CommonFunctions;

public class AddressVerificationWidget extends Component {
    public void chooseAddressType(String addressType) {
        By option = By.xpath("//div[@class='radio-list-option' and contains(., '" + addressType + "')]");
        if (isElementVisible(option, 5)) {
            getDriver().findElement(option).click();
            CommonFunctions.attachScreenshot("Choose address type");
        }
    }
}
