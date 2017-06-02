package entities.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckboxRowComponent extends BaseComponent {

    public void check(String label, boolean shouldBeChecked) {
        WebElement checkBox = findElement(By.xpath("//label[contains(@class, 'checkbox-row') and contains(., '" + label + "')]//input"));
        javascriptScroll(checkBox);

        // Logic of this checkbox is inverted
        // TODO: update condition after checkbox update
        if (checkBox.getAttribute("data-analytics-name").contains("_uncheck") != shouldBeChecked) {
            checkBox.click();
        }
    }
}
