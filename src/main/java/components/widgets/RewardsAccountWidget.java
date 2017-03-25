package components.widgets;


import components.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RewardsAccountWidget extends Component {
    CheckBoxRowWidget checkBoxRowWidget = new CheckBoxRowWidget();

    public void getRewards() {
        checkBoxRowWidget.setCheckBox("Don't have a rewards number?", true);
    }

    public void setRewards(String rewardsCode) {
        WebElement rewardsEl = getDriver().findElement(By.xpath("//div[contains(@class, 'rewards-account-input')]/input"));
        rewardsEl.clear();
        rewardsEl.sendKeys(rewardsCode);
    }
}
