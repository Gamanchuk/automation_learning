package steps.qvc;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import entities.components.ButtonComponent;
import entities.components.SignInFormComponent;
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
    private SignInFormComponent signInFormComponent = new SignInFormComponent();


    @Given("^user adds to cart product$")
    public void userAddsToCartProduct() {
        qvcProductPage.setCookies();
        assertTrue(qvcMainPage.isPage(), "Main page doesn't opened");

        this.addProduct();

        qvcCartPage.processToCheckout();
        assertTrue(buttonComponent.exists(), "Button component doesn't present on page. " +
                "It seems that the checkout did not boot for " + TIMEOUT_SECONDS + " seconds");
    }

    @Given("^user adds to cart product and speed buy$")
    public void userAddsToCartProductAndSpeedBuy() {
        qvcProductPage.setCookies();
        assertTrue(qvcMainPage.isPage(), "Main page doesn't opened");

        this.addProduct();

        qvcCartPage.processToSpeedBuy();
        assertTrue(buttonComponent.exists(), "Button component doesn't present on page. " +
                "It seems that the checkout did not boot for " + TIMEOUT_SECONDS + " seconds");
    }

    @Given("^user speed buy product$")
    public void userSpeedBuyProduct() {
        qvcProductPage.setCookies();
        assertTrue(qvcMainPage.isPage(), "Main page doesn't opened");
        this.speedBuyProduct();
        assertTrue(buttonComponent.exists(), "Button component doesn't present on page. " +
                "It seems that the checkout did not boot for " + TIMEOUT_SECONDS + " seconds");
    }

    @Given("^user adds to cart \"([^\"]*)\" products$")
    public void userAddsToCartProducts(int count) {
        qvcProductPage.setCookies();
        assertTrue(qvcMainPage.isPage(), "Main page doesn't opened");

        for (int i = 0; i < count; i++) {
            this.addProduct();
        }

        qvcCartPage.processToCheckout();
        assertTrue(buttonComponent.exists(), "Button component doesn't present on page. " +
                "It seems that the checkout did not boot for " + TIMEOUT_SECONDS + " seconds");
    }

    @And("^user should be on QVC cart page$")
    public void userShouldBeOnCartPage() {
        assertTrue(qvcCartPage.isPage(), "Cart page was not opened");
    }

    @Then("^user should be on QVC main page$")
    public void userShouldBeOnMainPage() {
        assertTrue(qvcMainPage.isPage(), "Main page was not opened. Maybe page have some problems with loading");
        CommonFunctions.attachScreenshot("Main page opened");
    }

    private void addProduct() {
        qvcProductPage.openPage(DataProvider.getRandomItem());
        CommonFunctions.attachScreenshot("Product Page");

        assertTrue(qvcProductPage.isColorListExist(), "Color list doesn't present on product page.");
        String color = qvcProductPage.selectRandomColor();
        CommonFunctions.attachScreenshot("Color selected: " + color);

        qvcProductPage.addToCart();

        if (!qvcCartPage.isPage()) {
            qvcProductPage.addToCart();
        }

        assertTrue(qvcCartPage.isPage(), "Cart page doesn't present.");
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

    @And("^user presses the Where do I enter my password link$")
    public void userPressesTheWhereDoIEnterMyPasswordLink() {
        signInFormComponent.pressWhereDoIEnterMyPassword();
        CommonFunctions.attachScreenshot("Where do I enter my password");
        assertEquals(signInFormComponent.getContentAboutPasswordFill(), "If you have a QVC Password, you'll enter it on the next screen. If not, you'll enter your address.");
    }

    private void addProduct() {
        this.openProduct();
        qvcProductPage.addToCart();
        assertTrue(qvcCartPage.isPage(), "Cart page doesn't present.");
    }

    private void openProduct() {
        qvcProductPage.openPage(DataProvider.getRandomItem());
        CommonFunctions.attachScreenshot("Product Page");

        assertTrue(qvcProductPage.isColorListExist(), "Color list doesn't present on product page.");
        String color = qvcProductPage.selectRandomColor();
        CommonFunctions.attachScreenshot("Color selected: " + color);
    }

    private void speedBuyProduct() {
        this.openProduct();
        qvcProductPage.speedBuy();
    }

    @Then("^user should be on Order Status page$")
    public void userShouldBeOnOrderStatusPage() {
        assertTrue(qvcOrderStatusPage.isPage(), "Order Status page was not opened. Maybe page have some problems with loading");
        CommonFunctions.attachScreenshot("Order Status page opened");

    }
}
