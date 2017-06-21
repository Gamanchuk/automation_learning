package entities.components;

import org.openqa.selenium.By;

public class ProductListComponent extends BaseComponent {
    private ButtonComponent buttonComponent = new ButtonComponent();

    public void removeProduct() {
        getDriver().findElement(By.xpath("//a[text()='Remove']")).click();
        waitForAjax();
        buttonComponent.clickButton("Yes");
        waitForAjax();
    }
}
