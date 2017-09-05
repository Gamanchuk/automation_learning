package entities.components;

import org.openqa.selenium.By;

import static org.testng.Assert.assertTrue;

public class HeaderComponent extends BaseComponent {
    private final String HEADER_PATH = "//header[contains(@class, 'header')]";

    private By signInButton = By.xpath(HEADER_PATH + "//button[text()='Sign In']");
    private By logo = By.xpath(HEADER_PATH + "//a[@class='header-logo']");
    private By cartIcon = By.xpath(HEADER_PATH + "//div[@class='cart-icon']/a");

    public void pressSignInButton() {
        assertTrue(isSignInButtonExists(), "Looks like 'Sign In' button doesn't present.");
        getDriver().findElement(signInButton).click();
    }

    public void pressLogoLink() {
        getDriver().findElement(logo).click();
    }

    public void pressShippingCartIcon() {
        getDriver().findElement(cartIcon).click();
    }

    public boolean isSignInButtonExists() {
        return isElementVisible(signInButton) || isElementClickable(signInButton);
    }

    @Override
    public boolean isExist() {
        return isElementVisible(By.xpath(HEADER_PATH));
    }

    @Override
    public boolean isExist(int timeout) {
        return isElementVisible(By.xpath(HEADER_PATH), timeout);
    }
}
