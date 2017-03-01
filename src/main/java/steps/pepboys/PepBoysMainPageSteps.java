package steps.pepboys;

import components.pages.pepboys.*;
import components.widgets.CategoriesWidget;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.CommonFunctions;
import utils.pepboys.DataProvider;

import static org.testng.Assert.assertTrue;

public class PepBoysMainPageSteps {

    private PepBoysMakeAppointmentPage makeAppointmentPage = new PepBoysMakeAppointmentPage();
    private PepBoysProductsInCategoryPage productsPage = new PepBoysProductsInCategoryPage();
    private PepBoysCategoriesPage categoriesPage = new PepBoysCategoriesPage();
    private PepBoysProductPage productPage = new PepBoysProductPage();
    private PepBoysCartPage cartPage = new PepBoysCartPage();
    private PepBoysBillingPage billingPage = new PepBoysBillingPage();

    private CategoriesWidget categoriesWidget = new CategoriesWidget();

    @Given("^user makes appoint with code \"([^\"]*)\"$")
    public void userMakesAppointWithCode(String code) {
        makeAppointmentPage.openPage();
        assertTrue(makeAppointmentPage.isPage(), "Appointment page was not opened");
        makeAppointmentPage.selectDifferentLocation(code);
        CommonFunctions.attachScreenshot("Store: " + code + " selected");
    }

    @When("^user selects \"([^\"]*)\"$")
    public void userSelectsProduct(String productName) {
        categoriesWidget.openCategory("Accessories");
        categoriesWidget.openCategory("Exterior Accessories");
        categoriesPage.openCategory("Body Protection");
        productsPage.openProductByName(productName);
        CommonFunctions.attachScreenshot("Opened '" + productName + "' page");
    }

    @And("^adds it to the cart with \"([^\"]*)\" delivery option$")
    public void userAddsItToTheCartWithDeliveryOption(String deliveryOPtion) {
        productPage.setDeliveryOption(deliveryOPtion);
        productPage.addToCart();
        assertTrue(productPage.isInfoDialogOpened(), "Info dialog about adding item to cart was not displayed");
        CommonFunctions.attachScreenshot("Info dialog about adding item to cart was opened");
    }

    @And("^user views cart$")
    public void userViewsCart() {
        productPage.clickViewCartInAddToCartDialog();
        CommonFunctions.attachScreenshot("Cart opened");
    }

    @And("^chooses \"([^\"]*)\" method$")
    public void userChoosesMethod(String method) throws Throwable {
        cartPage.payUsingPaymentMethod(method);
    }

    @And("^user types billing info for \"([^\"]*)\"$")
    public void typesBillingInfoFor(String userName) {
        billingPage.inputBillingInfo(DataProvider.getUser(userName));
    }

    @And("^chooses \"([^\"]*)\" shipping method$")
    public void choosesShippingMethod(String shippingMethod) {
        billingPage.selectShippingMethod(shippingMethod);
    }

    @And("^uses \"([^\"]*)\" card for payment$")
    public void usesCardForPayment(String cardName) {
        billingPage.inputPaymentDetails(DataProvider.getCard(cardName));
    }

    @Then("^user should be on thank you page$")
    public void userShouldBeOnThankYouPage() {
        billingPage.checkPaymentResult();
    }


    @And("^user add to cart product with id \"([^\"]*)\" with \"([^\"]*)\" delivery option$")
    public void userAddToCartProductWithIdWithDeliveryOption(String id, String deliveryOption) throws Throwable {
        productPage.openProductPage(id);
        assertTrue(productPage.isPage(), "Product page was not opened");
        productPage.setDeliveryOption(deliveryOption);
        productPage.addToCart();
        assertTrue(productPage.isInfoDialogOpened(), "Info dialog about adding item to cart was not displayed");
        CommonFunctions.attachScreenshot("Info dialog about adding item to cart was opened");
    }


    @Given("^user make authorisation for \"([^\"]*)\"$")
    public void userMakeAuthorisationFor(String userName) {
        billingPage.doLogin(DataProvider.getUser(userName));
    }

    @And("^apply billing info for address \"([^\"]*)\"$")
    public void applyBillingInfo(String address) {
        billingPage.applyBillingInfo(address);

    }
}


