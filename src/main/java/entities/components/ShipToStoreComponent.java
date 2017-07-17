package entities.components;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ShipToStoreComponent extends BaseComponent {
    By storeResult = By.xpath("//div[contains(@class, 'store-result')]");

    public void fillField(String value) {
        WebElement zipForm = getNextComponentByTitle("Find a Store");
        zipForm.findElement(By.cssSelector("input")).sendKeys(value);
    }

    public boolean storeResultPresent() {
        return isElementVisible(storeResult);
    }

}
