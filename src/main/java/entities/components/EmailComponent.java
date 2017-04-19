package entities.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EmailComponent extends BaseComponent {
    private By emailField = By.id("billing-email");

    public void fillEmailField(String email) {
        WebElement emailEl = findElement(emailField);
        emailEl.clear();
        emailEl.sendKeys(email);
        focusOut(emailEl);
    }
}
