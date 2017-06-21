package entities.components;

import org.openqa.selenium.By;

public class NoteComponent extends BaseComponent {
    public void clickLink(String text) {
        getDriver().findElement(By.xpath("//a[text()='" + text + "']")).click();
    }
}