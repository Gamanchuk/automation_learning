package entities.pages.pepboys;

import entities.pages.BasePage;
import org.openqa.selenium.By;

public class PepBoysCategoriesPage extends BasePage {
    public void openCategory(String categoryName) {
        By category = By.xpath("//*[text()='" + categoryName + "']");
        click(category);
    }
}
