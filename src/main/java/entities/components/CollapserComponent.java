package entities.components;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CollapserComponent extends BaseComponent {

    // TODO: update this method to use collapser name
    public void openCollapser() {
        javascriptScroll(500);
        if (findElement(By.cssSelector("a.collapser-link"))
                .getAttribute("class")
                .contains("collapsed")) {
            click(By.cssSelector("a.collapser-link"));
//            focusOut();
        }
    }
}
