package entities.components;


import org.openqa.selenium.By;
import utils.CommonFunctions;

public class TabComponent extends BaseComponent {

    public void clickTab(String tabName) {
        By tabByName = getTabByName(tabName);
        getDriver().findElement(tabByName).click();
    }

    public boolean active(String tabName) {
        boolean status;
        try {
            status = isElementVisible(By.xpath(
                    "//div[contains(@class, 'tab') and contains(@class, 'active') and text()='" + tabName + "']"));
        } catch (Exception e) {
            status = isElementVisible(By.xpath(
                    "//div[contains(@class, 'tab') and contains(@class, 'active') and text()='" + tabName + "']"));
        }

        CommonFunctions.sleep(1000);
        return status;
    }

    private By getTabByName(String tabName) {
        return By.xpath("//div[contains(@class, 'tab') and text()='" + tabName + "']");
    }
}
