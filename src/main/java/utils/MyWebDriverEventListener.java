package utils;

/*************************************** PURPOSE **********************************

 - This class implements the WebDriverEventListener, which is included under events.
 The purpose of implementing this interface is to override all the methods and define certain useful  Log statements
 which would be displayed/logged as the application under test is being run.

 Do not call any of these methods, instead these methods will be invoked automatically
 as an when the action done (click, findBy etc).

 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverEventListener;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

public class MyWebDriverEventListener implements WebDriverEventListener, WebElement {

    private Log log = LogFactory.getLog(this.getClass());


    private By lastFindBy;
    private String originalValue;


    @Override
    public void beforeNavigateTo(String url, WebDriver webDriver) {
        log.info("WebDriver navigating to: '" + url + "'");

    }

    @Override
    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
        lastFindBy = by;
    }

    @Override
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
        log.info("WebDriver found element: " + lastFindBy);
    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        originalValue = webElement.getAttribute("value");
    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        log.debug("WebDriver changing value in element found " + lastFindBy + " from '" + originalValue + "' to '" + webElement.getAttribute("value") + "'");
    }

    @Override
    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
        log.info("WebDriver click on element " + webElement.getText());
    }



    @Override
    public void onException(Throwable throwable, WebDriver webDriver) {

    }




    @Override
    public void beforeNavigateBack(WebDriver webDriver) {

    }

    @Override
    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {

    }


    @Override
    public void afterNavigateBack(WebDriver webDriver) {

    }

    @Override
    public void beforeNavigateForward(WebDriver webDriver) {

    }

    @Override
    public void afterNavigateForward(WebDriver webDriver) {

    }

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {

    }

    @Override
    public void afterNavigateTo(String s, WebDriver webDriver) {

    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {

    }

    /*
	 * non overridden methods of WebListener class
	 */

    @Override
    public void beforeScript(String s, WebDriver webDriver) {

    }

    @Override
    public void afterScript(String s, WebDriver webDriver) {

    }


    @Override
    public void click() {

    }

    @Override
    @Step(value = "WebDriver submit data")
    public void submit() {

    }

    @Override
    public void sendKeys(CharSequence... charSequences) {

    }

    @Override
    public void clear() {

    }

    @Override
    public String getTagName() {
        return null;
    }

    @Override
    public String getAttribute(String s) {
        return null;
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public String getText() {
        return null;
    }

    @Override
    public List<WebElement> findElements(By by) {
        return null;
    }

    @Override
    public WebElement findElement(By by) {
        return null;
    }

    @Override
    public boolean isDisplayed() {
        return false;
    }

    @Override
    public Point getLocation() {
        return null;
    }

    @Override
    public Dimension getSize() {
        return null;
    }

    @Override
    public Rectangle getRect() {
        return null;
    }

    @Override
    public String getCssValue(String s) {
        return null;
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return null;
    }
}
