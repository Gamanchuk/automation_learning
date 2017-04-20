package entities.components;


import org.openqa.selenium.By;

public class CollapserComponent extends BaseComponent {

    // TODO: update this method to use collapser name
    public void openCollapser() {

        if (findElement(By.cssSelector("a.collapser-link"))
                .getAttribute("class")
                .contains("collapsed")) {
            javascriptScroll(300);
            click(By.cssSelector("a.collapser-link"));
        }
    }

    public String getCollapserLinkText() {
        javascriptScroll(300);
        return findElement(By.cssSelector("div.collapser-link")).getText();

    }
}
