package entities.components;

import org.openqa.selenium.By;

public class RewardSummaryComponent extends BaseComponent {

    private By findOut = By.xpath("//a[text()='Find out more']");

    public void clickFindOutMore() {
        findElement(findOut).click();
    }

    public boolean exists() {
        return isElementVisible(findOut);
    }
}
