package entities.components;


import org.openqa.selenium.By;

public class OrderSummaryComponent extends BaseComponent {
    public boolean isVisible() {
        return isElementVisible(By.cssSelector("div.order-summary"));
    }
}
