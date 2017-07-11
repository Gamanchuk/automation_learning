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

public class PepBoysPageSteps {

    PepBoysCartPage pepBoysCartPage = new PepBoysCartPage();
    PepBoysMainPage pepBoysMainPage = new PepBoysMainPage();
    PepBoysTiresPage pepBoysTiresPage = new PepBoysTiresPage();
    PepBoysProductPage pepBoysProductPage = new PepBoysProductPage();
    PepBoysRewardsPage pepBoysRewardsPage = new PepBoysRewardsPage();
    PepBoysMyAccountPage pepBoysMyAccountPage = new PepBoysMyAccountPage();
    PepBoysCategoriesPage pepBoysCategoriesPage = new PepBoysCategoriesPage();
    PepBoysForgotPasswordPage pepBoysForgotPasswordPage = new PepBoysForgotPasswordPage();
    PepBoysMakeAppointmentPage pepBoysMakeAppointmentPage = new PepBoysMakeAppointmentPage();
    PepBoysProductsInCategoryPage pepBoysProductsInCategoryPage = new PepBoysProductsInCategoryPage();

    private String DELIVERY_OPTIONS;


    @Given("^user makes appoint with code \"([^\"]*)\"$")
    public void userMakesAppointWithCode(String code) {
        pepBoysMakeAppointmentPage.openPage();
        assertTrue(pepBoysMakeAppointmentPage.isPage(), "Appointment page was not opened");
        pepBoysMakeAppointmentPage.selectDifferentLocation(code);

        CommonFunctions.sleep(20000);
        CommonFunctions.attachScreenshot("Store: " + code + " selected");
    }

    @Given("^user makes appoint$")
    public void userMakesAppointWithApi() {
        pepBoysMakeAppointmentPage.openPage();
        assertTrue(pepBoysMakeAppointmentPage.isPage(), "Appointment page was not opened");
        pepBoysMakeAppointmentPage.setStoreLocationApi();
    }

    @When("^user selects \"([^\"]*)\"$")
    public void userSelectsProduct(String productName) {
        pepBoysCategoriesPage.openCategory("Accessories");
        pepBoysCategoriesPage.openCategory("Exterior Accessories");
        pepBoysCategoriesPage.openCategory("Body Protection");
        pepBoysProductsInCategoryPage.openProductByName(productName);
        CommonFunctions.attachScreenshot("Opened '" + productName + "' page");
    }

    @And("^adds it to the cart with \"([^\"]*)\" delivery option$")
    public void userAddsItToTheCartWithDeliveryOption(String deliveryOption) {
        pepBoysProductPage.setDeliveryOption(deliveryOption);
        pepBoysProductPage.addToCart();

        if (!pepBoysProductPage.isInfoDialogOpened()) {
            pepBoysProductPage.addToCart();
        }

        assertTrue(pepBoysProductPage.isInfoDialogOpened(), "Info dialog about adding item to cart was not displayed");
        CommonFunctions.attachScreenshot("Info dialog about adding item to cart was opened");
    }

    @And("^user views cart$")
    public void userViewsCart() {
        pepBoysProductPage.clickViewCartInAddToCartDialog();
        CommonFunctions.attachScreenshot("Cart opened");
    }

    @And("^chooses \"([^\"]*)\" method$")
    public void userChoosesMethod(String method) {
        boolean result = pepBoysCartPage.payUsingPaymentMethod(method);

        if (!result) {
            pepBoysCartPage.clean();
            userAddsToCartProductWithDeliveryOption(DELIVERY_OPTIONS);
            userViewsCart();
            pepBoysCartPage.payUsingPaymentMethod(method);
        }
    }

    @And("^chooses \"([^\"]*)\" method with appointment details$")
    public void userChoosesMethodWithAppointmentDetails(String method) {
        pepBoysCartPage.payUsingPaymentMethod(method);
    }

    @And("^user adds to cart product with id \"([^\"]*)\" with \"([^\"]*)\" delivery option$")
    public void userAddsToCartProductWithIdWithDeliveryOption(String id, String deliveryOption) {
        pepBoysProductPage.openProduct(id);

        pepBoysProductPage.setDeliveryOption(deliveryOption);
        pepBoysProductPage.addToCart();

        if (!pepBoysProductPage.isInfoDialogOpened(30)) {
            pepBoysProductPage.addToCart();
            assertTrue(pepBoysProductPage.isInfoDialogOpened(), "Info dialog about adding item to cart was not displayed");
        }

        CommonFunctions.attachScreenshot("Info dialog about adding item to cart was opened");
    }

    @And("^user adds to cart product with \"([^\"]*)\" delivery option$")
    public void userAddsToCartProductWithDeliveryOption(String deliveryOption) {
        DELIVERY_OPTIONS = deliveryOption;
        StringBuilder scuGroup = new StringBuilder(DataProvider.getRandomItem());
        pepBoysProductPage.openProduct(scuGroup.toString());

        if (deliveryOption.equals("Pick Up in Store")) {

            int i = 0;
            while (!pepBoysProductPage.isAvailableInStore()) {
                if (i == 3) {
                    assertTrue(false, "We get four random product: [" + scuGroup + "]. " +
                            "But this products unavailable for Pick Up in Store");
                }

                String scu = DataProvider.getRandomItem();
                scuGroup.append(", ").append(scu);
                pepBoysProductPage.openProduct(scu);
                i++;
            }
        }

        pepBoysProductPage.setDeliveryOption(deliveryOption);
        pepBoysProductPage.addToCart();

        if (!pepBoysProductPage.isInfoDialogOpened(30)) {
            pepBoysProductPage.addToCart();
            assertTrue(pepBoysProductPage.isInfoDialogOpened(), "Info dialog about adding item to cart was not displayed");
        }

        CommonFunctions.attachScreenshot("Info dialog about adding item to cart was opened");
    }

    @And("^user adding vehicle \"([^\"]*)\"$")
    public void userAddingVehicle(String vehicle) {
        pepBoysMakeAppointmentPage.openPage();
        assertTrue(pepBoysMakeAppointmentPage.isPage(), "Appointment page was not opened");
        pepBoysMakeAppointmentPage.selectVehicle(DataProvider.getVehicle(vehicle));
    }

    @And("^user adds to cart tires with SKU \"([^\"]*)\" with \"([^\"]*)\" delivery option for \"([^\"]*)\"$")
    public void userAddsToCartTiresWithIdWithDeliveryOption(String sku, String deliveryOption, String vehicle) {
        pepBoysMainPage.openPageWithCookies();
        pepBoysCategoriesPage.openCategory("Tires");
        pepBoysTiresPage.shopForTiresBy("Tires by Vehicle");
        pepBoysTiresPage.selectVehicle(DataProvider.getVehicle(vehicle));
        pepBoysTiresPage.addTiresToCart(sku);
    }

    @And("^user continues shopping$")
    public void userContinuesShopping() {
        pepBoysProductPage.clickContinueInAddToCartDialog();
    }

    @And("^user adds to cart any tires with \"([^\"]*)\" delivery option for \"([^\"]*)\"$")
    public void userAddsToCartAnyTiresWithDeliveryOptionFor(String deliveryOption, String vehicle) {
        pepBoysTiresPage.openTiresPage();
        pepBoysProductPage.addToCart();
    }

    @And("^user schedules installation time$")
    public void userSchedulesInstallationTime() {
        pepBoysCartPage.waitForInstallationDialogToOpen();
        pepBoysCartPage.selectInstallationTime();
        CommonFunctions.attachScreenshot("Installation time");
        pepBoysCartPage.submitInstallationTime();
    }

    @And("^user updates installation time$")
    public void userUpdatesInstallationTime() {
        pepBoysCartPage.clickEditInstallationTime();
        pepBoysCartPage.waitForInstallationDialogToOpen();
        pepBoysCartPage.moveToNextFiveDays();
        pepBoysCartPage.selectInstallationTime();
        CommonFunctions.attachScreenshot("Installation time");
        pepBoysCartPage.submitInstallationTime();
    }

    @Then("^user should be on Forgot Password page$")
    public void userShouldBeOnForgotPasswordPage() {
        assertTrue(pepBoysForgotPasswordPage.isPage(), "Unexpected page. Expected page: [Forgot Password page]");
        CommonFunctions.attachScreenshot("Forgot Password page");
    }

    @And("^user should be on rewards page$")
    public void userShouldBeOnRewardsPage() {
        if (TestGlobalsManager.getTestGlobal("authorised") != null) {
            assertTrue(pepBoysMyAccountPage.isPage(), "Unexpected page. Expected page: [MyAccount page 'Rewards tab']");
            CommonFunctions.attachScreenshot("Rewards page");
        } else {
            assertTrue(pepBoysRewardsPage.isPage(), "Unexpected page. Expected page: [Rewards page]");
            CommonFunctions.attachScreenshot("Rewards page");
        }
    }

    @Then("^user should be on main page$")
    public void userShouldBeOnMainPage() {
        assertTrue(pepBoysMainPage.isPage(), "Main page was not opened. Or page have some problems with loading");
        CommonFunctions.attachScreenshot("Main page opened");
    }

    @And("^user navigates to cart page$")
    public void userNavigatesToCartPage() {
        pepBoysCartPage.openCartPage();
    }

    @And("^user should be on cart page$")
    public void userShouldBeOnCartPage() {
        assertTrue(pepBoysCartPage.isPage(), "Cart page was not opened");
    }


    @And("^clean up cart$")
    public void cleanUpCart() {
        pepBoysCartPage.openCartPage();
        pepBoysCartPage.cleanUpCart();
    }

    @And("^checks, that Pay in Store option is available$")
    public void checksThatPayInStoreOptionIsAvailable() {
        while (pepBoysCartPage.isPayInStoreUnavailableMessageDisplayed()) {
            pepBoysCartPage.cleanUpCart();
            userAddsToCartProductWithIdWithDeliveryOption(DataProvider.getRandomItem(), "Ship to Home");
            userViewsCart();
        }
    }

    @And("^user changes store$")
    public void userChangesStore() {
        pepBoysCartPage.changeLocation();
    }
}
