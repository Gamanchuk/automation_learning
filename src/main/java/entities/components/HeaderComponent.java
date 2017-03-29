package entities.components;

import org.openqa.selenium.By;

public class HeaderComponent extends BaseComponent {
    private final String HEADER_PATH = "//header[contains(@class, 'header')]";

    public void pressSignInButton() {
        waitForElementClickable(By.xpath(HEADER_PATH + "//button[text()='Sign In']"));
        getDriver().findElement(By.xpath(HEADER_PATH + "//button[text()='Sign In']")).click();
        waitForElementClickable(By.xpath("//div[contains(@class,'submit-button')]//button"));
    }

    public void pressLogoLink() {
        getDriver().findElement(By.xpath(HEADER_PATH + "//a[@class='header-logo']")).click();
    }

}
