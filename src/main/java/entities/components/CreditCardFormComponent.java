package entities.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonFunctions;

import static org.testng.Assert.assertTrue;


// TODO: Check if we have some base element like "CreditCardForm"
public class CreditCardFormComponent extends BaseComponent {

    private By ccNumber = By.id("cc-number");
    private By exp = By.id("cc-exp");
    private By csc = By.id("cc-csc");
    private By ccName = By.id("-cc-name");

    public void inputPaymentDetails(String name, String number, String expDate, String cvv, String cardholderName) {
        assertTrue(isElementVisible(ccNumber), "Card number field doesn't present on page.");

        findElement(ccNumber).clear();
        sendKeysOneByOne(ccNumber, number);

        // Need sleep
        CommonFunctions.sleep(800);
        assertTrue(findElement(By.cssSelector("div.credit-card-number-input")).getAttribute("class").contains(name.toLowerCase().replace(" ", "")), "Card icon was not displayed or incorrect");


        if (!name.toLowerCase().equals("qcard")) {
            fillField(exp, expDate);
            CommonFunctions.sleep(1000);
            fillField(csc, cvv);
            CommonFunctions.sleep(1000);
        }

        if (isElementVisible(ccName, 2)) {
            fillField(ccName, cardholderName);
        }

        CommonFunctions.attachScreenshot("Payment details");
    }

    public boolean isCvvExist() {
        return isElementVisible(csc, 3);
    }

    public void inputValueIntoField(String value, String field) {
        By fieldEl = getFieldByName(field);
        focusOut(findElement(fieldEl));
        assertTrue(isElementVisible(fieldEl), "Field is missing. ");
        fillField(fieldEl, value);
    }

    private void fillField(By field, String value) {
        WebElement element = findElement(field);
        focusOut(element);
        element.clear();
        CommonFunctions.sleep(200);
        element.sendKeys(value);
    }

    @Override
    public boolean isExist() {
        return false;
    }

    @Override
    public boolean isExist(int timeout) {
        return false;
    }

    private By getFieldByName(String name) {
        switch (name) {
            case "Card Number":
                return ccNumber;
            case "Expiration":
                return exp;
            case "CVV":
                return csc;
            case "Cardholder Name":
                return ccName;
            default:
                throw new Error("[CreditCardFormComponent] Unknown field name: " + name);
        }
    }
}
