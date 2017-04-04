package entities.components;

import org.openqa.selenium.By;
import utils.CommonFunctions;

import static org.testng.AssertJUnit.assertTrue;

public class ShippingOptionsComponent extends BaseComponent {
    private RadioListComponent radioListComponent = new RadioListComponent();

    public void selectShippingMethod(String shippingMethod) {
        waitForElementVisible(By.xpath("//h2[text()='Shipping Method']"));
        radioListComponent.select(shippingMethod);
    }

    public void checkShippingOptions(String expectedOption) {
        javascriptScroll(600);
        String actualOption = getDriver()
                .findElement(By.xpath("//div[contains(@class, 'shipping-option-display')]")).getText();

        assertTrue("Expected option: [" + expectedOption + "]" +
                " doesn't contains Actual option: [" + actualOption + "]", expectedOption.contains(actualOption));

        CommonFunctions.attachScreenshot("Delivery Method");
        javascriptScroll(-600);
    }
}
