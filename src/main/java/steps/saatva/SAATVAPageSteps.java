package steps.saatva;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import entities.pages.saatva.SAATVACartPage;
import entities.pages.saatva.SAATVAMainPage;
import entities.pages.saatva.SAATVAProductPage;
import steps.BaseSteps;
import utils.CommonFunctions;
import utils.pepboys.DataProvider;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class SAATVAPageSteps extends BaseSteps {
    private SAATVACartPage saatvaCartPage = new SAATVACartPage();
    private SAATVAMainPage saatvaMainPage = new SAATVAMainPage();
    private SAATVAProductPage saatvaProductPage = new SAATVAProductPage();

    @Given("^user adds to cart product from Saatva$")
    public void userAddsToCartProductFromSaatva() {
        this.setCookies();
        this.addProduct();
        CommonFunctions.attachScreenshot("Cart with product");
    }

    @Given("^user adds to cart \"([^\"]*)\" products from Saatva$")
    public void userAddsToCartProductsFromSaatva(int count) {
        this.setCookies();

        for (int i = 0; i < count; i++) {
            this.addProduct();
        }
    }

    @And("^user should be on Saatva cart page$")
    public void userShouldBeOnCartPage() {
        assertTrue(saatvaCartPage.isPage(), "Cart page was not opened.");
        CommonFunctions.attachScreenshot("Cart page opened");
    }

    @Then("^user should be on Saatva main page$")
    public void userShouldBeOnMainPage() {
        assertTrue(saatvaMainPage.isPage(), "Main page was not opened. Maybe page have some problems with loading.");
        CommonFunctions.attachScreenshot("Main page opened");
    }

    private void setCookies() {
        saatvaMainPage.setCookies();

        if (!saatvaMainPage.isPage()) {
            saatvaMainPage.setCookies();
        }

        assertTrue(saatvaMainPage.isPage(), "Main page doesn't opened");
    }

    private void addProduct() {

        this.openProduct();

        saatvaProductPage.addToCart();

        if (!saatvaCartPage.isPage()) {
            saatvaProductPage.addToCart();
        }

        assertTrue(saatvaCartPage.isPage(), "Cart page doesn't present.");
    }

    private void openProduct() {
        saatvaProductPage.openPage(DataProvider.getRandomItem());
        CommonFunctions.attachScreenshot("Product Page");
    }

    @And("^chooses \"([^\"]*)\" method on Saatva cart page$")
    public void choosesMethodOnSaatvaCartPage(String method) {
        switch (method) {
            case "Checkout":
                saatvaCartPage.processToCheckout();
                waitForCheckout();
                break;
            case "PayPal":
                saatvaCartPage.checkOutWithPayPal();
                break;
            case "PayPal Credit":
                saatvaCartPage.checkOutWithPayPalCredit();
                break;
            default:
                fail("Error in code. Framework doesn't support this Payment Method: " + method);
        }
    }
}
