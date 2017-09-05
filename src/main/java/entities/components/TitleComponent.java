package entities.components;

import org.openqa.selenium.By;

public class TitleComponent extends BaseComponent {

    private By title = By.cssSelector("h2.title");

    @Override
    public boolean isExist() {
        return isElementVisible(title);
    }

    @Override
    public boolean isExist(int timeout) {
        return isElementVisible(title, timeout);
    }

    public boolean isExist(String titleText) {
        return isElementVisible(getComponentPath(titleText));
    }

    public String getTitleText() {
        return getDriver().findElement(title).getText();
    }

    private By getComponentPath(String titleText) {
        return By.xpath("//div[contains(@class, 'title-component')]" +
                "//div[@class='title-left']//h2[contains(text(), '" + titleText + "')]");
    }
}
