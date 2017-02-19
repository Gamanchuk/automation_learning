package components.pages.pepboys;

import org.openqa.selenium.By;

public class PepBoysProductsInCategoryPage extends PepBoysBasePage {

    // opens first product with matching name
    public void openProductByName(String productName) {
        By product = By.xpath("(//a[text()='" + productName + "'])[1]");
        waitForElementClickable(product);
        click(product);
    }

    public void openProductByNameAndSku(String productName) {
        By product = By.xpath("//div[contains(@class, 'mw-j-results-item') and contains(., '8076476')]//a[text()='" + productName + "']");
        waitForElementClickable(product);
        getDriver().findElement(product).click();
    }


}
