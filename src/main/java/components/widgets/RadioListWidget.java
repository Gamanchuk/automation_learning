package components.widgets;

import components.Component;
import org.openqa.selenium.By;

public class RadioListWidget extends Component {

    public void select(String arg) {
        By optionEl = By.xpath("//div[contains(text(), '" + arg + "')]");
        if (!isElementPresent(optionEl)) {
            click(By.xpath("//div[contains(@class, 'radio-list') and contains(@class, 'radio-collapsed')]"));
            click(optionEl);
        }
    }
}
