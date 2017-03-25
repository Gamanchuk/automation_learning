package entities.components;

import entities.Component;
import org.openqa.selenium.By;

public class ButtonComponent extends Component {
    private By btn = By.xpath("//div[contains(@class, 'submit-button')]//button");

    public void clickButton() {
        getDriver().findElements(btn).get(0).click();
    }
}
