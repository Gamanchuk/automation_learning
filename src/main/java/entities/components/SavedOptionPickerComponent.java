package entities.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SavedOptionPickerComponent extends BaseComponent {
    private By savedPicker = By.xpath("//div[contains(@class, 'saved-option-picker')]");

    private RadioListComponent radioListComponent = new RadioListComponent();

    public void selectCard(String payment) {
        radioListComponent.setRoot(null);
        WebElement savedPickerEl = getDriver().findElement(savedPicker);
        radioListComponent.setRoot(savedPickerEl);
        scroll(savedPickerEl);
        radioListComponent.select(payment);
    }

    public boolean exists() {
        return isElementVisible(savedPicker);
    }
}
