package components;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;

public abstract class Component {

    private final int TIMEOUT_SECONDS = 50;

    private WebDriver driver = DriverFactory.getDriver();
    public Log log = LogFactory.getLog(this.getClass());

    public WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    public Log getLog() {
        return LogFactory.getLog(this.getClass());
    }

    public boolean isElementClickable(By element, int timeout) {
        log.info("Checking if element: '" + element + "' clickable");
        return this.waitForCondition(ExpectedConditions.elementToBeClickable(element), timeout);
    }

    public boolean isElementClickable(By element) {
        return this.isElementClickable(element, TIMEOUT_SECONDS);
    }

    public boolean isElementVisible(By element, int timeout) {
        log.info("Checking if element: '" + element + "' visible");
        return this.waitForCondition(ExpectedConditions.visibilityOfElementLocated(element), timeout);
    }

    public boolean isElementVisible(By element) {
        return this.isElementVisible(element, TIMEOUT_SECONDS);
    }

    public boolean isElementPresent(By element, int timeout) {
        log.info("Checking if element: '" + element + "' presence");
        return this.waitForCondition(ExpectedConditions.presenceOfElementLocated(element), timeout);
    }

    public boolean isElementPresent(By element) {
        return this.isElementPresent(element, TIMEOUT_SECONDS);
    }


    public void waitForElementClickable(By element, int timeout) {
        log.info("Waiting " + timeout + "s for element: '" + element + "' clickable");
        new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementInvisibility(By element) {
        log.info("Waiting " + TIMEOUT_SECONDS + "s for element: '" + element + "' hidden");
        new WebDriverWait(driver, TIMEOUT_SECONDS)
                .until(ExpectedConditions.invisibilityOfElementLocated(element));
    }

    public void waitForElementClickable(By element) {
        this.waitForElementClickable(element, TIMEOUT_SECONDS);
    }

    public void waitForElementVisible(By element, int timeout) {
        log.info("Waiting " + timeout + "s for element: '" + element + "' visible");
        new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void waitForAttributeVisible(By element, String attribute, String value) {
        log.info("Waiting for attribute");
        new WebDriverWait(driver, TIMEOUT_SECONDS)
                .until(ExpectedConditions.attributeToBe(element, attribute, value));
    }

    public void waitForElementVisible(By element) {
        this.waitForElementVisible(element, TIMEOUT_SECONDS);
    }

    public void waitForElementPresence(By element, int timeout) {
        log.info("Waiting " + timeout + "s for element: '" + element + "' presence");
        new WebDriverWait(driver, TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(element));
    }

    public void waitForElementPresence(By element) {
        this.waitForElementVisible(element, TIMEOUT_SECONDS);
    }

    public void waitForImageLoaded(By image) {
        new WebDriverWait(driver, TIMEOUT_SECONDS)
                .until(new ExpectedCondition<Boolean>() {
                           @Override
                           public Boolean apply(WebDriver webDriver) {
                               Object result = ((JavascriptExecutor) driver).executeScript("return (typeof arguments[0].naturalWidth!=\"undefined\" && arguments[0].naturalWidth>0)", driver.findElement(image));
                               return (Boolean) result;
                           }
                       }

                );
    }

    private boolean waitForCondition(ExpectedCondition<WebElement> webElementExpectedCondition, int timeout) {
        try {
            new WebDriverWait(driver, timeout).until(webElementExpectedCondition);
            return true;
        } catch (TimeoutException e) {
            log.info("Condition failed!\n" + e);
            return false;
        }
    }

    public void click(By el) {

        if (getDriver().getPageSource().contains("Your ideas make"))
            getDriver().findElement(By.xpath("//a[@class='acsCloseButton--link acsCloseButton acsDeclineButton']")).click();

        try {
            WebDriverWait wait = new WebDriverWait(driver, 30, 200);
            wait.until(ExpectedConditions.presenceOfElementLocated(el));
            wait.until(ExpectedConditions.visibilityOfElementLocated(el));
            wait.until(ExpectedConditions.elementToBeClickable(el));
            scrollToElement(driver.findElement(el));
            driver.findElement(el).click();
        } catch (Exception e) {
            log.info(e.getMessage());
            log.info(e.getStackTrace());
            WebElement element = driver.findElement(el);
            scrollToElement(element);
            element.click();
        }
    }

    public void sendKeysOneByOne(By el, String str) {
        for (char ch : str.toCharArray()) {
            getDriver().findElement(el).sendKeys(ch + "");
        }
    }

    public void scrollToElement(WebElement el) {
        log.info("Scroll to element: " + el);
        el.getLocation();
        Actions actions = new Actions(getDriver());
        actions.moveToElement(el);
        actions.perform();
    }

    public void navigate(String url) {
        getDriver().navigate().to(url);
        waitForAjax();
    }

    public void navigateWithCookies(String url, String cookies) {
        getDriver().navigate().to(url + cookies);
        waitForRedirect(url + cookies);
       // waitForAjax();
    }


    protected void waitForAjax() {
        new WebDriverWait(driver, TIMEOUT_SECONDS).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                boolean result = false;
                try {
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    result = (Boolean) js.executeScript("return jQuery.active === 0 && jQuery.isReady && document.readyState == 'complete'");
                    log.info("jQuery not active: " + result);
                } catch (JavascriptException js) {
                    log.info("waitForAjax: " + js.getMessage());
                    return false;
                }

                return result;
            }
        });
    }

    protected void waitForDocumentReady() {
        new WebDriverWait(driver, TIMEOUT_SECONDS).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                boolean result = (Boolean) js.executeScript("return document.readyState").toString().equals("complete");
                log.info("document.readyState: " + result);
                return result;
            }
        });
    }

    protected void waitForRedirect(String url) {
        new WebDriverWait(driver, TIMEOUT_SECONDS).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                String currentUrl = driver.getCurrentUrl();
                boolean result = currentUrl.equals(url);
                log.info("Browser url changed: " + result + ". Current url: " + currentUrl);
                return result;
            }
        });
    }


    public void focusOut() {
        getDriver().findElement(By.cssSelector("body")).click();
    }

    public void switchToIframe(String iframeName){
        waitForElementVisible(By.name(iframeName), 120);
        driver.switchTo().frame(iframeName);

    }
    public void switchToDefaultIframe(){

        driver.switchTo().defaultContent();

    }
}
