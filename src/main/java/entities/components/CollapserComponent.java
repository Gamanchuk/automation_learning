package entities.components;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CollapserComponent extends BaseComponent {

    // TODO: update this method to use collapser name
    public void openCollapser() {

        WebElement collapser = findElements(By.cssSelector("a.collapser-link")).get(0);

        if (collapser.getAttribute("class").contains("collapsed")) {
            javascriptScroll(collapser);
            collapser.click();
            //click(By.cssSelector("a.collapser-link"));
        }
    }

    public String getCollapserLinkText() {
        javascriptScroll(300);
        return findElement(By.cssSelector("div.collapser-link")).getText();

    }
}
