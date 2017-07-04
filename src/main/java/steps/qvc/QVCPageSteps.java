package steps.qvc;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import entities.components.ButtonComponent;
import entities.pages.qvc.*;
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
    private QVCCartPage qvcCartPage = new QVCCartPage();
    private QVCMainPage qvcMainPage = new QVCMainPage();
    private QVCProductPage qvcProductPage = new QVCProductPage();
    private QVCOrderStatusPage qvcOrderStatusPage = new QVCOrderStatusPage();
    private QVCForgotPasswordPage forgotPasswordPage = new QVCForgotPasswordPage();

    private ButtonComponent buttonComponent = new ButtonComponent();

    @Given("^user adds to cart product$")
    public void userAddsToCartProduct() {
        this.setCookies();

        this.addProduct();

        qvcCartPage.processToCheckout();
        assertTrue(buttonComponent.exists(), "Button component doesn't present on page. " +
                "It seems that the checkout did not boot for " + TIMEOUT_SECONDS + " seconds");
    }

    @Given("^user adds to cart \"([^\"]*)\" products$")
    public void userAddsToCartProducts(int count) {
        this.setCookies();

        for (int i = 0; i < count; i++) {
            this.addProduct();
        }

        qvcCartPage.processToCheckout();
        assertTrue(buttonComponent.exists(), "Button component doesn't present on page. " +
                "It seems that the checkout did not boot for " + TIMEOUT_SECONDS + " seconds");
    }

    @Given("^user speed buy product$")
    public void userSpeedBuyProduct() {
        this.setCookies();

        this.speedBuyProduct();
        assertTrue(buttonComponent.exists(), "Button component doesn't present on page. " +
                "It seems that the checkout did not boot for " + TIMEOUT_SECONDS + " seconds");
    }

    @Given("^user adds to cart product and speed buy$")
    public void userAddsToCartProductAndSpeedBuy() {
        this.setCookies();

        this.addProduct();

        qvcCartPage.processToSpeedBuy();
        assertTrue(buttonComponent.exists(), "Button component doesn't present on page. " +
                "It seems that the checkout did not boot for " + TIMEOUT_SECONDS + " seconds");
    }

    @And("^user should be on QVC cart page$")
    public void userShouldBeOnCartPage() {
        assertTrue(qvcCartPage.isPage(), "Cart page was not opened");
        CommonFunctions.attachScreenshot("Cart page opened");
    }

    @Then("^user should be on QVC main page$")
    public void userShouldBeOnMainPage() {
        assertTrue(qvcMainPage.isPage(), "Main page was not opened. Maybe page have some problems with loading");
        CommonFunctions.attachScreenshot("Main page opened");
    }

    @Then("^user should be on QVC forgot password page$")
    public void userShouldBeOnForgotPasswordPage() {
        assertTrue(forgotPasswordPage.isPage(), "Forgot password page was not opened. Or page have some problems with loading");
        CommonFunctions.attachScreenshot("Forgot Password page opened");
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

    @Then("^user should be see error message on QVC cart page with text \"([^\"]*)\"$")
    public void userShouldBeSeeErrorMessageOnQVCCartPageWithText(String errorMessage) {
        assertTrue(qvcCartPage.isPage(), "Cart page doesn't present.");
        assertEquals(qvcCartPage.getErrorMessage(), errorMessage, "Unexpected error message on QVC cart page");
        CommonFunctions.attachScreenshot("Error message");
    }

    @Then("^user should be on Order Status page$")
    public void userShouldBeOnOrderStatusPage() {
        assertTrue(qvcOrderStatusPage.isPage(), "Order Status page was not opened. Maybe page have some problems with loading");
        CommonFunctions.attachScreenshot("Order Status page opened");

    }

    private void setCookies() {
        qvcProductPage.setCookies();

        if (qvcMainPage.isPage()) {
            qvcProductPage.setCookies();
        }

        assertTrue(qvcMainPage.isPage(), "Main page doesn't opened");
    }

    private void addProduct() {

        this.openProduct();

        qvcProductPage.addToCart();

        if (!qvcCartPage.isPage()) {
            qvcProductPage.addToCart();
        }

        assertTrue(qvcCartPage.isPage(), "Cart page doesn't present.");
    }

    private void openProduct() {
        qvcProductPage.openPage(DataProvider.getRandomItem());
        CommonFunctions.attachScreenshot("Product Page");

        CommonFunctions.sleep(2000);
        assertTrue(qvcProductPage.isColorListExist(), "Color list doesn't present on product page.");
        //String color =
        qvcProductPage.selectRandomColor();
        CommonFunctions.attachScreenshot("Color selected: ");
    }

    private void speedBuyProduct() {
        qvcProductPage.setCookies();
        assertTrue(qvcMainPage.isPage(), "Main page doesn't opened");

        this.openProduct();
        qvcProductPage.speedBuy();
    }
}
