package entities.components;

import org.openqa.selenium.By;

public class ButtonComponent extends BaseComponent {


    public void clickButton() {
        getDriver().findElements(By.xpath("//div[contains(@class, 'submit-button')]//button")).get(0).click();
    }

}
