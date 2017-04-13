package entities.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ButtonComponent extends BaseComponent {
    private By btn = By.xpath("//div[contains(@class, 'submit-button')]//button");

    public void clickButton() {
        WebElement element = getDriver().findElements(btn).get(0);
        new Actions(getDriver()).moveToElement(element).perform();
        element.click();
    }
//
//    public void focusOnOrderTotal() {
//        getDriver().findElement(By.xpath("//div[contains(@class, 'total-cost')]")).click();
//    }

    public boolean isOverlayDisplayed() {
        return isElementVisible(By.className("spinner-container"), 2);
    }
}
