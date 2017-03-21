package steps.pepboys;

import components.pages.pepboys.*;
import components.widgets.*;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.CommonFunctions;
import utils.TestGlobalsManager;
import utils.pepboys.BillingUser;
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

    private AddressFormWidget addressFormWidget = new AddressFormWidget();
    private AddressDisplayWidget addressDisplayWidget = new AddressDisplayWidget();
    private EmailWidget emailWidget = new EmailWidget();
    private ButtonWidget buttonWidget = new ButtonWidget();
    private ErrorMessageWidget errorMessageWidget = new ErrorMessageWidget();
    private BreadcrumbWidget breadcrumbWidget = new BreadcrumbWidget();

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

    @And("^user types billing info for \"([^\"]*)\"$")
    public void typesBillingInfoFor(String userName) {
        fillBillingAndShipping(userName, true);
    }

    @Given("^user types manually billing info for \"([^\"]*)\"$")
    public void userTypesManuallyBillingInfoFor(String userName) {
        fillBillingAndShipping(userName, false);
    }

    @Then("^user checks billing info for \"([^\"]*)\"$")
    public void userChecksBillingInfoFor(String userName) {
        BillingUser user = DataProvider.getUser(userName);
        addressDisplayWidget.checkBillingInfo(
                user.getFullName(),
                user.getApartment(),
                user.getFullAddress(),
                user.getCityInfo(),
                user.getZipCode(),
                user.getPhone(),
                user.getEmail()
        );
    }

    @And("^presses the \"([^\"]*)\" button$")
    public void pressesTheButton(String confirmationMethod) {
        buttonWidget.clickButton();
    }

    @And("^chooses \"([^\"]*)\"$")
    public void chooses(String addressType) {
//        addressFormWidget.chooseAddressType(addressType);
    }

    @And("^chooses \"([^\"]*)\" shipping method$")
    public void choosesShippingMethod(String shippingMethod) {
//        addressFormWidget.selectShippingMethod(shippingMethod);
    }

    @And("^uses \"([^\"]*)\" card for payment$")
    public void usesCardForPayment(String cardName) {
//        addressFormWidget.inputPaymentDetails(DataProvider.getCard(cardName));
//        addressFormWidget.confirmBillingInfo("Place Order");
    }

    @And("^user confirms purchase$")
    public void userConfirmsPurchase() {
//        addressFormWidget.confirmsPurchase();
    }

    @Then("^user should be on thank you page$")
    public void userShouldBeOnThankYouPage() {
//        addressFormWidget.checkPaymentResult();
    }

    @Then("^user stays at billing tab with error message$")
    public void userChecksErrorMessage() {
//        addressFormWidget.checkBillingInfoFormError();
        CommonFunctions.attachScreenshot("Please review all inputs");
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
//        addressFormWidget.doLogin(DataProvider.getUser(userName));
        TestGlobalsManager.setTestGlobal("authorised", true);
    }

    @And("^applies billing info for address \"([^\"]*)\"$")
    public void appliesBillingInfo(String address) {
//        addressFormWidget.applyBillingInfo(address);
    }

    @And("^uses PayPal for payment$")
    public void usesPayPalForPayment() {
//        addressFormWidget.purchaseWithPayPal();
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

//    @Given("^user fills \"([^\"]*)\" in billing info for \"([^\"]*)\"$")
//    public void userFillsInBillingInfoFor(String field, String userName) {
//
//
//    }


    @Given("^user types \"([^\"]*)\" into the \"([^\"]*)\" field$")
    public void userTypesValueIntoField(String value, String field) {
        addressFormWidget.inputValueIntoField(value, field);
        CommonFunctions.attachScreenshot(String.format("Input '%s' into '%s'", value, field));
    }

    @And("^user navigates to \"([^\"]*)\" breadcrumb$")
    public void userNavigatesToBreadcrumb(String breadcrumb) {
        breadcrumbWidget.clickBreadcrumb(breadcrumb);
    }

    @Then("^user checks \"([^\"]*)\" with value \"([^\"]*)\" on \"([^\"]*)\" tab$")
    public void userChecksWithValueOnTab(String field, String value, String breadcrumb) throws Throwable {
        breadcrumbWidget.waitForBreadcrumbActive(breadcrumb);
        addressDisplayWidget.checkFieldValue(field, value);
    }

    @Then("^user checks city info with value \"([^\"]*)\" on \"([^\"]*)\" tab$")
    public void userChecksWithValueOnTab(String value, String breadcrumb) throws Throwable {
        breadcrumbWidget.waitForBreadcrumbActive(breadcrumb);
        addressDisplayWidget.checkCityInfo(value);
    }

    @After
    public void cleanUp() {
        cartPage.openCartPage();
        cartPage.cleanUpCart();
        if (TestGlobalsManager.getTestGlobal("authorised") != null) {
            mainPage.doLogout();
        }
    }

    private void fillBillingAndShipping(String userName, boolean autoFill) {
        BillingUser user = DataProvider.getUser(userName);
        addressFormWidget.fillAddressForm(
                user.getFullName(),
                user.getFullAddress(),
                user.getCityInfo(),
                user.getCity(),
                user.getApartment(),
                user.getPhone(),
                user.getState(),
                user.getZipCode(),
                autoFill
        );

        emailWidget.fillEmailField(user.getEmail());
        CommonFunctions.attachScreenshot("Billing info");
    }

    @Then("^user should stay at \"([^\"]*)\" tab$")
    public void userStaysAtTab(String tabName) {
        assertTrue(breadcrumbWidget.isTabActive(tabName), "Tab " + tabName + " is not an active");
    }

    @And("^sees \"([^\"]*)\" error message with text \"([^\"]*)\"$")
    public void seesErrorMessageWithText(String errorTitle, String errorMessage) {
        errorMessageWidget.checkError(errorTitle, errorMessage);
    }
}


