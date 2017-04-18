package entities.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonFunctions;

import java.util.List;

public class RadioListComponent extends BaseComponent {
    private String selectedOptionPath = "//div[contains(@class, 'radio-list-option-selected')]";

    public void select(String option) {

        String itemPath = "//div[contains(@class, 'radio-list-option')]";
        String itemDetailsPath = "//div[contains(@class, 'radio-list-details')]";
        String itemListPath = "//div[contains(@class, 'radio-expanded')]";


        String actualItem = findElement(By.xpath(selectedOptionPath + itemDetailsPath + "//div")).getText();

        if (!actualItem.contains(option)) {
            click(By.xpath(selectedOptionPath));
            CommonFunctions.attachScreenshot("List methods");

            List<WebElement> listWebElement = getDriver().findElements(By.xpath(itemListPath + itemPath + itemDetailsPath));

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
        return isElementVisible(By.xpath(selectedOptionPath));
    }
}
