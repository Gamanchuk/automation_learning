package entities.components;

import entities.Entity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.DriverFactory;

public class BaseComponent extends Entity {
    public static WebElement getContainerByTitle(String title) {
        return DriverFactory.getDriver().findElement(By.xpath("//div[contains(@class, 'title-component') and contains(.,'" + title + "')]/ancestor::div[contains(@class, 'container') and not(contains(@class, 'header'))]"));
    }

    public static WebElement getComponentByTitle(String title) {
        return DriverFactory.getDriver().findElement(By.xpath("//div[contains(@class, 'title-component') and contains(.,'" + title + "')]/ancestor::div[contains(@class, 'component')]"));
    }

    public void waitForSpinner() {
        // waiting for spinner
        waitForElementPresence(By.cssSelector("div.spinner-container"));
        waitForElementInvisibility(By.cssSelector("div.spinner-container"));
    }
}
