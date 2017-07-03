package entities.pages.qvc;

import entities.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertTrue;

public class QVCProductPage extends BasePage {

    private By addToCart = By.xpath("//button[contains(@class, 'btnAddToCart')]");
    private By colorList = By.cssSelector("li.selectColor");
    private By age = By.id("cbAge");

    public void openPage(String productUrl) {
        String fullPath = BASE_URL + productUrl;

        getDriver().navigate().to(fullPath);
        waitForDocumentReady();

        if (!isUrlChanged(fullPath, 5)) {
            getDriver().navigate().to(fullPath);
            waitForDocumentReady();
        }


        assertTrue(isPage(), "Product page was not opened.");

    }

    public String selectRandomColor() {
        javascriptScroll(500);
        assertTrue(isElementVisible(colorList), "Color list doesn't on page");

        List<WebElement> colorsListElements = getDriver().findElements(colorList);
        WebElement randomColor = colorsListElements.get(new Random().nextInt(colorsListElements.size()));

        String colorName = randomColor.getAttribute("data-original-title");

        randomColor.click();
        waitForAjax();

        return colorName;
    }

    public boolean isColorListExist() {
        return isElementVisible(colorList);
    }

    public void addToCart() {
        waitForAjax();

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
        String prNumber = System.getProperty("mw.pr.number");
        String prLoader = System.getProperty("mw.pr.loader");
        log.info("PR NUMBER: " + prNumber);
        log.info("PR LOADER: " + prLoader);
        log.info(BASE_URL);
        log.info(COOKIES);

        String URL = BASE_URL + COOKIES + prNumber + prLoader;
        log.error(URL);
        getDriver().get(URL);
        // getDriver().get(String.format("%s%s%s%s", BASE_URL, COOKIES, prNumber, prLoader));
    }
}
