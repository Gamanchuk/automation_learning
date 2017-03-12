package components.pages.pepboys;

import org.openqa.selenium.By;
import utils.CommonFunctions;

public class PepBoysCartPage extends PepBoysBasePage {

    public void payUsingPaymentMethod(String method) {
        if (method.equals("Pay Online")) {
            click(By.id("j-payOnline"));
        } else if (method.equals("PayPal")) {
            click(By.id("j-payPalCheckout"));
        } else if (method.equals("Pay in Store")) {
            click(By.id("j-payInStore"));
        }

        CommonFunctions.attachScreenshot("Payment method");

        if (method.equals("Pay Online")) {
            waitForElementVisible(By.xpath("//button[text()='Continue']"));
            waitForElementClickable(By.xpath("//button[text()='Continue']"));
        }
    }

    public void scheduleInstallationTime() {
        waitForElementVisible(By.xpath("//h4[text()='Schedule Your Installation Time']"));
        waitForElementVisible(By.xpath("(//div[@class='dateHeader'])[5]"));
        getDriver().findElement(By.xpath("(//div[@class='dateHeader'])[5]")).click();

        By availableTime = By.xpath("//div[@data-ur-state='enabled' and @class='dayColumn']//div[contains(@class, 'timeSlotOuter') and not(contains(@class, 'unavailable'))]");
        scrollToElement(getDriver().findElement(availableTime));
        getDriver().findElement(availableTime).click();

        click(By.xpath("//a[text()='Next']"));
    }
}
