package entities.components;

import org.openqa.selenium.By;

public class TitleComponent extends BaseComponent {

    public boolean exists(String title) {
        return isElementVisible(By.xpath("//div[contains(@class, 'title-component')]" +
                "//div[@class='title-left']//h2[contains(text(), '" + title + "')]"));
    }
}
