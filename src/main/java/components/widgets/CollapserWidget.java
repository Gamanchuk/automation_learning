package components.widgets;


import components.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CollapserWidget extends Component {
    private String collapserPath = "//a[contains(@class, 'plus-collapser')]";
    private By openCollapser = By.xpath(collapserPath + "/div/div/h2");

    public void getRewards() {
        getDriver().findElement(By.xpath("//div[@class='inset']/div[contains(@class, 'checkbox-row')]/input")).click();
    }

    public void openRewards() {
        javascriptScroll(500);

        if (getDriver().findElement(By.xpath(collapserPath)).getAttribute("class").contains("collapsed")) {
            getDriver().findElement(openCollapser).click();
        }
    }

    public void setRewards(String rewardsCode) {
        WebElement rewardsEl = getDriver().findElement(By.xpath("//div[contains(@class, 'rewards-account-input')]/input"));
        rewardsEl.clear();
        rewardsEl.sendKeys(rewardsCode);
    }
}
