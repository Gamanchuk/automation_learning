package entities.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RewardsAccountComponent extends BaseComponent {

    private By rewardField = By.cssSelector("div.rewards-account-input input");

    public void setRewards(String rewardsCode) {
        WebElement rewardsEl = findElement(rewardField);
        rewardsEl.clear();
        rewardsEl.sendKeys(rewardsCode);
    }

    @Override
    public boolean isExist() {
        return isElementVisible(rewardField);
    }

    @Override
    public boolean isExist(int timeout) {
        return isElementVisible(rewardField, timeout);
    }
}
