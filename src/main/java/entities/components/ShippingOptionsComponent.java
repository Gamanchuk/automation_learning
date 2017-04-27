package entities.components;

import org.openqa.selenium.By;
import utils.CommonFunctions;

import static org.testng.Assert.assertTrue;


public class ShippingOptionsComponent extends BaseComponent {
    private RadioListComponent radioListComponent = new RadioListComponent();

    public void selectShippingMethod(String shippingMethod) {
        waitForElementVisible(By.xpath("//h2[text()='Shipping Address']"));
        assertTrue(radioListComponent.exists(), "Shipping Method Drop-Down doesn't exist");
        radioListComponent.select(shippingMethod);
    }

    public void checkShippingOptions(String expectedOption) {
        javascriptScroll(600);
        String actualOption = getDriver()
                .findElement(By.xpath("//div[contains(@class, 'shipping-option-display')]")).getText();

        assertTrue(actualOption.contains(expectedOption), "Expected option: [" + expectedOption + "]" +
                " doesn't contains Actual option: [" + actualOption + "]");

        CommonFunctions.attachScreenshot("Delivery Method");
        javascriptScroll(-600);
    }
}
