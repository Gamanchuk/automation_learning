package entities.components;

import org.openqa.selenium.By;
import utils.CommonFunctions;

public class BreadcrumbComponent extends BaseComponent {

    private By breadcrumb = By.cssSelector("a.breadcrumb");

    public void clickBreadcrumb(String breadcrumb) {
        By breadcrumbPath = getBreadcrumbByName(breadcrumb);
        getDriver().findElement(breadcrumbPath).click();
    }

    public boolean active(String tabName) {
        boolean status;
        try {
            status = isElementVisible(By.xpath(
                    "//a[contains(@class, 'breadcrumb') and contains(@class, 'active') and text()='" + tabName + "']"));
        } catch (Exception e) {
            status = isElementVisible(By.xpath(
                    "//a[contains(@class, 'breadcrumb') and contains(@class, 'active') and text()='" + tabName + "']"));
        }
        CommonFunctions.sleep(4000);
        return status;
    }

    public boolean isTabActive(String tabName) {
        return findElement(getBreadcrumbByName(tabName)).getAttribute("class").contains("active");
    }

    public boolean isTabDisabled(String tabName) {
        return findElement(getBreadcrumbByName(tabName)).getAttribute("class").contains("disabled");
    }

    public boolean isBreadcrumbActive(String breadcrumb) {

        if (isElementVisible(getBreadcrumbByName(breadcrumb))) {
            scroll(getDriver().findElement(getBreadcrumbByName(breadcrumb)));
        }

        waitForAjax();

        return isElementPresent(By.xpath(
                "//a[contains(@class, 'breadcrumb') and contains(@class, 'active') and text()='" + breadcrumb + "']"));
    }

    public String getActiveTab() {
        return findElement(By.cssSelector("a.breadcrumb.active")).getText();
    }

    @Override
    public boolean isExist() {
        return isElementVisible(breadcrumb);
    }

    @Override
    public boolean isExist(int timeout) {
        return isElementVisible(breadcrumb, timeout);
    }

    private By getBreadcrumbByName(String name) {
        return By.xpath("//a[contains(@class, 'breadcrumb') and text()='" + name + "']");
    }
}
