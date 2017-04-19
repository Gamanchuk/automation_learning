package entities.components;

import org.openqa.selenium.By;

public class RewardSummaryComponent extends BaseComponent {
    public void clickFindOutMore() {
        findElement(By.xpath("//a[text()='Find out more']")).click();
    }
}
