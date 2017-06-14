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

    ButtonComponent buttonComponent = new ButtonComponent();

    QVCProductPage productPage = new QVCProductPage();
    QVCCartPage cartPage = new QVCCartPage();
    QVCMainPage mainPage = new QVCMainPage();
    QVCForgotPasswordPage forgotPasswordPage = new QVCForgotPasswordPage();

    @Given("^user adds to cart product$")
    public void userAddsToCartProduct() {
        productPage.setCookies();
        assertTrue(mainPage.isPage(), "Main page doesn't opened");

        addProduct();

        cartPage.processToCheckout();
        assertTrue(buttonComponent.exists(), "Button component doesn't present on page. " +
                "It seems that the checkout did not boot for " + TIMEOUT_SECONDS + " seconds");
    }

    @Given("^user adds to cart \"([^\"]*)\" products$")
    public void userAddsToCartProducts(int count) {
        productPage.setCookies();

        for (int i = 0; i < count; i++) {
            addProduct();
        }

        cartPage.processToCheckout();
        assertTrue(buttonComponent.exists(), "Button component doesn't present on page. " +
                "It seems that the checkout did not boot for " + TIMEOUT_SECONDS + " seconds");

    }

    private void addProduct() {
        StringBuilder scuGroup = new StringBuilder(DataProvider.getRandomItemId());
        productPage.openPage(scuGroup.toString());
        CommonFunctions.attachScreenshot("Product Page");

        //TODO: return color

        assertTrue(productPage.isColorListExist(), "Color list doesn't present on product page.");
        String color = productPage.selectRandomColor();
        CommonFunctions.attachScreenshot("Color selected: " + color);


        productPage.addToCart();
//        if (productPage.isAgeVerificationCheckBoxVisible()) {
//            productPage.confirmAge();
//            CommonFunctions.attachScreenshot("Confirm Age");
//        }
        assertTrue(cartPage.isPage(), "Cart page doesn't present.");
    }

    @And("^user should be on QVC cart page$")
    public void userShouldBeOnCartPage() {
        assertTrue(cartPage.isPage(), "Cart page was not opened");
    }

    @Then("^user should be on QVC main page$")
    public void userShouldBeOnMainPage() {
        assertTrue(mainPage.isPage(), "Main page was not opened. Or page have some problems with loading");
        CommonFunctions.attachScreenshot("Main page opened");
    }

    @Then("^user should be on QVC forgot password page$")
    public void userShouldBeOnForgotPasswordPage() {
        assertTrue(forgotPasswordPage.isPage(), "Forgot password page was not opened. Or page have some problems with loading");
        CommonFunctions.attachScreenshot("Forgot Password page opened");
    }
}
