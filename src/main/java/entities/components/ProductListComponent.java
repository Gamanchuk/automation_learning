package entities.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonFunctions;

import java.util.List;

public class ProductListComponent extends BaseComponent {

    private By removeButton = By.xpath("//a[text()='Remove']");
    private By product = By.xpath("//div[@class='product']");

    private ButtonComponent buttonComponent = new ButtonComponent();

    public void removeProduct() {
        getDriver().findElement(removeButton).click();
        waitForAjax();
        buttonComponent.clickButton("Yes");
        waitForAjax();
    }

    public int getCountProducts() {
        List<WebElement> productsListEl = getDriver().findElements(product);

        for (int i = 0; i < productsListEl.size(); i++) {
            scroll(productsListEl.get(i));
            CommonFunctions.attachScreenshot(String.format("Product #%d", i));
        }

        return productsListEl.size();
    }

    @Override
    public boolean isExist() {
        return isElementVisible(product);
    }

    @Override
    public boolean isExist(int timeout) {
        return isElementVisible(product, timeout);
    }
}