package entities.components;

import entities.Entity;
import org.openqa.selenium.By;

public class HeaderComponent extends BaseComponent {
    private final String HEADER_PATH = "//header[contains(@class, 'header')]";

    public void pressSignInButton() {
        getDriver().findElement(By.xpath(HEADER_PATH + "//button[text()='Sign In']")).click();
    }
}
