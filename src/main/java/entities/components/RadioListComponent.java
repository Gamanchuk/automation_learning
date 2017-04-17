package entities.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonFunctions;

import java.util.List;

public class RadioListComponent extends BaseComponent {
    private By currentItem = By.cssSelector(".radio-list-option-selected div");


    public void select(String option) {
        By selectedItem = By.cssSelector(".radio-list-option-selected>div>div");
        By item = By.cssSelector(".radio-list-details>div");

        String actualItem = findElement(selectedItem)
                .getText();

        if (!actualItem.contains(option)) {
            findElement(currentItem).click();
            CommonFunctions.attachScreenshot("List methods");

            List<WebElement> listWebElement = findElements(item);
            log.info("Size [listWebElement]: " + listWebElement.size());

            for (WebElement element : listWebElement) {
                if (element.getText().contains(option)) {
                    log.info("Method contains: " + element.getText());
                    element.click();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }
    }

    public boolean exists() {
        return isElementVisible(currentItem);
    }
}
