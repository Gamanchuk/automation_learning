package entities.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonFunctions;

public class CreditCardFormComponent extends BaseComponent {

    private By ccNumber = By.id("cc-number");
    private By exp = By.id("cc-exp");
    private By csc = By.id("cc-csc");
    private By ccName = By.id("-cc-name");

    public void inputPaymentDetails(String number, String expDate, String cvv, String cardholderName) {
        waitForElementVisible(ccNumber);

        WebElement cardNumberEl = getDriver().findElement(ccNumber);
        cardNumberEl.sendKeys(number);


        getDriver().findElement(exp).sendKeys(expDate);
        getDriver().findElement(csc).sendKeys(cvv);

        //Element must be displayed if you pay as registered user
        if (getDriver().findElement(ccName).isDisplayed()) {
            getDriver().findElement(ccName).clear();
            getDriver().findElement(ccName).sendKeys(cardholderName);
        }

        cardNumberEl.click();

        CommonFunctions.attachScreenshot("Payment details");
    }
}
