package steps.philosophy;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import entities.pages.philosophy.PHILOSOPHYCartPage;
import entities.pages.philosophy.PHILOSOPHYMainPage;
import entities.pages.philosophy.PHILOSOPHYProductPage;
import entities.pages.philosophy.PHILOSOPHYWarningPage;
import steps.BaseSteps;
import utils.CommonFunctions;
import utils.pepboys.DataProvider;

import static org.testng.Assert.assertTrue;

public class PHILOSOPHYPageSteps extends BaseSteps {
    private PHILOSOPHYCartPage philosophyCartPage = new PHILOSOPHYCartPage();
    private PHILOSOPHYMainPage philosophyMainPage = new PHILOSOPHYMainPage();
    private PHILOSOPHYProductPage philosophyProductPage = new PHILOSOPHYProductPage();
    private PHILOSOPHYWarningPage philosophyWarningPage = new PHILOSOPHYWarningPage();


    @Given("^user adds product to cart from Philosophy")
    public void userAddsToCartProductFromPhilosophy() {
        philosophyMainPage.navigate();
        assertTrue(philosophyWarningPage.isPage(), "Warning does not present.");

        philosophyWarningPage.ignoreWarning();
        assertTrue(philosophyMainPage.isPage(), "Looks like Main page was not opened.");

        this.addProduct();
        CommonFunctions.attachScreenshot("Cart with product");
    }

    @And("^chooses \"([^\"]*)\" method from Philosophy$")
    public void userChoosesMethod(String method) {
        switch (method) {
            case "PayPal":
                philosophyCartPage.processToPayPal();
                break;
            case "Checkout":
                philosophyCartPage.processToCheckout();
                break;
        }

        waitForCheckoutMethodsComponent();
    }

    @Then("^user should be on Philosophy Forgot Password page$")
    public void userShouldBeOnPhilosophyForgotPasswordPage() {
        // assertTrue(shoeForgotPasswordPage.isPage(), "Looks like Forgot Password page was not opened.");
    }

    @Given("^user adds products to cart \"([^\"]*)\" from Philosophy")
    public void userAddsToCartProductsFromPhilosophy(int count) {

        for (int i = 0; i < count; i++) {
            this.addProduct();
        }

        philosophyCartPage.processToCheckout();
        waitForCheckout();
    }

    @And("^user should be on Philosophy cart page$")
    public void userShouldBeOnPhilosophyCartPage() {
        assertTrue(philosophyCartPage.isPage(), "Cart page was not opened.");
        CommonFunctions.attachScreenshot("Cart page opened");
    }

    @Then("^user should be on Philosophy main page$")
    public void userShouldBeOnPhilosophyMainPage() {
        assertTrue(philosophyMainPage.isPage(), "Main page was not opened. Maybe page have some problems with loading.");
        CommonFunctions.attachScreenshot("Main page opened");
    }

    private void addToBag() {
        philosophyProductPage.addToCart();
        assertTrue(philosophyWarningPage.isPage(), "Warning does not present.");
        philosophyWarningPage.ignoreWarning();

        assertTrue(philosophyCartPage.isPage(), "Bag modal window doesn't present.");
    }

    private void addProduct() {
        this.openProduct();
        this.addToBag();
    }

    private void addProduct(String url) {
        this.openProduct(url);
        this.addToBag();
    }

    private void openProduct() {
        philosophyProductPage.openPage(DataProvider.getRandomItem());
        CommonFunctions.attachScreenshot("Product Page");
    }

    private void openProduct(String url) {
        philosophyProductPage.openPage(url);
        CommonFunctions.attachScreenshot("Product Page");
    }
}
