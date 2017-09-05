package entities.components;

import org.openqa.selenium.By;

import static org.testng.Assert.assertTrue;


public class ShippingOptionsComponent extends BaseComponent {
    private RadioListComponent radioListComponent = new RadioListComponent();

    private By shippingOption = By.xpath("//div[contains(@class, 'shipping-option-display')]");

    public void selectShippingMethod(String shippingMethod) {
        setRoot();
        assertTrue(radioListComponent.select(shippingMethod), "'" + shippingMethod + "' doesn't present in list");
    }

    public String getCurrentShippingOptionText() {
        setRoot();
        return radioListComponent.getCurrentItemText();
    }

    public String getShippingOptionDisplayText() {
        assertTrue(isExist(), "Shipping option doesn't present on page.");
        return findElement(shippingOption).getText();
    }

    private void setRoot() {
        radioListComponent.setRoot(null);
        assertTrue(radioListComponent.isExist(), "Delivery Method Drop-Down doesn't isExist");
        radioListComponent.setRoot(getDriver().findElement(By.xpath("//div[contains(@class, 'shipping-options')]")));
    }

    @Override
    public boolean isExist() {
        return isElementVisible(shippingOption);
    }

    @Override
    public boolean isExist(int timeout) {
        return isElementVisible(shippingOption, timeout);
    }
}
