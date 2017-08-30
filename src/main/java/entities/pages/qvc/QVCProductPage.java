package entities.pages.qvc;

import entities.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import utils.CommonFunctions;

import static org.testng.Assert.assertTrue;

public class QVCProductPage extends BasePage {

    private By addToCart = By.xpath("//button[contains(@class, 'btnAddToCart')]");
    private By colorList = By.cssSelector("div.selectColor");
    private By age = By.id("cbAge");

    public void openPage(String productUrl) {
        String fullPath = BASE_URL + productUrl;

        log.info("Full path: " + fullPath);
        CommonFunctions.sleep(1000);
        getDriver().navigate().to(fullPath);

        javascriptScroll(500);
        assertTrue(isPage(), "Product page was not opened.");
    }

    public void selectRandomColor() {
        // need sleep after scroll
        CommonFunctions.sleep(1000);
        assertTrue(isElementVisible(colorList) && isElementClickable(colorList), "Color list doesn't on page");

        getDriver().findElements(colorList).get(0).click();
    }

    public boolean isColorListExist() {
        return isElementPresent(colorList);
    }

    public void addToCart() {
        getDriver().findElement(addToCart).click();
    }

    public void speedBuy() {
        waitForAjax();

        try {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            String result = (String) js.executeScript("checkForColorSize('S', document.getElementsByClassName(\"btnSpeedBuy\"))");
            log.info("Add to cart status: " + result);
        } catch (JavascriptException js) {
            log.error("Add to cart: " + js.getMessage());
        }
    }

    @Override
    public boolean isPage() {
        return isElementVisible(addToCart);
    }
}
