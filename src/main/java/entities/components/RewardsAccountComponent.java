package entities.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RewardsAccountComponent extends BaseComponent {

    // TODO: update this method to use CheckBoxComponent
    public void choiceDontHaveRewards() {
        findElement(By.xpath("//div[@class='inset']/div[contains(@class, 'checkbox-row')]/input")).click();
    }


    public void setRewards(String rewardsCode) {
        WebElement rewardsEl = findElement(By.cssSelector("div.rewards-account-input input"));
        rewardsEl.clear();
        rewardsEl.sendKeys(rewardsCode);
    }
}


//    @And("^user types rewards number \"([^\"]*)\"$")
//    public void userTypesRewardsCode(String rewardsCode) {
//        rewardsAccountComponent
//        billingPage.openRewards();
//        billingPage.setRewards(rewardsCode);
//        CommonFunctions.attachScreenshot("Rewards Number");
//    }
//
//    @And("^user chooses don't have a reward number$")
//    public void userChoosesDonTHaveARewardNumber() {
//        billingPage.openRewards();
//        billingPage.choiceDontHaveRewards();
//        CommonFunctions.attachScreenshot("Don't have a reward number");
//    }