package entities.components;

import org.openqa.selenium.By;

import static org.testng.Assert.assertTrue;

public class HeaderComponent extends BaseComponent {
    private final String HEADER_PATH = "//header[contains(@class, 'header')]";

    public void pressSignInButton() {
        assertTrue(signinExists(), "Looks like 'Sign In' button doesn't present.");
        getDriver().findElement(By.xpath(HEADER_PATH + "//button[text()='Sign In']")).click();
    }

    public void pressLogoLink() {
        getDriver().findElement(By.xpath(HEADER_PATH + "//a[@class='header-logo']")).click();
    }

    public void pressShippingCartIcon() {
        getDriver().findElement(By.xpath(HEADER_PATH + "//div[@class='cart-icon']/a")).click();
    }

    public boolean signinExists() {
        return isElementVisible(By.xpath(HEADER_PATH + "//button[text()='Sign In']"))
                || isElementClickable(By.xpath(HEADER_PATH + "//button[text()='Sign In']"));
    }
}
