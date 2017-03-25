package entities.pages.pepboys;

import entities.Component;
import org.openqa.selenium.By;

public class PepBoysCategoriesPage extends Component {
    public void openCategory(String categoryName) {
        By category = By.xpath("//*[text()='" + categoryName + "']");
        click(category);
    }
}
