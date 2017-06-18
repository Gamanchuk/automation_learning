package steps.pepboys;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import entities.components.ButtonComponent;
import entities.pages.qvc.QVCCartPage;
import entities.pages.qvc.QVCProductPage;
import utils.CommonFunctions;
import utils.Config;
import utils.DriverFactory;
import utils.HTTPLogger;
import utils.pepboys.DataProvider;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import static entities.Entity.TIMEOUT_SECONDS;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class QVCPageSteps {

    ButtonComponent buttonComponent = new ButtonComponent();

    QVCProductPage productPage = new QVCProductPage();
    QVCCartPage cartPage = new QVCCartPage();

    @Given("^user adds to cart product$")
    public void userAddsToCartProduct() {
        StringBuilder scuGroup = new StringBuilder(DataProvider.getRandomItemId());
        productPage.setCookies();
        productPage.openPage(scuGroup.toString());
        CommonFunctions.attachScreenshot("Product Page");

        String color = productPage.selectRandomColor();
        CommonFunctions.attachScreenshot("Color selected: " + color);

        productPage.addToCart();
        assertTrue(cartPage.isPage(), "Cart page doesn't present.");

        cartPage.processToCheckout();
        assertTrue(buttonComponent.exists(), "Button component doesn't present on page. " +
                "It seems that the checkout did not boot for " + TIMEOUT_SECONDS + " seconds");
    }

    @And("^\"([^\"]*)\" event should arrive to Analytics$")
    public void eventShouldArriveToAnalytics(String event) throws UnsupportedEncodingException {
        String message = HTTPLogger.getMessageForURL(Config.ANALYTICS_URL);

        assertTrue(message != null, "Log message for " + Config.ANALYTICS_URL + " not found");
        assertEquals(HTTPLogger.getEndPoint(HTTPLogger.getURLFromMessage(message)), event, "Unexpected event");

        String puParam = HTTPLogger.getRequestParameter(HTTPLogger.getURLFromMessage(message), "pu");
        puParam = URLDecoder.decode(puParam, "UTF-8");

        assertEquals(puParam, DriverFactory.getDriver().getCurrentUrl(), "Unexpected event: " + event);
    }
}
