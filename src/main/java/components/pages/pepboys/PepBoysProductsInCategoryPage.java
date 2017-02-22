package components.pages.pepboys;

import org.openqa.selenium.By;
import utils.TestGlobalsManager;

import java.util.concurrent.TimeUnit;

public class PepBoysProductsInCategoryPage extends PepBoysBasePage {

    // opens first product with matching name
    public void openProductByName(String productName) {
        By product = By.xpath("(//a[text()='" + productName + "'])[1]");
        waitForElementClickable(product);
        click(product);

        // Getting product total price to check it in order
        By totalPriceEl = By.xpath("//span[@class='mw-total-price']//span[@class='ftPrice']");
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        float totalPrice = Float.parseFloat(getDriver().findElement(totalPriceEl).getText());
        TestGlobalsManager.setTestGlobal("totalPrice", totalPrice);
    }

    public void openProductByNameAndSku(String productName) {
        By product = By.xpath("//div[contains(@class, 'mw-j-results-item') and contains(., '8076476')]//a[text()='" + productName + "']");
        waitForElementClickable(product);
        getDriver().findElement(product).click();
    }


}
