package components.pages.pepboys;

import org.openqa.selenium.By;
import org.testng.Assert;

import static org.testng.AssertJUnit.assertTrue;

public class PepBoysBillingPage extends PepBoysBasePage {
    private By continueBtn = By.xpath("//button[text()='Continue']");

    public void inputBillingInfo() {
        // TODO: move info to configs or smth
        getDriver().findElement(By.id("billing-name")).sendKeys("qa moovweb");
        getDriver().findElement(By.id("billing-address-line1")).sendKeys("123 mission street");

        click(By.xpath("(//div[contains(., 'San Francisco CA 94105')]/../input[@name='addresses'])[1]"));

        By appartmentInput = By.id("billing-address-line2");
        waitForElementVisible(appartmentInput);
        getDriver().findElement(appartmentInput).sendKeys("10th floor");

//        getDriver().findElement(By.id("billing-address-line1")).sendKeys("123 mission street 10th floor San Francisco CA 94105");
        getDriver().findElement(By.id("billing-tel")).sendKeys("4152011234");
        getDriver().findElement(By.id("billing-email")).sendKeys("qa@moovweb.com");
        click(continueBtn);

        waitForElementVisible(By.xpath("//div[@class='radio-list-option' and contains(., 'Use Recommended Address')]"));
        if (isElementVisible(By.xpath("//div[@class='radio-list-option' and contains(., 'Use Recommended Address')]"))) {
            click(By.xpath("//div[@class='radio-list-option' and contains(., 'Use Recommended Address')]"));
        }
//        click(continueBtn);
        waitForElementInvisibilityOfElementLocated(By.className("spinner-container"));
        assertTrue(isElementVisible(By.xpath("//div[@class='address-recipient' and text()='qa moovweb']")));
        // TODO: add checks for shipping address
    }

    public void selectShippingMethod() {
//        click(By.xpath("//div[contains(@class, 'radio-list') and contains(@class, 'radio-collapsed')]"));
//        click(By.xpath("//div[contains(., 'Ground')]/../input"));
        //waitForElementVisible(By.xpath("//div[contains(@class, 'radio-list') and contains(@class, 'radio-collapsed')]"));

        waitForElementInvisibilityOfElementLocated(By.className("spinner-container"));
        click(continueBtn);
    }

    public void inputPaymentDetails() {
        // TODO: Define card details in separate vault
        waitForElementVisible(By.id("cc-number"));

        getDriver().findElement(By.id("cc-number")).sendKeys("4111111111111111");
        getDriver().findElement(By.id("cc-exp")).sendKeys("1217");
        getDriver().findElement(By.id("cc-csc")).sendKeys("111");

        click(By.xpath("(//button[text()='Place Order'])[1]"));
        Assert.assertTrue(false,"Thanks page not found");
    }
}
