package entities.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RewardsAccountComponent extends BaseComponent {

    public void setRewards(String rewardsCode) {
        WebElement rewardsEl = findElement(By.cssSelector("div.rewards-account-input input"));
        rewardsEl.clear();
        rewardsEl.sendKeys(rewardsCode);
    }
}
