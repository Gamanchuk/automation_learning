package entities.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonFunctions;

import static org.testng.Assert.assertTrue;


public class ShippingOptionsComponent extends BaseComponent {
    private RadioListComponent radioListComponent = new RadioListComponent();
    private By shippingOption = By.xpath("//div[contains(@class, 'shipping-option-display')]");

    public void selectShippingMethod(String shippingMethod) {
        setRoot();
        assertTrue(radioListComponent.select(shippingMethod), "'" + shippingMethod + "' doesn't present in list");
    }

    public void checkShippingOptions(String expectedOption) {

        assertTrue(isElementVisible(shippingOption), "Shipping option doesn't present on page.");

        WebElement deliveryOptionsEl = getDriver().findElement(shippingOption);
        scroll(deliveryOptionsEl);
        String actualOption = deliveryOptionsEl.getText();

        assertTrue(actualOption.contains(expectedOption), "Expected option: [" + expectedOption + "]" +
                " doesn't contains Actual option: [" + actualOption + "]");

        CommonFunctions.attachScreenshot("Delivery Method");
        javascriptScroll(-600);
    }

    public String getCurrentShippingOptions() {
        setRoot();
        return radioListComponent.getCurrent();
    }

    public String getCurrentShippingOptionDisplay() {
        return findElement(shippingOption).getText();
    }

    private void setRoot() {
        radioListComponent.setRoot(null);
        assertTrue(radioListComponent.exists(), "Delivery Method Drop-Down doesn't exists");
        radioListComponent.setRoot(getDriver().findElement(By.xpath("//div[contains(@class, 'shipping-options')]")));
    }
}
