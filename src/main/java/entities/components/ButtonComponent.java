package entities.components;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utils.CommonFunctions;

public class ButtonComponent extends BaseComponent {
    private By btn = By.xpath("//div[contains(@class, 'submit-button')]//button");

    public void clickButtonWithSendKeys() {
        //getDriver().findElements(btn).get(0).click();
        CommonFunctions.sleep(500);
        getDriver().findElements(btn).get(0).sendKeys(Keys.RETURN);
    }

    public void clickButton() {
        CommonFunctions.sleep(500);
        getDriver().findElements(btn).get(0).click();
    }

    public void clickButton(String text) {
        By btnWithText = By.xpath("//div[contains(@class, 'submit-button')]//button[contains(text(),'" + text + "')]");
        CommonFunctions.sleep(500);
        getDriver().findElement(btnWithText).sendKeys(Keys.RETURN);
    }

    public boolean exists() {
        return isElementVisible(btn) && isElementClickable(btn);
    }
}
