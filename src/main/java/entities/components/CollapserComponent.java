package entities.components;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonFunctions;

public class CollapserComponent extends BaseComponent {

    private By collapserLink = By.cssSelector("a.collapser-link");

    // TODO: update this method to use collapser name
    public void openCollapser() {

        WebElement collapser = findElement(collapserLink);
        scrollToElement(collapser);

        if (collapser.getAttribute("class").contains("collapsed")) {
            scroll(collapser);
            collapser.click();

            // Need sleep for check collapser again
            CommonFunctions.sleep(500);

            collapser = findElement(collapserLink);
            if (collapser.getAttribute("class").contains("collapsed")) {
                collapser.click();
            }
        }
    }

    public String getCollapserLinkText() {
        javascriptScroll(300);
        return findElement(collapserLink).getText();
    }

    @Override
    public boolean isExist() {
        return isElementVisible(collapserLink);
    }

    @Override
    public boolean isExist(int timeout) {
        return isElementVisible(collapserLink, timeout);
    }
}
