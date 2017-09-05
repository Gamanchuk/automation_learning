package entities.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonFunctions;

public class CheckboxRowComponent extends BaseComponent {

    private By checkbox = By.xpath("//label[contains(@class, 'checkbox-row')]");

    public void check(String title, boolean shouldBeChecked) {
        focusOut();
        WebElement checkBox = findElement(By.xpath(getCheckBoxXpath(title)));
        // Logic of this checkbox is inverted

        // TODO: update condition after checkbox update
        if (checkBox.getAttribute("data-analytics-name").contains("_uncheck") != shouldBeChecked) {
            checkBox.click();
        }

        CommonFunctions.sleep(1000);
    }

    public boolean isExist(String title, int timeout) {
        return isElementVisible(By.xpath(getCheckBoxXpath(title)), timeout);
    }

    @Override
    public boolean isExist() {
        return isElementVisible(checkbox);
    }

    @Override
    public boolean isExist(int timeout) {
        return isElementVisible(checkbox, timeout);
    }

    private String getCheckBoxXpath(String title) {
        return "//label[contains(@class, 'checkbox-row') and contains(.,'" + title + "')]//input";
    }
}


