package entities.components;


import org.openqa.selenium.By;

public class OrderSummaryComponent extends BaseComponent {
    private By orderSummary = By.cssSelector("div.order-summary");

    @Override
    public boolean isExist() {
        return isElementVisible(orderSummary);
    }

    @Override
    public boolean isExist(int timeout) {
        return isElementVisible(orderSummary, timeout);
    }
}
