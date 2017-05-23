package entities.pages.pepboys;

import entities.components.BaseComponent;
import org.openqa.selenium.By;
import utils.TestGlobalsManager;

import static org.testng.Assert.assertTrue;

public class PepBoysPaymentAndReviewCheckoutPage extends PepBoysBasePage {
    public void clickTerms() {
        click(By.xpath("//a[text()='Terms']"));
    }

    public void clickArrowFor(String componentName) {
        javascriptScroll(500);
        assertTrue(isElementClickable(By.cssSelector("div.display-well-arrow")), "Arrow for " + componentName + " was not clickable");
        BaseComponent.getComponentByTitle(componentName).findElement(By.cssSelector("div.display-well-arrow")).click();
    }

    public String getInstallationTime() {
        By installationTime = By.cssSelector("span.est-pickup-time-value");
        waitForElementVisible(installationTime);
        return findElement(installationTime).getText();
    }

    public void checkPickUpInStoreInfo() {
        String address = findElement(By.cssSelector("div.review-ship-to-store div.address-recipient")).getText();
        String storeId = (String) TestGlobalsManager.getTestGlobal("storeId");
        assertTrue(address.contains(storeId), "Store info does not contains expected store id. \nExpected: " + storeId + "\nGot: " + address);
    }
}
