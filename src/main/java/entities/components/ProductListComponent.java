package entities.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonFunctions;

import java.util.List;

public class ProductListComponent extends BaseComponent {
    private ButtonComponent buttonComponent = new ButtonComponent();

    public void removeProduct() {
        getDriver().findElement(By.xpath("//a[text()='Remove']")).click();
        waitForAjax();
        buttonComponent.clickButton("Yes");
        waitForAjax();
    }

    public int getCountProducts() {
        List<WebElement> productsListEl = getDriver().findElements(By.xpath("//div[@class='product']"));

        for (int i = 0; i < productsListEl.size(); i++) {
            scroll(productsListEl.get(i));
            CommonFunctions.attachScreenshot(String.format("Product #%d", i));
        }

        return productsListEl.size();
    }
}
