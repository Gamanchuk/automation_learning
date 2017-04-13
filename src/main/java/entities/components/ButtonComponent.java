package entities.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ButtonComponent extends BaseComponent {
    private By btn = By.xpath("//div[contains(@class, 'submit-button')]//button");

    public void clickButton() {
        WebElement element = getDriver().findElements(btn).get(0);
        element.click();
    }

    public boolean isOverlayDisplayed() {
        return isElementVisible(By.className("spinner-container"), 2);
    }
}
