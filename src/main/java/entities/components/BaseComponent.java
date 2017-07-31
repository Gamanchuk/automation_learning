package entities.components;

import entities.Entity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.DriverFactory;

import static org.testng.Assert.assertTrue;

public class BaseComponent extends Entity {
    public static WebElement getContainerByTitle(String title) {
        return DriverFactory.getDriver().findElement(By.xpath("//div[contains(@class, 'title-component') and contains(.,'" + title + "')]/ancestor::div[contains(@class, 'container') and not(contains(@class, 'header'))]"));
    }

    public static WebElement getComponentByTitle(String title) {
        return DriverFactory.getDriver().findElement(By.xpath("//div[contains(@class, 'title-component') and contains(.,'" + title + "')]/ancestor::div[contains(@class, 'component')]"));
    }

    public static WebElement getNextComponentByTitle(String title) {
        return DriverFactory.getDriver().findElement(By.xpath("//div[contains(@class, 'title-component') and contains(.,'" + title + "')]/following-sibling::node()"));
    }

    public static WebElement getNextElementByTitle(String title) {
        return DriverFactory.getDriver().findElement(By.xpath("//*[@class='title' and text()='" + title + "']/following-sibling::node()"));
    }

    public void exists(By titleComponent, String title) {
        assertTrue(isElementVisible(titleComponent), "Looks like title component with \"" + title + "\" text doesn't present on page.");
    }
}
