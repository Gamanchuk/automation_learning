package entities.components;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class ButtonComponent extends BaseComponent {
    private By btn = By.xpath("//div[contains(@class, 'submit-button')]//button");

    public void clickButton() {
        //getDriver().findElements(btn).get(0).click();
        getDriver().findElements(btn).get(0).sendKeys(Keys.RETURN);
    }

    public boolean exists() {
        return isElementVisible(btn) && isElementClickable(btn);
    }

}
