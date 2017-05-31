package entities;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonFunctions;
import utils.DriverFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public abstract class Entity {

    public static final int TIMEOUT_SECONDS = 60;

    private WebElement root = null;
    private WebDriver driver = DriverFactory.getDriver();

    public Log log = LogFactory.getLog(this.getClass().getSimpleName());

    public Entity() {

    }

    public Entity(WebElement root) {
        this.root = root;
    }

    public void setRoot(WebElement root) {
        this.root = root;
    }

    public WebElement findElement(By selector) {
        if (root != null) {
            return root.findElement(selector);
        } else {
            return driver.findElement(selector);
        }
    }

    public List<WebElement> findElements(By selector) {
        if (root != null) {
            return root.findElements(selector);
        } else {
            return driver.findElements(selector);
        }
    }

    public WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    public Log getLog() {
        return LogFactory.getLog(this.getClass().getSimpleName());
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
        if(this.root == null) {
            return this.waitForCondition(ExpectedConditions.visibilityOfElementLocated(element), timeout);
        } else {
            return isElementVisible(element, this.root, timeout);
        }
    }

    public boolean isElementVisible(By element) {
        return this.isElementVisible(element, TIMEOUT_SECONDS);
    }

    public boolean isElementPresent(By element, int timeout) {
        log.info("Checking if element: '" + element + "' presence");
        if(this.root == null) {
            return this.waitForCondition(ExpectedConditions.presenceOfElementLocated(element), timeout);
        } else {
            return isElementPresent(element, this.root, timeout);
        }
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
        if(root == null) {
            new WebDriverWait(driver, timeout)
                    .until(ExpectedConditions.visibilityOfElementLocated(element));
        } else {
            waitForElementVisible(element, this.root, timeout);
        }
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
        if(this.root == null) {
            new WebDriverWait(driver, TIMEOUT_SECONDS)
                    .until(ExpectedConditions.presenceOfElementLocated(element));
        } else {
            waitForElementPresence(element, root, timeout);
        }
    }

    public void waitForElementPresence(By element) {
        this.waitForElementPresence(element, TIMEOUT_SECONDS);
    }

    public void waitForElementHidden(By element) {
        this.waitForElementVisible(element, TIMEOUT_SECONDS);
    }

    public void waitForElementHidden(By element, int timeout) {
        log.info("Waiting " + timeout + "s for element: '" + element + "' hidden");
        new WebDriverWait(driver, TIMEOUT_SECONDS)
                .until(ExpectedConditions.invisibilityOfElementLocated(element));
    }

    public boolean isElementVisible(By element, WebElement parent) {
        return isElementVisible(element, parent, TIMEOUT_SECONDS);
    }

    public boolean isElementVisible(By element, WebElement parent, int timeout) {
        log.info("Waiting " + timeout + "s for element visible: '" + element + " with parent " + parent + "' presence");

        // As far as we can't use WebDriverWait for element in scope of other element
        // we'll have to create custom wait with black-jack and girls
        int timeout_milis = timeout * 1000;
        for (int delay = 0; delay < timeout_milis; delay += 500) {
            try {
                if(parent.findElement(element).isDisplayed() && parent.findElement(element).isEnabled()) {
                    return true;
                }
            } catch (Exception e) {
                driver.manage().timeouts().implicitlyWait(delay, TimeUnit.MILLISECONDS);
            }
        }
        return false;
    }

    public void waitForElementVisible(By element, WebElement parent) {
        waitForElementVisible(element, parent, TIMEOUT_SECONDS);
    }

    public void waitForElementVisible(By element, WebElement parent, int timeout) {
        if(!isElementVisible(element, parent, timeout)) {
            throw new NoSuchElementException("Failed to find element: " + element + " for " + timeout + "s");
        }
    }

    public boolean isElementPresent(By element, WebElement parent) {
        return isElementPresent(element, parent, TIMEOUT_SECONDS);
    }

    public boolean isElementPresent(By element, WebElement parent, int timeout) {
        log.info("Waiting " + timeout + "s for element presence: '" + element + " with parent " + parent + "' presence");

        // As far as we can't use WebDriverWait for element in scope of other element
        // we'll have to create custom wait with black-jack and girls
        int timeout_milis = timeout * 1000;
        for (int delay = 0; delay < timeout_milis; delay += 500) {
            try {
                parent.findElement(element);
                return true;
            } catch (NoSuchElementException | InvalidElementStateException e) {
                driver.manage().timeouts().implicitlyWait(delay, TimeUnit.MILLISECONDS);
            }
        }
        return false;
    }

    public void waitForElementPresence(By element, WebElement parent) {
        waitForElementPresence(element, parent, TIMEOUT_SECONDS);
    }

    public void waitForElementPresence(By element, WebElement parent, int timeout) {
        if(!isElementPresent(element, parent, timeout)) {
            throw new NoSuchElementException("Failed to find element: " + element + " for " + TIMEOUT_SECONDS + "s");
        }
    }

    public void waitForImageLoaded(By image) {
        new WebDriverWait(driver, TIMEOUT_SECONDS)
                .until(new ExpectedCondition<Boolean>() {
                           @Override
                           public Boolean apply(WebDriver webDriver) {
                               Object result = ((JavascriptExecutor) driver).executeScript("return (typeof arguments[0].naturalWidth!=\"undefined\" && arguments[0].naturalWidth>0)", findElement(image));
                               return (Boolean) result;
                           }
                       }
                );
    }

    public void click(By selector) {
        String pageSource = driver.getPageSource();

        if (pageSource.contains("Your ideas make")
                || pageSource.contains("We want your feedback")) {
            findElement(By.xpath("//a[@class='acsCloseButton--link acsCloseButton acsDeclineButton']")).click();
        }

        try {
            WebDriverWait wait = new WebDriverWait(driver, 30, 200);
            wait.until(ExpectedConditions.presenceOfElementLocated(selector));
            wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
            wait.until(ExpectedConditions.elementToBeClickable(selector));
            scrollToElement(findElement(selector));
            findElement(selector).click();
        } catch (Exception e) {
            log.info(e.getMessage());
            log.info(e.getStackTrace());
            WebElement element = findElement(selector);
            scrollToElement(element);
            element.click();
        }
    }

    public void sendKeysOneByOne(By selector, String str) {
        WebElement el = findElement(selector);
        javascriptScroll(el);
        for (char ch : str.toCharArray()) {
            el.sendKeys(ch + "");
        }
    }

    public void scrollToElement(WebElement el) {
        log.info("Scroll to element: " + el);
        el.getLocation();
        Actions actions = new Actions(driver);
        actions.moveToElement(el);
        actions.perform();
    }

    public void navigate(String url) {
        driver.navigate().to(url);
        waitForAjax();
    }

    public void navigateWithCookies(String url, String cookies) {
        driver.navigate().to(url + cookies);
        waitForRedirect(url + cookies);
        // waitForAjax();
    }

    public void waitForAjax() {
        new WebDriverWait(driver, TIMEOUT_SECONDS).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                boolean result = false;
                try {
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    boolean hasJquery = (Boolean) js.executeScript("return typeof jQuery !== 'undefined'");
                    if (hasJquery) {
                        result = (Boolean) js.executeScript("return jQuery.active === 0 && jQuery.isReady && document.readyState == 'complete'");
                    } else {
                        result = (Boolean) js.executeScript("return document.readyState == 'complete'");
                        log.info("readyState complete: " + result);
                    }
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
        driver.findElement(By.cssSelector("body")).click();
        CommonFunctions.sleep(500);
        //driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
    }

    public void focusOut(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].blur()", element);
    }

    public WebElement findElementWithTextBy(String text, By selector) {
        List<WebElement> elements = findElements(selector);
        for (WebElement element : elements) {
            if (element.getText().contains(text)) {
                return element;
            }
        }
        throw new Error("Element with text: '" + text + "' not found!");
    }

    /**
     * @param ynum Required. How many pixels to scroll by, along the y-axis (vertical).
     *             Positive values will scroll down, while negative values scroll up
     */
    public void javascriptScroll(int ynum) {
        ((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(0," + ynum + ")", "");
    }

    public void javascriptScroll(WebElement element) {
        Actions builder = new Actions(driver);
        builder.moveToElement(element).build().perform();
        CommonFunctions.sleep(200);
    }

    public void switchToIframe(String iframeName) {
        assertTrue(isElementVisible(By.name(iframeName), 120),
                "PayPal login page doesn't present.");
        driver.switchTo().frame(iframeName);
    }

    public boolean isIframeExist(String iframeName) {
        return isElementVisible(By.name(iframeName), 120);
    }

    public void switchToDefaultIframe() {
        driver.switchTo().defaultContent();
    }

    private boolean waitForCondition(ExpectedCondition<WebElement> webElementExpectedCondition, int timeout) {
        try {
            new WebDriverWait(driver, timeout).until(webElementExpectedCondition);
            return true;
        } catch (TimeoutException e) {
            log.info("Condition failed!");
            return false;
        }
    }
}
