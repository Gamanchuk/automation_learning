package entities.components;

import org.openqa.selenium.By;
import utils.CommonFunctions;

public class BreadcrumbComponent extends BaseComponent {

    public boolean isTabActive(String tabName) {
        return findElement(getBreadcrumbByName(tabName)).getAttribute("class").contains("active");
    }

    public boolean isTabDisabled(String tabName) {
        return findElement(getBreadcrumbByName(tabName)).getAttribute("class").contains("disabled");
    }

    private By getBreadcrumbByName(String name) {
        return By.xpath("//a[contains(@class, 'breadcrumb') and text()='" + name + "']");
    }

    public void clickBreadcrumb(String breadcrumb) {
        By breadcrumbPath = getBreadcrumbByName(breadcrumb);
        getDriver().findElement(breadcrumbPath).click();
    }

    public void waitForBreadcrumbActive(String breadcrumbName) {
//        getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
//        waitForAjax();
        By breadcrumb = By.xpath(
                "//a[contains(@class, 'breadcrumb') and contains(@class, 'active') and text()='" + breadcrumbName + "']");

        waitForElementPresence(breadcrumb);
    }

    public boolean isBreadcrumbActive(String breadcrumb) {

        if (isElementVisible(getBreadcrumbByName(breadcrumb))) {
            scroll(getDriver().findElement(getBreadcrumbByName(breadcrumb)));
        }

        waitForAjax();

        return isElementVisible(By.xpath(
                "//a[contains(@class, 'breadcrumb') and contains(@class, 'active') and text()='" + breadcrumb + "']"));
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
        CommonFunctions.sleep(2000);
        return status;
    }

    public void witFor() {
        waitForAjax();
    }

    public String getActiveTab() {
        return findElement(By.cssSelector("a.breadcrumb.active")).getText();
    }
}
