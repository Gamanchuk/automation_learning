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
    private PepBoysMainPage mainPage = new PepBoysMainPage();
    private PepBoysProductsInCategoryPage productsPage = new PepBoysProductsInCategoryPage();
    private PepBoysCategoriesPage categoriesPage = new PepBoysCategoriesPage();
    private PepBoysProductPage productPage = new PepBoysProductPage();
    private PepBoysCartPage cartPage = new PepBoysCartPage();
    private PepBoysBillingPage billingPage = new PepBoysBillingPage();
    private PepBoysTiresPage tiresPage = new PepBoysTiresPage();

    private CategoriesWidget categoriesWidget = new CategoriesWidget();

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

    @And("^chooses \"([^\"]*)\" method with appointment details$")
    public void userChoosesMethodWithAppointmentDetails(String method) throws Throwable {
        cartPage.payUsingPaymentMethod(method);
    }

    @And("^user types billing info for \"([^\"]*)\"$")
    public void typesBillingInfoFor(String userName) {
        billingPage.inputBillingInfo(DataProvider.getUser(userName));
    }

    @Given("^user types manually billing info for \"([^\"]*)\"$")
    public void userTypesManuallyBillingInfoFor(String userName) {
        billingPage.inputBillingInfoManually(DataProvider.getUser(userName));
    }

    @Then("^user checks billing info for \"([^\"]*)\"$")
    public void userChecksBillingInfoFor(String userName) {
        billingPage.checkBillingInfo(DataProvider.getUser(userName));
    }

    @And("^presses the \"([^\"]*)\" button$")
    public void pressesTheButton(String confirmationMethod) {
        billingPage.confirmBillingInfo(confirmationMethod);
    }

    @And("^chooses \"([^\"]*)\"$")
    public void chooses(String addressType) {
        billingPage.chooseAddressType(addressType);
    }

    @And("^chooses \"([^\"]*)\" shipping method$")
    public void choosesShippingMethod(String shippingMethod) {
        billingPage.selectShippingMethod(shippingMethod);
    }

    @And("^uses \"([^\"]*)\" card for payment$")
    public void usesCardForPayment(String cardName) {
        billingPage.inputPaymentDetails(DataProvider.getCard(cardName));
        billingPage.confirmBillingInfo("Place Order");
    }

    @And("^user confirms purchase$")
    public void userConfirmsPurchase() {
        billingPage.confirmsPurchase();
    }

    @Then("^user should be on thank you page$")
    public void userShouldBeOnThankYouPage() {
        billingPage.checkPaymentResult();
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

    @Given("^user makes authorisation for \"([^\"]*)\"$")
    public void userMakesAuthorisationFor(String userName) {
        billingPage.doLogin(DataProvider.getUser(userName));
    }

    @And("^applies billing info for address \"([^\"]*)\"$")
    public void appliesBillingInfo(String address) {
        billingPage.applyBillingInfo(address);
    }

    @And("^uses PayPal for payment$")
    public void usesPayPalForPayment() {
        billingPage.purchaseWithPayPal();
        CommonFunctions.attachScreenshot("Purchase with PayPal");
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
        categoriesWidget.openCategory("Tires");
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
//        mainPage.openPageWithCookies();
//        categoriesWidget.openCategory("Tires");
//        tiresPage.shopForTiresBy("Tires by Vehicle");
//        tiresPage.selectVehicle(DataProvider.getVehicle(vehicle));
//        tiresPage.addAnyTiresToCart();

        tiresPage.addSingleTyresToCart();
        productPage.addToCart();

    }

    @And("^user schedules installation time$")
    public void userSchedulesInstallationTime() {
        cartPage.scheduleInstallationTime();
    }


}


