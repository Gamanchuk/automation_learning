package entities.pages;

import entities.components.BaseComponent;
import entities.components.TitleComponent;
import org.openqa.selenium.By;
import utils.TestGlobalsManager;

import static org.testng.Assert.assertTrue;

public class PaymentAndReviewCheckoutPage extends BasePage {
    private TitleComponent titleComponent = new TitleComponent();

    public void clickTerms() {
        click(By.xpath("//a[text()='Terms']"));
    }

    public void clickArrowFor(String componentName) {
        javascriptScroll(500);
        assertTrue(titleComponent.isExist(componentName), String.format("Looks like \"%s\" arrow doesn't present on page.", componentName));
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

    @Override
    public boolean isPage() {
        return false;
    }
}
