package entities.components;

import org.openqa.selenium.By;

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
        findElement(breadcrumbPath).click();
    }

    public void waitForBreadcrumbActive(String breadcrumb) {
        waitForElementVisible(By.xpath(
                "//a[contains(@class, 'breadcrumb') and contains(@class, 'active') and text()='" + breadcrumb + "']"));
    }

    public boolean isBreadcrumbActive(String breadcrumb) {
        return isElementVisible(By.xpath(
                "//a[contains(@class, 'breadcrumb') and contains(@class, 'active') and text()='" + breadcrumb + "']"));
    }

    public String getActiveTab() {
        return findElement(By.cssSelector("a.breadcrumb.active")).getText();
    }
}
