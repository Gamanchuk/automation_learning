package entities.components;


import entities.Entity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CollapserComponent extends BaseComponent {

    public void getRewards() {
        getDriver().findElement(By.xpath("//div[@class='inset']/div[contains(@class, 'checkbox-row')]/input")).click();
    }

    public void openRewards() {
        javascriptScroll(500);
        getDriver().findElement(By.xpath("//a[contains(@class, 'plus-collapser')]/div/div/h2")).click();
        focusOut();
    }

    public void setRewards(String rewardsCode) {
        WebElement rewardsEl = getDriver().findElement(By.xpath("//div[contains(@class, 'rewards-account-input')]/input"));
        rewardsEl.clear();
        rewardsEl.sendKeys(rewardsCode);
    }
}
