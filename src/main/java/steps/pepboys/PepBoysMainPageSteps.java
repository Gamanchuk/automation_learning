package steps.pepboys;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import entities.pages.pepboys.*;
import utils.CommonFunctions;
import utils.TestGlobalsManager;
import utils.pepboys.DataProvider;

import static org.testng.Assert.assertTrue;

public class PepBoysMainPageSteps {

    private PepBoysMakeAppointmentPage makeAppointmentPage = new PepBoysMakeAppointmentPage();
    private PepBoysMainPage mainPage = new PepBoysMainPage();
    private PepBoysProductsInCategoryPage productsPage = new PepBoysProductsInCategoryPage();
    private PepBoysCategoriesPage categoriesPage = new PepBoysCategoriesPage();
    private PepBoysProductPage productPage = new PepBoysProductPage();
    private PepBoysCartPage cartPage = new PepBoysCartPage();
    private PepBoysTiresPage tiresPage = new PepBoysTiresPage();

    @Given("^user makes appoint with code \"([^\"]*)\"$")
    public void userMakesAppointWithCode(String code) {
        makeAppointmentPage.openPage();
        assertTrue(makeAppointmentPage.isPage(), "Appointment page was not opened");
        makeAppointmentPage.selectDifferentLocation(code);

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        CommonFunctions.attachScreenshot("Store: " + code + " selected");
    }

    @Given("^user makes appoint$")
    public void userMakesAppointWithApi() throws Throwable {
        makeAppointmentPage.openPage();
        assertTrue(makeAppointmentPage.isPage(), "Appointment page was not opened");
        makeAppointmentPage.setStoreLocationApi();
    }

    @When("^user selects \"([^\"]*)\"$")
    public void userSelectsProduct(String productName) {
        categoriesPage.openCategory("Accessories");
        categoriesPage.openCategory("Exterior Accessories");
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

    @And("^chooses \"([^\"]*)\" method with appointment details$")
    public void userChoosesMethodWithAppointmentDetails(String method) throws Throwable {
        cartPage.payUsingPaymentMethod(method);
    }

    @And("^user adds to cart product with id \"([^\"]*)\" with \"([^\"]*)\" delivery option$")
    public void userAddsToCartProductWithIdWithDeliveryOption(String id, String deliveryOption) throws Throwable {
        productPage.openProductPage(id);
        assertTrue(productPage.isPage(), "Product page was not opened");
        productPage.setDeliveryOption(deliveryOption);
        productPage.addToCart();

        assertTrue(productPage.isInfoDialogOpened(), "Info dialog about adding item to cart was not displayed");
        CommonFunctions.attachScreenshot("Info dialog about adding item to cart was opened");
    }


    @And("^user adding vehicle \"([^\"]*)\"$")
    public void userAddingVehicle(String vehicle) throws Throwable {
        makeAppointmentPage.openPage();
        assertTrue(makeAppointmentPage.isPage(), "Appointment page was not opened");
        makeAppointmentPage.selectVehicle(DataProvider.getVehicle(vehicle));
    }

    @And("^user adds to cart tires with SKU \"([^\"]*)\" with \"([^\"]*)\" delivery option for \"([^\"]*)\"$")
    public void userAddsToCartTiresWithIdWithDeliveryOption(String sku, String deliveryOption, String vehicle) throws Throwable {
        mainPage.openPageWithCookies();
        categoriesPage.openCategory("Tires");
        tiresPage.shopForTiresBy("Tires by Vehicle");
        tiresPage.selectVehicle(DataProvider.getVehicle(vehicle));
        tiresPage.addTiresToCart(sku);
    }

    @And("^user continues shopping$")
    public void userContinuesShopping() throws Throwable {
        productPage.clickContinueInAddToCartDialog();
    }

    @And("^user adds to cart any tires with \"([^\"]*)\" delivery option for \"([^\"]*)\"$")
    public void userAddsToCartAnyTiresWithDeliveryOptionFor(String deliveryOption, String vehicle) throws Throwable {
        tiresPage.addSingleTyresToCart();
        productPage.addToCart();

    }

    @And("^user schedules installation time$")
    public void userSchedulesInstallationTime() {
        cartPage.scheduleInstallationTime();
    }

    @After
    public void cleanUp() {
        cartPage.openCartPage();
        cartPage.cleanUpCart();
        if (TestGlobalsManager.getTestGlobal("authorised") != null) {
            mainPage.doLogout();
        }
    }
}
