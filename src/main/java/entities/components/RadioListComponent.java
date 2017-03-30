package entities.components;

import org.openqa.selenium.By;

public class RadioListComponent extends BaseComponent {

    // marck sa old because dosent work
    public void selectOld(String option) {
        String selectedOptionPath = "//div[contains(@class, 'radio-list-option-selected')]";
        if (!isElementPresent(By.xpath(selectedOptionPath + "//div[contains(text(), '" + option + "')]"))) {
            click(By.xpath("//div[contains(@class, 'radio-list') and contains(@class, 'radio-collapsed')]"));
            click(By.xpath("(//div[contains(text(), '" + option + "')])[1]"));
        }
    }


    public void select(String option) {
        String selectedOptionPath = "//div[contains(@class, 'radio-list-option-selected')]";
        // Get default text
        String defaultText = getDriver().findElement(By.xpath(selectedOptionPath + "//div//div")).getText();

        if (!defaultText.equals(option)) {
            // This function dosent work
//            click(By.xpath("//div[contains(@class, 'radio-list') and contains(@class, 'radio-collapsed')]"));
//            click(By.xpath("(//div[contains(text(), '" + option + "')])[1]"));
        }

    }

}
