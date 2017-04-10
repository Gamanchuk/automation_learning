package entities.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RewardsAccountComponent extends BaseComponent {

    // TODO: update this method to use CheckBoxComponent
    public void getRewards() {
        findElement(By.xpath("//div[@class='inset']/div[contains(@class, 'checkbox-row')]/input")).click();
    }


    public void setRewards(String rewardsCode) {
        WebElement rewardsEl = findElement(By.cssSelector("div.rewards-account-input input"));
        rewardsEl.clear();
        rewardsEl.sendKeys(rewardsCode);
    }
}
