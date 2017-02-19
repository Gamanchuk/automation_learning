package components.pages.pepboys;

import org.openqa.selenium.By;
import org.testng.Assert;
import utils.CommonFunctions;
import utils.TestGlobalsManager;
import utils.pepboys.BillingUser;
import utils.pepboys.CreditCard;
import utils.pepboys.DataProvider;

import static org.testng.AssertJUnit.assertTrue;

public class PepBoysBillingPage extends PepBoysBasePage {
    private By continueBtn = By.xpath("//button[text()='Continue']");

    public void inputBillingInfo(BillingUser user) {
        getDriver().findElement(By.id("billing-name")).sendKeys(user.getName());
        getDriver().findElement(By.id("billing-address-line1")).sendKeys(user.getAddress());

        click(By.xpath("(//div[contains(., '" + user.getCityInfo() + "')]/../input[@name='addresses'])[1]"));

        waitForElementVisible(By.id("billing-address-line2"));
        getDriver().findElement(By.id("billing-address-line2")).sendKeys(user.getAppartment());
        getDriver().findElement(By.id("billing-email")).sendKeys(user.getEmail());

        // Need to send phone number digit by digit
        sendKeysOneByOne(By.id("billing-tel"), user.getPhone());

        CommonFunctions.attachScreenshot("Billing info");
        click(continueBtn);

        By recommendedAddressRadio = By.xpath("//div[@class='radio-list-option' and contains(., 'Use Recommended Address')]");
        waitForElementVisible(recommendedAddressRadio);
        click(recommendedAddressRadio);

        waitForSpinner();
        assertTrue("Incorrect user in order", isElementVisible(By.xpath("//div[@class='address-recipient' and text()='" + user.getName() + "']")));
    }

    public void selectShippingMethod(String shippingMethod) {
        By shippingMethodOptionEl = By.xpath("//div[contains(text(), '" + shippingMethod + "')]");

        click(By.xpath("//div[contains(@class, 'radio-list') and contains(@class, 'radio-collapsed')]"));
        click(shippingMethodOptionEl);

        // Getting shipping method price to recheck in order
        String option = getDriver().findElement(shippingMethodOptionEl).getText();
        float shippingPrice = CommonFunctions.getCurrency(option);
        TestGlobalsManager.setTestGlobal("shippingPrice", shippingPrice);

        CommonFunctions.attachScreenshot("Shipping method");
        click(continueBtn);
    }

    public void inputPaymentDetails(CreditCard card) {
        waitForElementVisible(By.id("cc-number"));

        getDriver().findElement(By.id("cc-number")).sendKeys(card.getNumber());
        getDriver().findElement(By.id("cc-exp")).sendKeys(card.getExpDate());
        getDriver().findElement(By.id("cc-csc")).sendKeys(card.getCvv());

        String orderTotalStr = getDriver().findElement(By.xpath("//div[contains(@class, 'total-cost')]")).getText();
        float orderTotal = CommonFunctions.getCurrency(orderTotalStr);
        float productPrice = (float)TestGlobalsManager.getTestGlobal("totalPrice");
        float shippingPrice = (float)TestGlobalsManager.getTestGlobal("shippingPrice");

        // TODO: ask how order total is calculated
//        assertTrue("Incorrect order total!", productPrice + shippingPrice == orderTotal);
        CommonFunctions.attachScreenshot("Payment details");


//        click(By.xpath("(//button[text()='Place Order'])[1]"));
    }

    private void waitForSpinner() {
        waitForElementVisible(By.className("spinner-container"));
        waitForElementInvisibilityOfElementLocated(By.className("spinner-container"));
    }
}
