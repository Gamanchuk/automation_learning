package entities.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonFunctions;

public class EmailComponent extends BaseComponent {

    // private By emailDisplay = By.cssSelector("div.email-display");
    private By emailDisplayValue = By.cssSelector("span.email-display-value");
    private By emailField = By.cssSelector(".email-input input");

    public void fillEmailField(String email) {
        WebElement emailEl = findElement(emailField);
        scroll(emailEl);
        emailEl.clear();
        CommonFunctions.sleep(500);
        emailEl.sendKeys(email);
        CommonFunctions.sleep(500);
        //focusOut(emailEl);
    }

    public String getEmailDisplayValue() {
        return findElement(emailDisplayValue).getText();
    }

    @Override
    public boolean isExist() {
        return isElementVisible(emailField);
    }

    @Override
    public boolean isExist(int timeout) {
        return isElementVisible(emailField, timeout);
    }

    public By getEmailField() {
        return emailField;
    }
}
