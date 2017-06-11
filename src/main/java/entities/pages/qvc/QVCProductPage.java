package entities.pages.qvc;

import entities.pages.BasePage;
import org.openqa.selenium.*;

import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertTrue;

public class QVCProductPage extends BasePage {

    private By addToCart = By.xpath("//button[contains(@class, 'btnAddToCart')]");
    private By colorList = By.cssSelector("li.selectColor");
    private By age = By.id("cbAge");

    public void openPage(String productUrl) {
        getDriver().navigate().to(BASE_URL + productUrl);
        waitForAjax();

        if (isPage()) {
            assertTrue(isPage(), "Product page was not opened.");
        }
    }

    public String selectRandomColor() {
        List<WebElement> colorsListElements = getDriver().findElements(colorList);
        WebElement randomColor = colorsListElements.get(new Random().nextInt(colorsListElements.size()));
        String colorName = randomColor.getText();
        javascriptScroll(randomColor);
        randomColor.click();
        waitForAjax();
        return colorName;
    }

    public boolean isColorListExist(int timeout) {
        return isElementVisible(colorList, timeout);
    }

    public void addToCart() {
        waitForAjax();

        try {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            String result = (String) js.executeScript("checkForColorSize('A', document.getElementsByClassName(\"btnAddToCart\"))");
            log.info("Add to cart status: " + result);
        } catch (JavascriptException js) {
            log.info("Add to cart: " + js.getMessage());
        }
    }

    boolean isPage() {
        return isElementVisible(addToCart);
    }

    public void setCookies() {
        getDriver().get(BASE_URL + COOKIES);
    }

    public boolean isAgeVerificationCheckBoxVisible() {
        waitForDocumentReady();
        return isElementVisible(age, 20) && isElementClickable(age, 20);
    }

    public void confirmAge() {
        getDriver().findElement(age).sendKeys(Keys.RETURN);
        getDriver().findElement(By.xpath("//span[contains(@class, 'wrapBtncontinue')]//input")).click();
    }
}
