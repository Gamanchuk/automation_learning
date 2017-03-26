package entities.components;

import entities.Entity;
import org.openqa.selenium.By;

public class ButtonComponent extends BaseComponent {
    private By btn = By.xpath("//div[contains(@class, 'submit-button')]//button");

    public void clickButton() {
        getDriver().findElements(btn).get(0).click();
    }
}
