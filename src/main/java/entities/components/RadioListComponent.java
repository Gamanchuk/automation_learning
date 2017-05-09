package entities.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonFunctions;

import java.util.List;

public class RadioListComponent extends BaseComponent {
    private By currentItem = By.cssSelector(".radio-list-option-selected");

    public void select(String option) {
        By currentItemDetails = By.cssSelector(".radio-list-option-selected .radio-list-details");

        if (!findElement(currentItemDetails).getText().contains(option)) {
            findElement(currentItem).click();
            CommonFunctions.attachScreenshot("List methods");

            By itemDetails = By.cssSelector(".radio-list-option .radio-list-details");
            List<WebElement> items = findElements(itemDetails);
            log.info("Size [listWebElement]: " + items.size());

            for (WebElement item : items) {
                if (item.getText().contains(option)) {
                    log.info("Method contains: " + item.getText());
                    item.click();
                    CommonFunctions.sleep(100);
                    break;
                }
            }
        }
    }

    public boolean exists() {
        return isElementVisible(currentItem);
    }
}
