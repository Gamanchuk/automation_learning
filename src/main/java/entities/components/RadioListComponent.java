package entities.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonFunctions;

import static org.testng.Assert.fail;

public class RadioListComponent extends BaseComponent {
    private By currentItem = By.cssSelector(".radio-list-option-selected");
    private By currentItemDetails = By.cssSelector(".radio-list-option-selected .radio-list-details");

    public boolean select(String option) {

        String currentItemText = getCurrentItemText();

        log.info("Actual item: " + currentItemText + ". Expected item: " + option);

        if (!currentItemText.contains(option)) {
            findElement(currentItem).click();
            CommonFunctions.attachScreenshot("List methods");

            WebElement listEl = findElement(By.cssSelector(".radio-list"));
            String[] tempList = listEl.getText().split("\n");

            for (int i = 0; i < tempList.length; i++) {
                if (tempList[i].toLowerCase().contains(option.toLowerCase())) {
                    log.info("Item Selected. ID: " + i);
                    findElement(By.cssSelector(".radio-list-option:nth-of-type(" + (i + 1) + ")")).click();
                    CommonFunctions.sleep(1000);
                    return true;
                }
            }

        } else if (currentItemText.contains(option)) {
            log.info("Item selected by default: " + option);
            return true;
        }

        fail("Item " + option + " (credit card / street) doesn't present on page.");

        return false;
    }

    public String getCurrentItemText() {
        return findElement(currentItemDetails).getText();
    }

    @Override
    public boolean isExist() {
        return isElementVisible(currentItem) || isElementPresent(currentItem);
    }

    @Override
    public boolean isExist(int timeout) {
        return isElementVisible(currentItem, timeout) || isElementPresent(currentItem, timeout);
    }
}
