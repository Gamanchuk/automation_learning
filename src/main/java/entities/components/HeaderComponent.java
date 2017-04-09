package entities.components;

import org.openqa.selenium.By;

public class HeaderComponent extends BaseComponent {
    private final String HEADER_PATH = "//header[contains(@class, 'header')]";

    public void pressSignInButton() {
        waitForElementClickable(By.xpath(HEADER_PATH + "//button[text()='Sign In']"));
        getDriver().findElement(By.xpath(HEADER_PATH + "//button[text()='Sign In']")).click();
    }

    public void pressLogoLink() {
        getDriver().findElement(By.xpath(HEADER_PATH + "//a[@class='header-logo']")).click();
    }

    public void pressShippingCartIcon() {
        getDriver().findElement(By.xpath(HEADER_PATH + "//div[@class='cart-icon']/a")).click();

    }
}
