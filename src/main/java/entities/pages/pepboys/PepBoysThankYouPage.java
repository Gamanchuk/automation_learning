package entities.pages.pepboys;

import org.openqa.selenium.By;
import utils.CommonFunctions;

import static org.testng.AssertJUnit.assertTrue;

public class PepBoysThankYouPage extends PepBoysBasePage {
    public boolean isOnThankYouPage() {
        return isElementPresent(By.xpath("//span[@class='thankmsg' and text()='Thank You for Your Order']"));
    }

    private By collapser = By.xpath("//a[contains(@class, 'arrow-collapser')]");

    public boolean isExpanded() {
        return getDriver().findElement(collapser).getAttribute("class").contains("expanded");
    }

    public boolean isCollapsed() {
        return getDriver().findElement(collapser).getAttribute("class").contains("collapsed");
    }

    public void openCollapser() {
        if (isCollapsed()) {
            getDriver().findElement(collapser).click();
        }
    }

    public String getOrder() {
        return getDriver().findElement(collapser).getText().split("#")[1];
    }

    public void checkPaymentResult() {
        By thanksMsg = By.xpath("//div[contains(@class, 'order-thank-you')]/div");
        waitForElementVisible(thanksMsg, 100);

        String message = getDriver().findElement(thanksMsg).getText().toLowerCase();
        assertTrue(message.contains("thank you for your order"));

        CommonFunctions.attachScreenshot("Thank You Page");
    }

    public void clickOnReschedule() {
        getDriver().findElement(By.xpath("//a[contains(@class, 'edit-installation-link')]")).click();
    }
}
