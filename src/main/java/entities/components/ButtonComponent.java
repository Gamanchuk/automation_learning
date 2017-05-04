package entities.components;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class ButtonComponent extends BaseComponent {
    private By btn = By.xpath("//div[contains(@class, 'submit-button')]//button");

    public void clickButton() {
        //getDriver().findElements(btn).get(0).click();
        getDriver().findElements(btn).get(0).sendKeys(Keys.RETURN);
    }


    public void clickTotalCost() {
        getDriver().findElement(By.xpath("//div[contains(@class, 'total-cost')]")).click();
    }

    public boolean isOverlayDisplayed() {
        return isElementVisible(By.className("spinner-container"), 2);
    }
}
