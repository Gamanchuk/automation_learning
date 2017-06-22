package entities.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonFunctions;
import utils.TestGlobalsManager;

import static org.testng.Assert.assertTrue;

public class CreditCardFormComponent extends BaseComponent {

    private By ccNumber = By.id("cc-number");
    private By exp = By.id("cc-exp");
    private By csc = By.id("cc-csc");
    private By ccName = By.id("-cc-name");

    public void inputPaymentDetails(String name, String number, String expDate, String cvv, String cardholderName) {
        assertTrue(isElementVisible(ccNumber), "Card number field doesn't present on page.");
        fillField(ccNumber, number);
        assertTrue(findElement(By.cssSelector("div.credit-card-number-input")).getAttribute("class").contains(name), "Card icon was not displayed or incorrect");


        if (!name.equals("qcard")) {
            fillField(exp, expDate);
            fillField(csc, cvv);
        }

        // Element must be displayed if you pay as registered user
        Object authorised = TestGlobalsManager.getTestGlobal("authorised");
        if (authorised != null && (boolean) authorised) {
            fillField(ccName, cardholderName);
        }

        focusOut();
        CommonFunctions.attachScreenshot("Payment details");
    }

    public void inputValueIntoField(String value, String field) {
        By fieldEl = getFieldByName(field);
        waitForElementVisible(fieldEl);
        fillField(fieldEl, value);
//        focusOut(findElement(fieldEl));
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
                throw new Error("Unknown field name: " + name);
        }
    }

    private void fillField(By field, String value) {
        WebElement element = findElement(field);
        focusOut(element);
        element.clear();
        element.sendKeys(value);
//        focusOut(element);
    }


    public boolean hasErrorTooltipWithMessage(String error) {
        waitForElementVisible(By.cssSelector("div.tooltip.error"));

        // Have to use complex selector, because label can be either on span or on div
        String selector = "div.tooltip.error div.tooltip-contents span, div.tooltip.error div.tooltip-contents div";
        WebElement messageEl = findElementWithTextBy(error, By.cssSelector(selector));
        return messageEl != null;
    }
}
