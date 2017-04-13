package entities.components;

import org.openqa.selenium.By;
import utils.CommonFunctions;

public class CreditCardFormComponent extends BaseComponent {

    private By ccNumber = By.id("cc-number");
    private By exp = By.id("cc-exp");
    private By csc = By.id("cc-csc");
    private By ccName = By.id("-cc-name");


    public void inputPaymentDetails(String number, String expDate, String cvv, String cardholderName) {
        waitForElementVisible(ccNumber);

        getDriver().findElement(ccNumber).sendKeys(number);
        getDriver().findElement(exp).sendKeys(expDate);
        getDriver().findElement(csc).sendKeys(cvv);

        //Element must be displayed if you pay as registered user
        if (getDriver().findElement(ccName).isDisplayed()) {
            getDriver().findElement(ccName).clear();
            getDriver().findElement(ccName).sendKeys(cardholderName);
        }
        CommonFunctions.attachScreenshot("Payment details");
    }
}
