package components.widgets;


import components.Component;
import org.openqa.selenium.By;

public class CollapserWidget extends Component {
    private By collapserLink = By.cssSelector("a.collapser-link");

    public void openCollapser() {
        javascriptScroll(500);

        if (getDriver().findElement(collapserLink).getAttribute("class").contains("collapsed")) {
            getDriver().findElement(collapserLink).click();
        }
    }
}
