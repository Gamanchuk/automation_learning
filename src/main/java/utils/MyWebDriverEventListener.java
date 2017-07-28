package utils;

/************************************* PURPOSE **********************************
 - This class implements the WebDriverEventListener, which is included under events.
 The purpose of implementing this interface is to override all the methods and define certain useful  Log statements
 which would be displayed/logged as the application under test is being run.

 Do not call any of these methods, instead these methods will be invoked automatically
 as an when the action done (click, findBy etc).
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

import java.util.Arrays;

public class MyWebDriverEventListener extends AbstractWebDriverEventListener {
    private Log log = LogFactory.getLog("WebDriverEvent");

    @Override
    public void afterNavigateTo(String url, WebDriver webDriver) {
        log.info("Navigated to: " + url + "");
    }

    @Override
    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
        log.info("Trying to find Element By:  " + by.toString() + "");
    }

    @Override
    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        log.info("Trying to click on: " + webElement.toString());
    }

    public void afterClickOn(WebElement webElement, WebDriver driver) {
        log.info("Clicked on: " + webElement.toString());
    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        String idField = element.getAttribute("id");

        if (keysToSend == null) {
            log.info(String.format("Clear %s filed", idField));
        } else {
            log.info(String.format("Fill: %s value in to %s field.", Arrays.toString(keysToSend), idField));
        }
    }


}
