package entities.pages.qvc;

import entities.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import utils.CommonFunctions;

import static org.testng.Assert.assertTrue;

public class QVCProductPage extends BasePage {

    private By addToCart = By.xpath("//button[contains(@class, 'btnAddToCart')]");
    private By colorList = By.cssSelector("li.selectColor");
    private By age = By.id("cbAge");

    public void openPage(String productUrl) {
        String fullPath = String.format("%s%s", BASE_URL, productUrl);

        getDriver().navigate().to(fullPath);
        CommonFunctions.sleep(3000);
        waitForDocumentReady();

        if (!isUrlChanged(fullPath, 5)) {
            log.info("URL not changed. Retry navigate on page");
            getDriver().navigate().to(fullPath);
            waitForDocumentReady();
        }

        assertTrue(isPage(), "Product page was not opened.");
    }

    public void selectRandomColor() {
        javascriptScroll(500);

        // need sleep after scroll
        CommonFunctions.sleep(1000);
        assertTrue(isElementVisible(colorList), "Color list doesn't on page");

        getDriver().findElement(colorList).click();
        waitForAjax();
    }

    public boolean isColorListExist() {
        return isElementPresent(colorList);
    }

    public void addToCart() {
        waitForAjax();
        waitForDocumentReady();

        try {
            JavascriptExecutor js = (JavascriptExecutor) getDriver();
            String result = (String) js.executeScript("checkForColorSize('A', document.getElementsByClassName(\"btnAddToCart\"))");
            log.info("Add to cart status: " + result);
        } catch (JavascriptException js) {
            log.error("Add to cart: " + js.getMessage());
        }
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

    boolean isPage() {
        return isElementVisible(addToCart);
    }

    public void setCookies() {
        getDriver().get(BASE_URL + COOKIES);
    }
}
