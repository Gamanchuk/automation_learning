package entities.components;

import org.openqa.selenium.By;
import utils.CommonFunctions;

import static org.testng.Assert.assertTrue;


public class ShippingOptionsComponent extends BaseComponent {
    private RadioListComponent radioListComponent = new RadioListComponent();

    public void selectShippingMethod(String shippingMethod) {
        assertTrue(isElementVisible(By.xpath("//h2[text()='Delivery Method']")), "Delivery Method tab doesn't opened");
        radioListComponent.setRoot(getDriver().findElement(By.xpath("//div[contains(@class, 'shipping-options')]")));
        assertTrue(radioListComponent.exists(), "Delivery Method Drop-Down doesn't exist");
        assertTrue(radioListComponent.select(shippingMethod), "'" + shippingMethod + "' doesn't present in list");
    }

    public void checkShippingOptions(String expectedOption) {
        javascriptScroll(600);
        By shippingOption = By.xpath("//div[contains(@class, 'shipping-option-display')]");
        assertTrue(isElementVisible(shippingOption), "Shipping option doesn't present on page.");

        String actualOption = getDriver()
                .findElement(shippingOption).getText();

        assertTrue(actualOption.contains(expectedOption), "Expected option: [" + expectedOption + "]" +
                " doesn't contains Actual option: [" + actualOption + "]");

        CommonFunctions.attachScreenshot("Delivery Method");
        javascriptScroll(-600);
    }
}
