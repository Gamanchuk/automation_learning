package entities.components;

import org.openqa.selenium.By;

public class ButtonComponent extends BaseComponent {
    private By btn = By.xpath("//div[contains(@class, 'submit-button')]//button");

    public void clickButton() {
        getDriver().findElement(btn).click();

    }

    public boolean isOverlayDisplayed() {
        return isElementVisible(By.className("spinner-container"), 2);
    }
}
