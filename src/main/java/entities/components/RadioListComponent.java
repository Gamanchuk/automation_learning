package entities.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonFunctions;

import java.util.List;

public class RadioListComponent extends BaseComponent {

    public void select(String option) {
        String selectedOptionPath = "//div[contains(@class, 'radio-list-option-selected')]";
        String itemPath = "//div[contains(@class, 'radio-list-option')]";
        String itemDetailsPath = "//div[contains(@class, 'radio-list-details')]";
        String itemListPath = "//div[contains(@class, 'radio-expanded')]";
        waitForElementVisible(By.xpath(selectedOptionPath));

        String actualItem = getDriver()
                .findElement(By.xpath(selectedOptionPath + itemDetailsPath + "//div"))
                .getText();

        if (!actualItem.contains(option)) {
            getDriver().findElement(By.xpath(selectedOptionPath)).click();
            CommonFunctions.attachScreenshot("List methods");

            List<WebElement> listWebElement = getDriver()
                    .findElements(By.xpath(itemListPath + itemPath + itemDetailsPath + "//div"));

            for (WebElement element : listWebElement) {
                if (element.getText().contains(option)) {
                    log.info("Method contains: " + element.getText());
                    element.click();
                    break;
                }
            }
        }
    }
}
