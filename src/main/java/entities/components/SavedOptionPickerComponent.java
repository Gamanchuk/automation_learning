package entities.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonFunctions;

import static org.testng.Assert.assertTrue;

public class SavedOptionPickerComponent extends BaseComponent {
    private By savedPicker = By.xpath("//div[contains(@class, 'saved-option-picker')]");

    private RadioListComponent radioListComponent = new RadioListComponent();

    public void select(String payment) {
        radioListComponent.setRoot(null);
        WebElement savedPickerEl = getDriver().findElement(savedPicker);
        assertTrue(isElementVisible(savedPicker), "Radio list with saved data doesn't present");
        radioListComponent.setRoot(savedPickerEl);
        scroll(savedPickerEl);
        radioListComponent.select(payment);
        CommonFunctions.attachScreenshot("Selected");
    }

    public boolean exists() {
        return isElementVisible(savedPicker);
    }
}
