package components.pages.pepboys;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import utils.CommonFunctions;
import utils.pepboys.BillingUser;
import utils.pepboys.CreditCard;

import static org.testng.AssertJUnit.assertEquals;

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

        // Disable focus from input field. ( Fix problem on iOS)
        getDriver().findElement(By.xpath("//div[@class='address-container well'][2]")).click();

        ((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(0,250)", "");
        getDriver().findElement(continueBtn).click();

        By recommendedAddressRadio = By.xpath("//div[@class='radio-list-option' and contains(., 'Use Recommended Address')]");
        waitForElementVisible(recommendedAddressRadio);
        getDriver().findElement(recommendedAddressRadio).click();
    }

    public void selectShippingMethod(String shippingMethod) {
        waitForElementVisible(By.xpath("//h2[text()='Shipping Address']"));
        By shippingMethodOptionEl = By.xpath("//div[contains(text(), '" + shippingMethod + "')]");

        if(!isElementPresent(shippingMethodOptionEl)){
            click(By.xpath("//div[contains(@class, 'radio-list') and contains(@class, 'radio-collapsed')]"));
            click(shippingMethodOptionEl);
        }

        //TODO: Getting shipping method price to recheck in order
//        String option = getDriver().findElement(shippingMethodOptionEl).getText();
//        float shippingPrice = CommonFunctions.getCurrency(option);
//        TestGlobalsManager.setTestGlobal("shippingPrice", shippingPrice);

        focusOut();
        CommonFunctions.attachScreenshot("Shipping method");
        click(continueBtn);
    }

    public void inputPaymentDetails(CreditCard card) {
        waitForElementVisible(By.id("cc-number"));

        getDriver().findElement(By.id("cc-number")).sendKeys(card.getNumber());
        getDriver().findElement(By.id("cc-exp")).sendKeys(card.getExpDate());
        getDriver().findElement(By.id("cc-csc")).sendKeys(card.getCvv());

        CommonFunctions.attachScreenshot("Payment details");

        getDriver().findElement(By.xpath("//div[contains(@class, 'total-cost')]")).click();
        getDriver().findElement(By.xpath("//div[@class='order-review-container']/div[@class='place-order-button well']/div[@class='component submit-button']/button[@class='main-button']")).click();
    }

    public void checkPaymentResult() {
        By thanksMsg = By.cssSelector("span.thankmsg");
        waitForElementVisible(thanksMsg);
        assertEquals(getDriver().findElement(thanksMsg).getText(), "Thank You for Your Order");
        CommonFunctions.attachScreenshot("Thank You Page");
    }
}
