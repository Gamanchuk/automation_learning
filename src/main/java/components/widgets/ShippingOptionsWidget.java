package components.widgets;

import components.Component;
import org.openqa.selenium.By;

public class ShippingOptionsWidget extends Component {
    private RadioListWidget radioListWidget = new RadioListWidget();

    public void selectShippingMethod(String shippingMethod) {
        waitForElementVisible(By.xpath("//h2[text()='Shipping Method']"));
        radioListWidget.select(shippingMethod);
    }
}
