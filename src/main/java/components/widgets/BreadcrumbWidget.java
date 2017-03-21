package components.widgets;

import components.Component;
import org.openqa.selenium.By;

public class BreadcrumbWidget extends Component {

    public boolean isTabActive(String tabName) {
        return getDriver().findElement(getBreadcrumbByName(tabName)).getAttribute("class").contains("active");
    }

    public boolean isTabDisabled(String tabName) {
        return getDriver().findElement(getBreadcrumbByName(tabName)).getAttribute("class").contains("disabled");
    }

    private By getBreadcrumbByName(String name) {
        return By.xpath("//a[contains(@class, 'breadcrumb') and text()='" + name + "']");
    }
}
