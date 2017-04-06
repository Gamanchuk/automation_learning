package entities.components;

import org.openqa.selenium.By;

public class TitleComponent extends BaseComponent {
    private By title = By.xpath("//div[contains(@class, 'title-component')]//div[@class='title-left']/h2");

    public boolean exists() {
        waitForElementVisible(title);
        return true;
    }

    public String getTitleText() {
        return getDriver().findElement(title).getText();
    }
}
