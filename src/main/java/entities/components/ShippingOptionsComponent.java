package entities.components;

import org.openqa.selenium.By;

import static org.testng.AssertJUnit.assertTrue;

public class ShippingOptionsComponent extends BaseComponent {
    private RadioListComponent radioListComponent = new RadioListComponent();

    public void selectShippingMethod(String shippingMethod) {
        waitForElementVisible(By.xpath("//h2[text()='Shipping Method']"));
        radioListComponent.select(shippingMethod);
    }

    public void checkShippingOptions(String expectedOption) {
        javascriptScroll(500);
        String actualOption = getDriver()
                .findElement(By.xpath("//div[@class='shipping-option-display']")).getText();

        assertTrue("Expected option: [" + expectedOption + "]" +
                " doesn't contains Actual option: [" + actualOption + "]", expectedOption.contains(actualOption));

        javascriptScroll(-500);
    }
}
