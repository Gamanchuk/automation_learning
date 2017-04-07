package entities.components;

import org.openqa.selenium.By;

public class RewardSummaryComponent extends BaseComponent {

    //  private final String rewardSummaryPath = "//div[contains(@class, 'reward-summary')]";


    public void clickFindOutMore() {
        findElement(By.xpath("//a[text()='Find out more']")).click();
    }


}
