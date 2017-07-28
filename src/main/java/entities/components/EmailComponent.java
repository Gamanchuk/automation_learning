package entities.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonFunctions;

public class EmailComponent extends BaseComponent {
    //    private By emailField = By.id("billing-email");
    private By emailField = By.xpath("//input[@id='billing-email' or @id='shipping-email']");
    private By emailDisplay = By.cssSelector("div.email-display");
    private By emailDisplayValue = By.cssSelector("span.email-display-value");

    public void fillEmailField(String email) {
        WebElement emailEl = findElement(emailField);
        scroll(emailEl);
        emailEl.clear();
        CommonFunctions.sleep(500);
        emailEl.sendKeys(email);
        focusOut(emailEl);

//        CommonFunctions.sleep(1000);
//        findElement(emailField).clear();
//        findElement(emailField).sendKeys(email);
    }

    public String getEmailDisplayValue() {
        return findElement(emailDisplayValue).getText();
    }
}
