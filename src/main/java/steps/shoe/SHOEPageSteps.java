package steps.shoe;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import entities.pages.shoe.*;
import steps.BaseSteps;
import utils.CommonFunctions;
import utils.pepboys.DataProvider;

import static org.testng.Assert.assertTrue;

public class SHOEPageSteps extends BaseSteps {
    private SHOECartPage shoeCartPage = new SHOECartPage();
    private SHOEMainPage shoeMainPage = new SHOEMainPage();
    private SHOEModalCart shoeModalCart = new SHOEModalCart();
    private SHOEProductPage shoeProductPage = new SHOEProductPage();
    private SHOECheckoutPage shoeCheckoutPage = new SHOECheckoutPage();
    private SHOEForgotPasswordPage shoeForgotPasswordPage = new SHOEForgotPasswordPage();


    @Given("^user adds product to cart from Shoe")
    public void userAddsToCartProductFromShoe() {
        this.addProduct();
        CommonFunctions.attachScreenshot("Cart with product");

        shoeCartPage.processToShoeCheckout();
        assertTrue(shoeCheckoutPage.isPage(), "Looks like Shoe checkout page was not opened.");
        shoeCheckoutPage.processToCheckout();
        waitForSignIn();
    }

    @Given("^user adds product to cart with PayPal checkout from Shoe$")
    public void userAddsProductToCartWithPayPalCheckoutFromShoe() {
        this.userAddsToCartProductFromShoe();
        shoeCartPage.navigate();
        this.userShouldBeOnCartPage();
        shoeCartPage.processToPayPal();
    }

    @Given("^user adds product to cart with Pick up in store from Shoe$")
    public void userAddsProductToCartWithPickUpInStoreFromShoe() {
        this.addProduct("womens-converse-chuck-taylor-shoreline/white/78494.scp");
        CommonFunctions.attachScreenshot("Cart with product");

        shoeCartPage.processToShoeCheckout();
        assertTrue(shoeCheckoutPage.isPage(), "Looks like Shoe checkout page was not opened.");
        shoeCheckoutPage.processToCheckout();
        waitForSignIn();
    }

    @Then("^user should be on Shoe Forgot Password page$")
    public void userShouldBeOnShoeForgotPasswordPage() {
        assertTrue(shoeForgotPasswordPage.isPage(), "Looks like Forgot Password page was not opened.");
    }

    @Given("^user adds products to cart \"([^\"]*)\" from Shoe")
    public void userAddsToCartProductsFromSaatva(int count) {

        for (int i = 0; i < count; i++) {
            this.addProduct();
        }

        shoeCartPage.processToShoeCheckout();
        waitForCheckout();
    }

    @And("^user should be on Shoe cart page$")
    public void userShouldBeOnCartPage() {
        assertTrue(shoeCartPage.isPage(), "Cart page was not opened.");
        CommonFunctions.attachScreenshot("Cart page opened");
    }

    @Then("^user should be on Shoe main page$")
    public void userShouldBeOnMainPage() {
        assertTrue(shoeMainPage.isPage(), "Main page was not opened. Maybe page have some problems with loading.");
        CommonFunctions.attachScreenshot("Main page opened");
    }

    private void addToBag() {
        shoeProductPage.addToCart();
        shoeModalCart.switchToFrame();

        if (!shoeModalCart.isPage()) {
            shoeModalCart.switchToDefaultIframe();
            shoeProductPage.addToCart();
            shoeModalCart.switchToFrame();
        }

        assertTrue(shoeModalCart.isPage(), "Bag modal window doesn't present.");


        shoeModalCart.processToCart();
        shoeModalCart.switchToDefaultIframe();

        if (!shoeCartPage.isPage()) {
            shoeModalCart.processToCart();
        }

        assertTrue(shoeCartPage.isPage(), "Bag modal window doesn't present.");
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
        shoeProductPage.openPage(DataProvider.getRandomItem());
        CommonFunctions.attachScreenshot("Product Page");
    }

    private void openProduct(String url) {
        shoeProductPage.openPage(url);
        CommonFunctions.attachScreenshot("Product Page");
    }
}
