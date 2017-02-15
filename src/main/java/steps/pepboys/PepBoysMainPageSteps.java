package steps.pepboys;

import components.pages.pepboys.*;
import components.widgets.CategoriesWidget;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import utils.CommonFunctions;

import static org.testng.Assert.assertTrue;

public class PepBoysMainPageSteps {

    private PepBoysMainPage mainPage = new PepBoysMainPage();
    private PepBoysMakeAppointmentPage makeAppointmentPage = new PepBoysMakeAppointmentPage();
    private PepBoysProductsInCategoryPage productsPage = new PepBoysProductsInCategoryPage();
    private PepBoysCategoriesPage categoriesPage = new PepBoysCategoriesPage();
    private PepBoysProductPage productPage = new PepBoysProductPage();
    private CategoriesWidget categoriesWidget = new CategoriesWidget();

    @Before
    public void makeAppointment() {
        mainPage.navigateMainPage();
        mainPage.openMakeAppointment();
        makeAppointmentPage.selectDifferentLocation("94105");
    }

    @Given("user is on main page")
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

    @When("^user adds it to the cart with \"([^\"]*)\" delivery option$")
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
}
