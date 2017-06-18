package steps.qvc;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import entities.components.ButtonComponent;
import entities.pages.qvc.QVCCartPage;
import entities.pages.qvc.QVCForgotPasswordPage;
import entities.pages.qvc.QVCMainPage;
import entities.pages.qvc.QVCProductPage;
import utils.CommonFunctions;
import utils.pepboys.DataProvider;

import static entities.Entity.TIMEOUT_SECONDS;
import static org.testng.Assert.assertTrue;

public class QVCPageSteps {
    private QVCCartPage qvcCartPage = new QVCCartPage();
    private QVCMainPage qvcMainPage = new QVCMainPage();
    private QVCProductPage qvcProductPage = new QVCProductPage();

    private ButtonComponent buttonComponent = new ButtonComponent();
    private QVCForgotPasswordPage forgotPasswordPage = new QVCForgotPasswordPage();

    @Given("^user adds to cart product$")
    public void userAddsToCartProduct() {
        qvcProductPage.setCookies();
        assertTrue(qvcMainPage.isPage(), "Main page doesn't opened");

        this.addProduct();

        qvcCartPage.processToCheckout();
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
        assertTrue(qvcMainPage.isPage(), "Main page was not opened. Or page have some problems with loading");
        CommonFunctions.attachScreenshot("Main page opened");
    }

    private void addProduct() {
        qvcProductPage.openPage(DataProvider.getRandomItem());
        CommonFunctions.attachScreenshot("Product Page");

        assertTrue(qvcProductPage.isColorListExist(), "Color list doesn't present on product page.");
        String color = qvcProductPage.selectRandomColor();
        CommonFunctions.attachScreenshot("Color selected: " + color);

        qvcProductPage.addToCart();

        assertTrue(qvcCartPage.isPage(), "Cart page doesn't present.");
    }

    @Then("^user should be on QVC forgot password page$")
    public void userShouldBeOnForgotPasswordPage() {
        assertTrue(forgotPasswordPage.isPage(), "Forgot password page was not opened. Or page have some problems with loading");
        CommonFunctions.attachScreenshot("Forgot Password page opened");
    }
}
