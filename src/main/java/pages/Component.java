package pages;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;

public abstract class Component {

    private final int TIMEOUT_SECONDS = 20;

    WebDriver driver = DriverFactory.getDriver();
    private Log log = LogFactory.getLog(this.getClass());
    final String BASE_URL = "http://qa1.ulta.com/?_mwexperienceid=bc6692b3-6dfe-4c87-b334-0065aff58167";

    public abstract boolean isPage();

    void waitForElementClickable(By element, int timeout) {

        log.info("WebDriver wait " + timeout + "s for element: '" + element + "' clickable");
        new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.elementToBeClickable(element));

        log.info("WebDriver say element: '" + element + "' clickable");

    }

    void waitForElementClickable(By element) {

        this.waitForElementClickable(element, TIMEOUT_SECONDS);
    }

    void waitForElementVisible(By element, int timeout) {
        new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    void waitForElementPresence(By element) {

        new WebDriverWait(driver, TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(element));
    }

    void waitForElementVisible(By element) {

        log.info("WebDriver wait " + TIMEOUT_SECONDS + "s for element: '" + element + "' visible");
        new WebDriverWait(driver, TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOfElementLocated(element));
        log.info("WebDriver say element: '" + element + "' visible");


    }

    void waitForElementHidden(By element, int timeout) {
        log.info("WebDriver wait " + timeout + "s for element: '" + element + "' hidden");
        new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.invisibilityOfElementLocated(element));
        log.info("WebDriver say element: '" + element + "' hidden");

    }

    void waitForElementHidden(By element) {
        this.waitForElementHidden(element, TIMEOUT_SECONDS);
    }



}
