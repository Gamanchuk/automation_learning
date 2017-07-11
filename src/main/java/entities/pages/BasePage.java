package entities.pages;

import entities.Entity;
import org.openqa.selenium.By;
import utils.Config;

import static org.testng.Assert.assertTrue;

public abstract class BasePage extends Entity {
    public final String BASE_URL = Config.BASE_URL;
    public final String COOKIES = Config.COOKIES;

    public abstract boolean isPage();

    public void clickLinkByTitle(String linkTitle) {
        assertTrue(isElementVisible(By.linkText(linkTitle)), "Link with text '" + linkTitle + "' doesn't present on page");
        getDriver().findElement(By.linkText(linkTitle)).click();
    }

    public void setCookies() {
        showUrlData();
        String url = String.format("%s%s", BASE_URL, COOKIES);

        if (Config.PR_NUMBER != null && !Config.PR_NUMBER.isEmpty()) {
            url += String.format("%s", Config.PR_NUMBER);
        }

        if (Config.PR_NUMBER != null && !Config.PR_LOADER.isEmpty()) {
            url += String.format("%s", Config.PR_LOADER);
        }

        log.info("Modified url: " + url);

        getDriver().get(url);
    }

    private void showUrlData() {
        log.info("URL data:");
        log.info("Base url: " + BASE_URL);
        log.info("Experience id: " + COOKIES);
        log.info("PR number: " + Config.PR_NUMBER);
        log.info("PR loader: " + Config.PR_LOADER);
    }
}
