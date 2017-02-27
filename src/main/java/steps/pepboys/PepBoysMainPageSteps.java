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

    private PepBoysMainPage mainPage = new PepBoysMainPage();
    private PepBoysMakeAppointmentPage makeAppointmentPage = new PepBoysMakeAppointmentPage();
    private PepBoysProductsInCategoryPage productsPage = new PepBoysProductsInCategoryPage();
    private PepBoysCategoriesPage categoriesPage = new PepBoysCategoriesPage();
    private PepBoysProductPage productPage = new PepBoysProductPage();
    private PepBoysCartPage cartPage = new PepBoysCartPage();
    private PepBoysBillingPage billingPage = new PepBoysBillingPage();

    private CategoriesWidget categoriesWidget = new CategoriesWidget();

    @Given("^user makes appoint with code \"([^\"]*)\"$")
    public void userMakesAppointWithCode(String code) {
        makeAppointmentPage.navigateWithCookies();
        makeAppointmentPage.selectDifferentLocation(code);
        CommonFunctions.attachScreenshot("Store: " + code + " selected");
    }

    @Deprecated
    @Given("^user makes appoint with zip-code \"([^\"]*)\"$")
    public void makeAppointment(String zipCode) {
        mainPage.navigateMainPage();
        mainPage.openMakeAppointment();
        makeAppointmentPage.selectDifferentLocation(zipCode);
    }

    @Given("^user is on main page$")
    public void userIsOnMainPage() {
        mainPage.navigateMainPage();
        assertTrue(mainPage.isPageLoaded(), "Main page was not loaded");
        CommonFunctions.attachScreenshot("Main page loaded");
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
        mainPage.openProductPage(id);
        productPage.setDeliveryOption(deliveryOption);
        productPage.addToCart();
        assertTrue(productPage.isInfoDialogOpened(), "Info dialog about adding item to cart was not displayed");
        CommonFunctions.attachScreenshot("Info dialog about adding item to cart was opened");
    }


}


