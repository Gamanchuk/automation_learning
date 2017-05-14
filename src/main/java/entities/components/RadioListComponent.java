package entities.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonFunctions;

public class RadioListComponent extends BaseComponent {
    private By currentItem = By.cssSelector(".radio-list-option-selected");

    public void select(String option) {
        By currentItemDetails = By.cssSelector(".radio-list-option-selected .radio-list-details");
        String currentItemText = findElement(currentItemDetails).getText();

        log.info("Actual item: " + currentItemText + " Expected item: " + option);

        if (!currentItemText.contains(option)) {
            findElement(currentItem).click();
            CommonFunctions.attachScreenshot("List methods");

            WebElement listEl = findElement(By.cssSelector(".radio-list"));
            String[] tempList = listEl.getText().split("\n");

            int index;

            for (index = 1; index < tempList.length; index++) {
                if (tempList[index].contains(option)) {
                    log.info("Item Selected. ID: " + index);
                    break;
                }
            }

            findElement(By.cssSelector(".radio-list-option:nth-of-type(" + index + ")")).click();
            CommonFunctions.sleep(500);
        }
    }

    public boolean exists() {
        return isElementVisible(currentItem);
    }
}
