package entities.pages.qvc;

import entities.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.CommonFunctions;

import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertTrue;

public class QVCProductPage extends BasePage {

    By addToCart = By.xpath("//button[contains(@class, 'btnAddToCart')]");
    By colorList = By.cssSelector("li.selectColor");

    public void openPage(String productUrl) {
        getDriver().navigate().to(BASE_URL + productUrl);
        waitForAjax();

        if (isPage()) {
            assertTrue(isPage(), "Product page was not opened.");
        }
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

    public void addToCart() {
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
        CommonFunctions.sleep(2000);
        waitForDocumentReady();
        assertTrue(isElementVisible(By.id("txtMastheadSearch")), "Main page doesn't opened");

    }
}
