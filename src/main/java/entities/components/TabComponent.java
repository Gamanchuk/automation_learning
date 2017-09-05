package entities.components;


import org.openqa.selenium.By;
import utils.CommonFunctions;

public class TabComponent extends BaseComponent {

    private By tab = By.xpath("//div[contains(@class, 'tab')]");

    public void clickOnTab(String tabName) {
        By tabByName = getTabByName(tabName);
        getDriver().findElement(tabByName).click();
    }

    private By getTabByName(String tabName) {
        return By.xpath("//div[contains(@class, 'tab') and text()='" + tabName + "']");
    }

    public boolean isActive(String tabName) {
        boolean status;
        try {
            status = isElementVisible(By.xpath(
                    "//div[contains(@class, 'tab') and contains(@class, 'isActive') and text()='" + tabName + "']"));
        } catch (Exception e) {
            status = isElementVisible(By.xpath(
                    "//div[contains(@class, 'tab') and contains(@class, 'isActive') and text()='" + tabName + "']"));
        }

        CommonFunctions.sleep(1000);
        return status;
    }

    @Override
    public boolean isExist() {
        return isElementVisible(tab);
    }

    @Override
    public boolean isExist(int timeout) {
        return isElementVisible(tab, timeout);
    }

    public boolean isExist(String tabName) {
        return isElementVisible(getTabByName(tabName));
    }

}
