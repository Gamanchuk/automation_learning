package entities.pages;

import entities.Entity;
import org.openqa.selenium.By;
import utils.Config;

public abstract class BasePage extends Entity {
    public final String BASE_URL = Config.BASE_URL;
    public final String COOKIES = Config.COOKIES;

    public void clickLinkByTitle(String linkTitle) {
        getDriver().findElement(By.linkText(linkTitle)).click();
    }
}
