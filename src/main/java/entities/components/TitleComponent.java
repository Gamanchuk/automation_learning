package entities.components;

import org.openqa.selenium.By;

public class TitleComponent extends BaseComponent {

    private By title = By.cssSelector("h2.title");

    public boolean exists(String title) {
        return isElementVisible(By.xpath("//div[contains(@class, 'title-component')]" +
                "//div[@class='title-left']//h2[contains(text(), '" + title + "')]"));
    }

    public String getTitleText() {
        return getDriver().findElement(title).getText();
    }
}
