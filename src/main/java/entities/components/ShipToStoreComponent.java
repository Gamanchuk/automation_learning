package entities.components;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonFunctions;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ShipToStoreComponent extends BaseComponent {
    private By storeResult = By.xpath("//div[contains(@class, 'store-result')]");

    public void fillField(String value) {
        WebElement zipForm = getNextComponentByTitle("Find a Store");
        zipForm.findElement(By.cssSelector("input")).sendKeys(value);
    }

    /**
     * Select random element from elements list and click
     */
    public void shipTo() {
        List<WebElement> storesEl = getDriver().findElements(storeResult);

        int itemNumber = ThreadLocalRandom.current().nextInt(0, storesEl.size());
        String storeName = storesEl.get(0).findElement(By.className("store-name")).getText();

        storesEl.get(itemNumber).findElement(By.className("main-button")).click();

        log.info(String.format("Selected \"%s\" for Pick Up in Store.", storeName));
        CommonFunctions.attachScreenshot(storeName);
        CommonFunctions.sleep(2000);
    }

    public boolean isStoreResultPresent() {
        return isElementVisible(storeResult);
    }

    @Override
    public boolean isExist() {
        return isElementVisible(storeResult);
    }

    @Override
    public boolean isExist(int timeout) {
        return isElementVisible(storeResult, timeout);
    }
}
