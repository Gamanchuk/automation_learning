package steps.pepboys;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
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
    private PepBoysForgotPasswordPage forgotPasswordPage = new PepBoysForgotPasswordPage();
    private PepBoysRewardsPage rewardsPage = new PepBoysRewardsPage();
    private PepBoysMyAccountPage myAccountPage = new PepBoysMyAccountPage();
    private PepBoysThankYouPage thankYouPage = new PepBoysThankYouPage();
    private PepBoysTrackingPage trackingPage = new PepBoysTrackingPage();


    @Given("^user makes appoint with code \"([^\"]*)\"$")
    public void userMakesAppointWithCode(String code) {
        makeAppointmentPage.openPage();
        assertTrue(makeAppointmentPage.isPage(), "Appointment page was not opened");
        makeAppointmentPage.selectDifferentLocation(code);

        CommonFunctions.sleep(20000);
        CommonFunctions.attachScreenshot("Store: " + code + " selected");
    }

    @Given("^user makes appoint$")
    public void userMakesAppointWithApi() {
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
    public void userAddsItToTheCartWithDeliveryOption(String deliveryOption) {
        productPage.setDeliveryOption(deliveryOption);
        productPage.addToCart();

        if (!productPage.isInfoDialogOpened()) {
            productPage.addToCart();
        }

        assertTrue(productPage.isInfoDialogOpened(), "Info dialog about adding item to cart was not displayed");
        CommonFunctions.attachScreenshot("Info dialog about adding item to cart was opened");
    }

    @And("^user views cart$")
    public void userViewsCart() {
        productPage.clickViewCartInAddToCartDialog();
        CommonFunctions.attachScreenshot("Cart opened");
    }

    @And("^chooses \"([^\"]*)\" method$")
    public void userChoosesMethod(String method) {
        cartPage.payUsingPaymentMethod(method);
    }

    @And("^chooses \"([^\"]*)\" method with appointment details$")
    public void userChoosesMethodWithAppointmentDetails(String method) {
        cartPage.payUsingPaymentMethod(method);
    }

    @And("^user adds to cart product with id \"([^\"]*)\" with \"([^\"]*)\" delivery option$")
    public void userAddsToCartProductWithIdWithDeliveryOption(String id, String deliveryOption) {
        productPage.openProductPage(id);
        assertTrue(productPage.isPage(), "Product page was not opened");
        productPage.setDeliveryOption(deliveryOption);
        productPage.addToCart();

        assertTrue(productPage.isInfoDialogOpened(), "Info dialog about adding item to cart was not displayed");
        CommonFunctions.attachScreenshot("Info dialog about adding item to cart was opened");
    }

    @And("^user adds to cart product with \"([^\"]*)\" delivery option$")
    public void userAddsToCartProductWithDeliveryOption(String deliveryOption) {
        productPage.openProductPage(DataProvider.getRandomItemId());

        if (deliveryOption.equals("Pick Up in Store")) {
            while (!productPage.isAvailableInStore()) {
                productPage.openProductPage(DataProvider.getRandomItemId());
            }
        }

        productPage.setDeliveryOption(deliveryOption);
        productPage.addToCart();

        if (!productPage.isInfoDialogOpened(30)) {
            productPage.addToCart();
            assertTrue(productPage.isInfoDialogOpened(), "Info dialog about adding item to cart was not displayed");
        }


        CommonFunctions.attachScreenshot("Info dialog about adding item to cart was opened");
    }

    @And("^user adding vehicle \"([^\"]*)\"$")
    public void userAddingVehicle(String vehicle) {
        makeAppointmentPage.openPage();
        assertTrue(makeAppointmentPage.isPage(), "Appointment page was not opened");
        makeAppointmentPage.selectVehicle(DataProvider.getVehicle(vehicle));
    }

    @And("^user adds to cart tires with SKU \"([^\"]*)\" with \"([^\"]*)\" delivery option for \"([^\"]*)\"$")
    public void userAddsToCartTiresWithIdWithDeliveryOption(String sku, String deliveryOption, String vehicle) {
        mainPage.openPageWithCookies();
        categoriesPage.openCategory("Tires");
        tiresPage.shopForTiresBy("Tires by Vehicle");
        tiresPage.selectVehicle(DataProvider.getVehicle(vehicle));
        tiresPage.addTiresToCart(sku);
    }

    @And("^user continues shopping$")
    public void userContinuesShopping() {
        productPage.clickContinueInAddToCartDialog();
    }

    @And("^user adds to cart any tires with \"([^\"]*)\" delivery option for \"([^\"]*)\"$")
    public void userAddsToCartAnyTiresWithDeliveryOptionFor(String deliveryOption, String vehicle) {
        tiresPage.openTiresPage();
        productPage.addToCart();

    }

    @And("^user schedules installation time$")
    public void userSchedulesInstallationTime() {
        cartPage.waitForInstallationDialogToOpen();
        cartPage.selectInstallationTime();
        CommonFunctions.attachScreenshot("Installation time");
        cartPage.submitInstallationTime();
    }

    @And("^user updates installation time$")
    public void userUpdatesInstallationTime() {
        cartPage.clickEditInstallationTime();
        cartPage.waitForInstallationDialogToOpen();
        cartPage.moveToNextFiveDays();
        cartPage.selectInstallationTime();
        CommonFunctions.attachScreenshot("Installation time");
        cartPage.submitInstallationTime();
    }

    @Then("^user should be on Forgot Password page$")
    public void userShouldBeOnForgotPasswordPage() {
        assertTrue(forgotPasswordPage.isPage(), "Unexpected page. Expected page: [Forgot Password page]");
        CommonFunctions.attachScreenshot("Forgot Password page");
    }

    @And("^user should be on rewards page$")
    public void userShouldBeOnRewardsPage() {
        if (TestGlobalsManager.getTestGlobal("authorised") != null) {
            assertTrue(myAccountPage.isPage(), "Unexpected page. Expected page: [MyAccount page 'Rewards tab']");
            CommonFunctions.attachScreenshot("Rewards page");
        } else {
            assertTrue(rewardsPage.isPage(), "Unexpected page. Expected page: [Rewards page]");
            CommonFunctions.attachScreenshot("Rewards page");
        }
    }

    @Then("^user should be on main page$")
    public void userShouldBeOnMainPage() {
        assertTrue(mainPage.isPage(), "Main page was not opened. Or page have some problems with loading");
        CommonFunctions.attachScreenshot("Main page opened");
    }

    @And("^user navigates to cart page$")
    public void userNavigatesToCartPage() {
        cartPage.openCartPage();
    }

    @And("^user should be on cart page$")
    public void userShouldBeOnCartPage() {
        assertTrue(cartPage.isPage(), "Cart page was not opened");
    }


    @And("^clean up cart$")
    public void cleanUpCart() {
        cartPage.openCartPage();
        cartPage.cleanUpCart();
    }

    @And("^checks, that Pay in Store option is available$")
    public void checksThatPayInStoreOptionIsAvailable() {
        while (cartPage.isPayInStoreUnavailableMessageDisplayed()) {
            cartPage.cleanUpCart();
            userAddsToCartProductWithIdWithDeliveryOption(DataProvider.getRandomItemId(), "Ship to Home");
            userViewsCart();
        }
    }

    @And("^user changes store$")
    public void userChangesStore() {
        cartPage.changeLocation();
    }
}
