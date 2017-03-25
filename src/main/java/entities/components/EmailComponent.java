package entities.components;

import entities.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EmailComponent extends Component {
    private By emailField = By.id("billing-email");

    public void fillEmailField(String email) {
        WebElement emailEl = getDriver().findElement(emailField);
        emailEl.clear();
        emailEl.sendKeys(email);
        focusOut();
    }
}
