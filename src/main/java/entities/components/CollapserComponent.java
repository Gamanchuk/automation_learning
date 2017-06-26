package entities.components;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonFunctions;

public class CollapserComponent extends BaseComponent {

    // TODO: update this method to use collapser name
    public void openCollapser() {

        WebElement collapser = findElement(By.cssSelector("a.collapser-link"));

        if (collapser.getAttribute("class").contains("collapsed")) {
            scroll(collapser);
            collapser.click();

            // Need sleep for check collapser again
            CommonFunctions.sleep(500);

            collapser = findElement(By.cssSelector("a.collapser-link"));
            if (collapser.getAttribute("class").contains("collapsed")) {
                collapser.click();
            }
            //click(By.cssSelector("a.collapser-link"));
        }
    }

    public String getCollapserLinkText() {
        javascriptScroll(300);
        return findElement(By.cssSelector("div.collapser-link")).getText();

    }
}
