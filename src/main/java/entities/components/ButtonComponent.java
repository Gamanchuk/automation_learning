package entities.components;

import org.openqa.selenium.By;

public class ButtonComponent extends BaseComponent {
    private By btn = By.xpath("//div[contains(@class, 'submit-button')]//button");

    public void clickButton() {
        getDriver().findElements(btn).get(0).click();
    }
//
//    public void focusOnOrderTotal() {
//        getDriver().findElement(By.xpath("//div[contains(@class, 'total-cost')]")).click();
//    }

    public boolean isOverlayDisplayed() {
        return isElementVisible(By.className("spinner-container"), 2);
    }
}
