package entities.components;

import org.openqa.selenium.By;

public class RadioListComponent extends BaseComponent {

    public void select(String option) {
        String selectedOptionPath = "//div[contains(@class, 'radio-list-option-selected')]";
        waitForElementVisible(By.xpath(selectedOptionPath));
        if(!isElementPresent(By.xpath(selectedOptionPath + "//div[contains(text(), '" + option + "')]"))) {
            click(By.xpath("//div[contains(@class, 'radio-list') and contains(@class, 'radio-collapsed')]"));
            click(By.xpath("(//div[contains(text(), '" + option + "')])[1]"));
        }
    }
}
