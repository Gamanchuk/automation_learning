package components.widgets;

import components.Component;
import org.openqa.selenium.By;

public class CategoriesWidget extends Component {
    public void openCategory(String categoryName) {
        By category = By.xpath("//span[text()='" + categoryName + "' and @class='mw_category_title']/..");
        waitForElementClickable(category);
        getDriver().findElement(category).click();
    }
}
