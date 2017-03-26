package entities.pages.pepboys;

import org.openqa.selenium.By;

public class PepBoysCategoriesPage extends PepBoysBasePage {
    public void openCategory(String categoryName) {
        By category = By.xpath("//*[text()='" + categoryName + "']");
        click(category);
    }
}
