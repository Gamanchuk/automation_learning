package components.widgets;

import components.Component;
import org.openqa.selenium.By;

public class CategoriesWidget extends Component {
    public void openCategory(String categoryName) {
        By category = By.xpath("//span[text()='" + categoryName + "']/..");
        waitForElementClickable(category);
        getDriver().findElement(category).click();
    }
}
