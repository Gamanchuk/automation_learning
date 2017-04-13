package entities.components;

import org.openqa.selenium.By;

public class ButtonComponent extends BaseComponent {
    private By btn = By.xpath("//button[contains(@class, 'main-button')]");

    public void clickButton() {
        getDriver().findElements(btn).get(0).click();
    }

    public boolean isOverlayDisplayed() {
        return isElementVisible(By.className("spinner-container"), 2);
    }
}
