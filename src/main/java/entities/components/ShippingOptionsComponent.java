package entities.components;

import entities.Component;
import org.openqa.selenium.By;

public class ShippingOptionsComponent extends Component {
    private RadioListComponent radioListComponent = new RadioListComponent();

    public void selectShippingMethod(String shippingMethod) {
        waitForElementVisible(By.xpath("//h2[text()='Shipping Method']"));
        radioListComponent.select(shippingMethod);
    }
}
