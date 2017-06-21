package steps;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import entities.components.*;
import entities.pages.PaymentAndReviewCheckoutPage;
import entities.pages.ThankYouPage;
import entities.pages.pepboys.PepBoysLoginPage;
import entities.pages.pepboys.PepBoysMainPage;
import entities.pages.pepboys.PepBoysMyAccountPage;
import entities.pages.pepboys.PepBoysTrackingPage;
import org.apache.commons.lang.RandomStringUtils;
import utils.CommonFunctions;
import utils.Config;
import utils.GoogleSheetsHelper;
import utils.TestGlobalsManager;
import utils.pepboys.BillingUser;
import utils.pepboys.CreditCard;
import utils.pepboys.DataProvider;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static org.testng.Assert.*;
import static utils.CommonFunctions.attachScreenVideo;
import static utils.CommonFunctions.stopScreenVideo;

public class CheckoutSteps {

    private ThankYouPage thankYouPage = new ThankYouPage();
    private PaymentAndReviewCheckoutPage paymentAndReviewPage = new PaymentAndReviewCheckoutPage();

    private NoteComponent noteComponent = new NoteComponent();
    private EmailComponent emailComponent = new EmailComponent();
    private TitleComponent titleComponent = new TitleComponent();
    private ModalComponent modalComponent = new ModalComponent();
    private ButtonComponent buttonComponent = new ButtonComponent();
    private HeaderComponent headerComponent = new HeaderComponent();
    private FooterComponent footerComponent = new FooterComponent();
    private DiscountComponent discountComponent = new DiscountComponent();
    private CollapserComponent collapserComponent = new CollapserComponent();
    private RadioListComponent radioListComponent = new RadioListComponent();
    private BreadcrumbComponent breadcrumbWidget = new BreadcrumbComponent();
    private SignInFormComponent signInFormComponent = new SignInFormComponent();
    private PayPalWellComponent payPalWellComponent = new PayPalWellComponent();
    private CheckboxRowComponent checkboxRowComponent = new CheckboxRowComponent();
    private ProductListComponent productListComponent = new ProductListComponent();
    private AddressFormComponent addressFormComponent = new AddressFormComponent();
    private ErrorMessageComponent errorMessageComponent = new ErrorMessageComponent();
    private PaymentTypesComponent paymentTypesComponent = new PaymentTypesComponent();
    private RewardSummaryComponent rewardSummaryComponent = new RewardSummaryComponent();
    private AddressDisplayComponent addressDisplayComponent = new AddressDisplayComponent();
    private CreditCardFormComponent creditCardFormComponent = new CreditCardFormComponent();
    private RewardsAccountComponent rewardsAccountComponent = new RewardsAccountComponent();
    private ShippingOptionsComponent shippingOptionsComponent = new ShippingOptionsComponent();
    private CountrySelectorComponent countrySelectorComponent = new CountrySelectorComponent();
    private AddressVerificationComponent addressVerificationComponent = new AddressVerificationComponent();


    @Given("^user fills email field with \"([^\"]*)\"$")
    public void userFillsEmailFieldWith(String email) {
        signInFormComponent.fillEmail(email);
    }

    @Then("^user should see password field$")
    public void userShouldSeePasswordField() throws Throwable {
        assertTrue(signInFormComponent.isPasswordFieldVisible(), "Password field was not displayed");
        CommonFunctions.attachScreenshot("Password field displayed");
    }

    @And("^user fills password field with \"([^\"]*)\"$")
    public void userFillsPasswordFieldWith(String password) throws Throwable {
        signInFormComponent.fillPassword(password);
    }

    @And("^user checks \"([^\"]*)\" checkbox$")
    public void userChecksCheckbox(String label) {
        checkboxRowComponent.check(label, true);
    }

    @And("^user chooses \"([^\"]*)\" title$")
    public void userChoosesRandomTitle(String title) {
        addressFormComponent.selectTitle(title);
        CommonFunctions.attachScreenshot("Title");
    }

    @And("^user types billing info for \"([^\"]*)\"$")
    public void typesBillingInfoFor(String userName) {
        fillBillingInfo(userName, true, true, false);
    }

    @And("^user types billing info for \"([^\"]*)\" without email$")
    public void userTypesBillingInfoForWithoutEmail(String userName) {
        fillBillingInfo(userName, true, false, false);

    }

    @And("^user types manually billing info for \"([^\"]*)\" without email$")
    public void userTypesManuallyBillingInfoForWithoutEmail(String userName) {
        fillBillingInfo(userName, false, false, false);
    }

    @And("^user types shipping address for \"([^\"]*)\"$")
    public void userTypesShippingInfoForWithoutPhone(String userName) {
        checkboxRowComponent.check("Yes, shipping address and billing address are the same", false);
        fillShippingAddress(userName, true);
        CommonFunctions.attachScreenshot("Shipping address form");
    }

    @And("^user types manually shipping address for \"([^\"]*)\"$")
    public void userTypesManuallyShippingInfoForWithoutPhone(String userName) {
        checkboxRowComponent.check("Yes, shipping address and billing address are the same", false);
        fillShippingAddress(userName, false);
        CommonFunctions.attachScreenshot("Shipping address form");
    }

    @Given("^user types manually shipping info for \"([^\"]*)\"$")
    public void userTypesManuallyShippingInfoFor(String userName) {
        checkboxRowComponent.check("Yes, shipping address and billing address are the same", false);
        fillShippingAddress(userName, false);
        CommonFunctions.attachScreenshot("Shipping address form");
    }

    @And("^user types manually international billing info for \"([^\"]*)\" without email$")
    public void userTypesManuallyInternationalBillingInfoForWithoutEmail(String userName) {
        fillBillingInfo(userName, false, false, false);
    }

    @And("^user types customer info for \"([^\"]*)\"$")
    public void typesCustomerInfoFor(String userName) {
        BillingUser user = DataProvider.getUser(userName);

        addressFormComponent.setRoot(BaseComponent.getContainerByTitle("Customer Information"));
        fillAddressForm(user, true);
        emailComponent.fillEmailField(user.getEmail());
        CommonFunctions.attachScreenshot("Customer info");
    }

    @And("^user types billing info for \"([^\"]*)\" and checks email$")
    public void typesBillingInfoForUserAndChecksEmail(String userName) {
        fillBillingInfo(userName, true, false, true);
    }

    @And("^user types сustomer info for \"([^\"]*)\" and checks email$")
    public void typesСustomerInfoForAndChecksEmail(String userName) {
        fillCustomerInfo(userName, true, false);
    }

    @And("^user types manually billing info for \"([^\"]*)\" and checks email$")
    public void userTypesManuallyBillingInfoForAndChecksEmail(String userName) {
        fillBillingInfo(userName, false, false, true);
    }

    @Given("^user types manually billing info for \"([^\"]*)\"$")
    public void userTypesManuallyBillingInfoFor(String userName) {
        fillBillingInfo(userName, false, true, false);
    }

    @Given("^user types manually customer info for \"([^\"]*)\"$")
    public void userTypesManuallyCustomerInfoFor(String userName) {
        fillCustomerInfo(userName, false, true);
    }

    @Then("^user checks billing info for \"([^\"]*)\" on thank you page$")
    public void userChecksBillingInfoForOnThankYouPage(String userName) {
        this.userShouldBeOnThankYouPage();
        BillingUser user = DataProvider.getUser(userName);
        addressDisplayComponent.checkInfo(
                user.getFullName(),
                user.getApartment(),
                user.getFullAddress(),
                user.getCity(),
                user.getZipCode(),
                user.getPhone()
        );
    }

    @Then("^user checks billing info for \"([^\"]*)\"$")
    public void userChecksBillingInfoFor(String userName) {
        BillingUser user = DataProvider.getUser(userName);
        addressDisplayComponent.setRoot(BaseComponent.getContainerByTitle("Billing Address"));
        addressDisplayComponent.checkInfo(
                user.getFullName(),
                user.getApartment(),
                user.getFullAddress(),
                user.getCity(),
                user.getZipCode(),
                user.getPhone()
        );
        addressDisplayComponent.checkFieldValue("Email", user.getEmail());
    }

    @Then("^user checks customer info for \"([^\"]*)\"$")
    public void userChecksCustomerInfoFor(String userName) {
        BillingUser user = DataProvider.getUser(userName);
        addressDisplayComponent.setRoot(BaseComponent.getContainerByTitle("Customer Information"));
        addressDisplayComponent.checkInfo(
                user.getFullName(),
                user.getApartment(),
                user.getFullAddress(),
                user.getCity(),
                user.getZipCode(),
                user.getPhone()
        );
        addressDisplayComponent.checkFieldValue("Email", user.getEmail());
    }

    @Then("^user checks shipping info for \"([^\"]*)\"$")
    public void userChecksShippingInfoFor(String userName) {
        BillingUser user = DataProvider.getUser(userName);
        String currentTab = breadcrumbWidget.getActiveTab();

        if (currentTab.equals("Delivery Method") || currentTab.equals("Billing & Shipping")) {
            addressDisplayComponent.setRoot(BaseComponent.getContainerByTitle("Shipping Address"));
        } else {
            addressDisplayComponent.setRoot(BaseComponent.getComponentByTitle("Shipping Address"));
        }

        addressDisplayComponent.checkInfo(
                user.getFullName(),
                user.getApartment(),
                user.getFullAddress(),
                user.getCity(),
                user.getZipCode(),
                user.getPhone()
        );
    }

    @SuppressWarnings("unused")
    @And("^presses the \"([^\"]*)\" button$")
    public void pressesTheButton(String confirmationMethod) {
        buttonComponent.javascriptScroll(200);
        buttonComponent.clickButton();

        // Experiment. Trying to fix the problem with "Element is no longer attached to DOM"
        CommonFunctions.sleep(500);
    }

    @And("^chooses \"([^\"]*)\"$")
    public void chooses(String addressType) {
        addressVerificationComponent.chooseAddressType(addressType);
    }

    @And("^chooses \"([^\"]*)\" shipping method$")
    public void choosesShippingMethod(String shippingMethod) {
        shippingOptionsComponent.selectShippingMethod(shippingMethod);
        CommonFunctions.attachScreenshot("Shipping method");
    }


    @And("^user remove product$")
    public void userRemoveProduct() {
        assertTrue(radioListComponent.exists(), "Delivery Method Drop-Down doesn't exist");
        productListComponent.removeProduct();
        CommonFunctions.attachScreenshot("Remove product");
    }

    @And("^chooses \"([^\"]*)\" item quantity$")
    public void choosesItemQuantity(String quantity) {
        assertTrue(radioListComponent.exists(), "Item quantity Drop-Down doesn't exist");
        radioListComponent.select(quantity);
        CommonFunctions.attachScreenshot("Change item quantity: " + quantity);
    }

    @And("^chooses \"([^\"]*)\" country$")
    public void choosesCountry(String country) {
        countrySelectorComponent.select(country);
        CommonFunctions.attachScreenshot("Country selected: " + country);
    }

    @And("^uses \"([^\"]*)\" card for payment$")
    public void usesCardForPayment(String cardName) {
        CreditCard card = DataProvider.getCard(cardName);
        creditCardFormComponent.inputPaymentDetails(
                card.getName(),
                card.getNumber(),
                card.getExpDate(),
                card.getCvv(),
                card.getCardholderName()
        );
        TestGlobalsManager.setTestGlobal("CARDHOLDER", card.getCardholderName());
        TestGlobalsManager.setTestGlobal("CARDINFO", card.getName() + " - " + card.getNumber());
    }

    @And("^uses saved \"([^\"]*)\" card for payment$")
    public void usesSavedCardForPayment(String cardName) {
        CreditCard card = DataProvider.getCard(cardName);
        CommonFunctions.sleep(2000);

        //Select card uses 4 last symbols
        radioListComponent.select(card.getSecureCardData());
        creditCardFormComponent.inputValueIntoField(card.getCvv(), "CVV");

        CommonFunctions.attachScreenshot("Card selected");
        TestGlobalsManager.setTestGlobal("CARDHOLDER", card.getCardholderName());
        TestGlobalsManager.setTestGlobal("CARDINFO", card.getName() + " - " + card.getNumber());
    }

    @Then("^user should be on thank you page$")
    public void userShouldBeOnThankYouPage() {
        assertTrue(thankYouPage.isOnThankYouPage(), "User is not on \"Thank You\" page");
        assertTrue(thankYouPage.isCollapsed(), "Order collapser not collapsed");
        thankYouPage.openCollapser();
        CommonFunctions.attachScreenshot("Thank You Page");

        String project = Config.SITE_NAME;


        if (project.equals("pepboys-stage") || project.equals("pepboys-prod") || project.equals("pepboys-qcv")) {

            String orderNumber = thankYouPage.getOrder();

            String cardHolder = (String) TestGlobalsManager.getTestGlobal("CARDHOLDER");
            String cardInfo = (String) TestGlobalsManager.getTestGlobal("CARDINFO");
            CommonFunctions.saveOrder(orderNumber);
            GoogleSheetsHelper.appendOrder(project, orderNumber, cardHolder, cardInfo);
        }

    }

    @And("^user presses the reschedule link$")
    public void userPressesTheRescheduleLink() {
        PepBoysTrackingPage trackingPage = new PepBoysTrackingPage();
        PepBoysMyAccountPage myAccountPage = new PepBoysMyAccountPage();
        thankYouPage.clickOnReschedule();
        CommonFunctions.attachScreenshot("Click on Reschedule Link");

        if (TestGlobalsManager.getTestGlobal("authorised") != null) {
            assertTrue(myAccountPage.isPage(), "Unexpected page. Expected page: [MyAccount page 'Rewards tab']");
            CommonFunctions.attachScreenshot("Rewards page");
        } else {
            assertTrue(trackingPage.isPage(), "Tracking page not opened");
            CommonFunctions.attachScreenshot("Tracking page opened");
        }
    }

    @Given("^user makes authorisation for \"([^\"]*)\"$")
    public void userMakesAuthorisationFor(String userName) {
        BillingUser user = DataProvider.getUser(userName);
        headerComponent.pressSignInButton();
        assertTrue(signInFormComponent.exist(), "Sign In form component doesn't present");
        signInFormComponent.signIn(user.getEmail(), user.getPassword());
        CommonFunctions.attachScreenshot("Set [" + user.getEmail() + "] email and [" + user.getPassword() + "] password");
        buttonComponent.clickButton();
        TestGlobalsManager.setTestGlobal("authorised", true);
    }

    @And("^applies billing info for address \"([^\"]*)\"$")
    public void appliesBillingInfo(String address) {
        assertTrue(radioListComponent.exists(), "Billing Address Drop-Down doesn't exist");
        radioListComponent.setRoot(BaseComponent.getContainerByTitle("Billing Address"));
        assertTrue(radioListComponent.select(address), "'" + address + "' doesn't present in list");
        CommonFunctions.attachScreenshot("Billing info");
    }

    @And("^applies customer info for address \"([^\"]*)\"$")
    public void appliesCustomerInfo(String address) {
        assertTrue(radioListComponent.exists(), "Customer Information Drop-Down doesn't exist");
        radioListComponent.setRoot(BaseComponent.getContainerByTitle("Customer Information"));
        assertTrue(radioListComponent.select(address), "'" + address + "' doesn't present in list");
        CommonFunctions.attachScreenshot("Customer info");
    }

    @And("^applies shipping info for address \"([^\"]*)\"$")
    public void appliesShippingInfoForAddress(String address) {
        assertTrue(radioListComponent.exists(), "Billing Address Drop-Down doesn't exist");
        checkboxRowComponent.check("Yes, shipping address and billing address are the same", false);
        radioListComponent.setRoot(BaseComponent.getContainerByTitle("Shipping Address"));
        assertTrue(radioListComponent.select(address), "'" + address + "' doesn't present in list");
        CommonFunctions.attachScreenshot("Shipping info");
    }

    @And("^selects \"Enter a New Address\"$")
    public void entersNewAddress() {
        assertTrue(radioListComponent.exists(), "Billing Address Drop-Down doesn't exist");
        assertTrue(radioListComponent.select("Enter a New Address"), "Item 'Enter a New Address' doesn't present in list");
        CommonFunctions.attachScreenshot("Entering new address");
    }

    @And("^selects \"Enter a New Address\" for shipping address$")
    public void entersNewShippingAddress() {
        appliesShippingInfoForAddress("Enter a New Address");
    }

    @And("^uses PayPal for payment$")
    public void usesPayPalForPayment() {
        paymentTypesComponent.purchaseWithPayPal();
        CommonFunctions.attachScreenshot("Purchase with PayPal");
    }

    @And("^uses \"([^\"]*)\" for payment$")
    public void usesForPayment(String type) {
        paymentTypesComponent.purchasePayment();
        CommonFunctions.attachScreenshot("Payment types");
        paymentTypesComponent.choicePaymentType(type);
    }

    @Given("^user types \"([^\"]*)\" into the \"([^\"]*)\" field of \"([^\"]*)\" address form$")
    public void userTypesValueIntoField(String value, String field, String formTitle) {
        addressFormComponent.setRoot(BaseComponent.getContainerByTitle(formTitle));
        addressFormComponent.inputValueIntoField(value, field);
        CommonFunctions.attachScreenshot(String.format("Input '%s' into '%s'", value, field));
    }

    @And("^user navigates to \"([^\"]*)\" breadcrumb$")
    public void userNavigatesToBreadcrumb(String breadcrumb) {
        this.userPressesBreadcrumbTab(breadcrumb);
        this.userShouldBeOnTab(breadcrumb);
    }

    @And("^user presses \"([^\"]*)\" breadcrumb tab$")
    public void userPressesBreadcrumbTab(String breadcrumb) {
        CommonFunctions.sleep(1500);
        breadcrumbWidget.clickBreadcrumb(breadcrumb);
        CommonFunctions.attachScreenshot("Click Breadcrumb: " + breadcrumb);
    }

    @Then("^user checks \"([^\"]*)\" with value \"([^\"]*)\" on \"([^\"]*)\" tab$")
    public void userChecksWithValueOnTab(String field, String value, String breadcrumb) throws Throwable {
        assertTrue(breadcrumbWidget.isBreadcrumbActive(breadcrumb), breadcrumb + " is not present on page.");
        addressDisplayComponent.checkFieldValue(field, value);
        CommonFunctions.attachScreenshot("Checks " + field + " on " + breadcrumb + " tab");
    }


    @Then("^user checks phone with value \"([^\"]*)\" on \"([^\"]*)\" tab$")
    public void userChecksPhoneWithValueOnTab(String phone, String breadcrumb) {
        assertTrue(breadcrumbWidget.isBreadcrumbActive(breadcrumb), breadcrumb + " is not present on page.");
        addressDisplayComponent.checkPhone(phone);
        CommonFunctions.attachScreenshot("Checks phone on " + breadcrumb + " tab");
    }

    @Then("^user checks \"([^\"]*)\" with value \"([^\"]*)\" on thank you page$")
    public void userChecksWithValueOnThankYouPage(String field, String value) {
        this.userShouldBeOnThankYouPage();
        addressDisplayComponent.checkFieldValue(field, value);
        CommonFunctions.attachScreenshot("Checks " + field + " on thank you page");
    }

    @Then("^user checks city info with value \"([^\"]*)\" on \"([^\"]*)\" tab$")
    public void userChecksCityInfoWithValueOnTab(String value, String breadcrumb) {
        assertTrue(breadcrumbWidget.isBreadcrumbActive(breadcrumb), breadcrumb + " is not present on page.");
        addressDisplayComponent.checkCityInfo(value);
        CommonFunctions.attachScreenshot("Checks information on " + breadcrumb);
    }

    @Then("^user checks city info with value \"([^\"]*)\" on thank you page$")
    public void userChecksCityInfoWithValueOnThankYouPage(String value) {
        this.userShouldBeOnThankYouPage();
        addressDisplayComponent.checkCityInfo(value);
        CommonFunctions.attachScreenshot("Checks information on thank you page");
    }

    @And("^user checks phone with value \"([^\"]*)\" on thank you page$")
    public void userChecksPhoneWithValueOnThankYouPage(String value) {
        this.userShouldBeOnThankYouPage();
        addressDisplayComponent.checkPhone(value);
        CommonFunctions.attachScreenshot("Checks information on thank you page");
    }

    @And("^user checks zip code with value \"([^\"]*)\" on thank you page$")
    public void userChecksZipCodeWithValueOnThankYouPage(String value) {
        this.userShouldBeOnThankYouPage();
        addressDisplayComponent.checkZip(value);
        CommonFunctions.attachScreenshot("Checks information on thank you page");

    }

    @Then("^user checks zip code with value \"([^\"]*)\" on \"([^\"]*)\" tab$")
    public void userChecksZipWithValueOnTab(String value, String breadcrumb) {
        assertTrue(breadcrumbWidget.isBreadcrumbActive(breadcrumb), breadcrumb + " is not present on page.");
        addressDisplayComponent.checkZip(value);
        CommonFunctions.attachScreenshot("Checks information on " + breadcrumb);
    }

    @Then("^user should stay at \"([^\"]*)\" tab$")
    public void userStaysAtTab(String tabName) {
        assertTrue(breadcrumbWidget.isTabActive(tabName), "Tab " + tabName + " is not an active");
    }

    @And("^sees \"([^\"]*)\" error message with text \"([^\"]*)\"$")
    public void seesErrorMessageWithText(String errorTitle, String errorMessage) {
        errorMessageComponent.checkError(errorTitle, errorMessage);
    }

    @And("^user types \"([^\"]*)\" into the email field$")
    public void userTypesIntoTheEmailField(String email) {
        emailComponent.fillEmailField(email);
        CommonFunctions.attachScreenshot(String.format("Input '%s' into email field", email));
    }

    @And("^user types rewards number \"([^\"]*)\"$")
    public void userTypesRewardsNumber(String number) {
        collapserComponent.openCollapser();
        rewardsAccountComponent.setRewards(number);
        CommonFunctions.attachScreenshot("Rewards Number");
    }

    @And("^user types rewards number for \"([^\"]*)\"$")
    public void userTypesRewardsNumberFor(String userName) throws Throwable {
        collapserComponent.openCollapser();
        BillingUser user = DataProvider.getUser(userName);
        rewardsAccountComponent.setRewards(user.getRewardsNumber());
        CommonFunctions.attachScreenshot("Rewards Number");
    }

    @And("^checks payment details for \"([^\"]*)\"$")
    public void checksPaymentDetails(String userName) {
        payPalWellComponent.checkPayPalAccount(DataProvider.getUser(userName).getPaypalEmail());
    }

    @And("^unset checkbox \"([^\"]*)\"$")
    public void unsetCheckbox(String label) {
        checkboxRowComponent.check(label, false);
    }

    @Given("^user types shipping info for \"([^\"]*)\"$")
    public void userTypesShippingInfoFor(String userName) {
        checkboxRowComponent.check("Yes, shipping address and billing address are the same", false);
        fillShippingInfo(userName, true);
    }

    @And("^user types domestics shipping info for \"([^\"]*)\" without phone$")
    public void userTypesDomesticsShippingInfoFor(String userName) {
        fillShippingInfo(userName, true);
    }

    @Given("^user types international shipping info for \"([^\"]*)\"$")
    public void userTypesInternationalShippingInfoFor(String userName) {
        fillShippingInfo(userName, true);
    }

    private void fillBillingInfo(String userName, boolean autoFill, boolean fillEmail, boolean checkEmail) {
        BillingUser user = DataProvider.getUser(userName);

        addressFormComponent.setRoot(BaseComponent.getContainerByTitle("Billing Address"));
        fillAddressForm(user, autoFill);

        if (fillEmail) {
            emailComponent.fillEmailField(user.getEmail());
        }

        if (checkEmail) {
            assertEquals(user.getEmail(), emailComponent.getEmailDisplayValue(), "Unexpected email was used");
        }

        CommonFunctions.attachScreenshot("Billing info");
    }

    private void fillCustomerInfo(String userName, boolean autoFill, boolean fillEmail) {
        BillingUser user = DataProvider.getUser(userName);

        addressFormComponent.setRoot(BaseComponent.getContainerByTitle("Customer Information"));
        fillAddressForm(user, autoFill);

        if (fillEmail) {
            emailComponent.fillEmailField(user.getEmail());
        } else {
            assertEquals(user.getEmail(), emailComponent.getEmailDisplayValue(), "Unexpected email was used");
        }

        CommonFunctions.attachScreenshot("Customer info");
    }

    private void fillShippingInfo(String userName, boolean autoFill) {
        BillingUser user = DataProvider.getUser(userName);
        addressFormComponent.setRoot(BaseComponent.getContainerByTitle("Shipping Address"));
        fillAddressForm(user, autoFill);
        CommonFunctions.attachScreenshot("Shipping info");
    }

    private void fillShippingAddress(String userName, boolean autoFill) {
        BillingUser user = DataProvider.getUser(userName);
        addressFormComponent.setRoot(BaseComponent.getContainerByTitle("Shipping Address"));
        addressFormComponent.fillAddress(
                user.getFullName(),
                user.getFullAddress(),
                user.getCityInfo(),
                user.getCity(),
                user.getApartment(),
                user.getState(),
                user.getZipCode(),
                autoFill
        );
    }


    private void fillAddressForm(BillingUser user, boolean autoFill) {
        addressFormComponent.fillAddressForm(
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
    }

    @Given("^failed step$")
    public void failedStep() {
        fail("Fail for debug");
    }

    @Given("^user presses the logo$")
    public void userPressesTheLogo() {
        CommonFunctions.attachScreenshot("Press the logo link");
        headerComponent.pressLogoLink();
    }

    @And("^user logs out from checkout$")
    public void userLogsOutFromCheckout() {
        PepBoysMainPage mainPage = new PepBoysMainPage();
        if (TestGlobalsManager.getTestGlobal("authorised") != null) {
            mainPage.doLogout();
            TestGlobalsManager.setTestGlobal("authorised", false);
        }
    }

    @Given("^user checks text \"([^\"]*)\" in footer$")
    public void userChecksTextInFooter(String note) {
        footerComponent.checkNote(note);
    }

    @Given("^user checks support number with label \"([^\"]*)\" and number \"([^\"]*)\"$")
    public void userChecksSupportNumberWithLabelAndNumber(String phoneLabel, String phoneNumber) {
        footerComponent.checkPhoneNumber(phoneLabel, phoneNumber);
    }

    @And("^user presses the Shopping Cart icon$")
    public void userPressesTheShoppingCartIcon() {
        headerComponent.pressShippingCartIcon();
        CommonFunctions.attachScreenshot("Open Shipping Cart");
    }


    @Then("^user presses the Find out more link$")
    public void userPressesTheFindOutMoreLink() {
        rewardSummaryComponent.clickFindOutMore();
        CommonFunctions.attachScreenshot("Find Out More");
    }

    @Given("^user makes authorisation with \"([^\"]*)\" email and \"([^\"]*)\" password$")
    public void userMakesAuthorisationWithEmailAndPassword(String email, String password) throws Throwable {
        signInFormComponent.signIn(email, password);
        CommonFunctions.attachScreenshot("Set [" + email + "] email and [" + password + "] password");
        buttonComponent.clickButton();
    }

    @And("^user presses the signIn button$")
    public void userPressesTheSignInButton() {
        headerComponent.pressSignInButton();
        assertTrue(signInFormComponent.exist(), "SignIn form component doesn't present");
    }

    @And("^user presses the Forgot Password link$")
    public void userPressesTheForgotPasswordLink() {
        signInFormComponent.pressForgotPasswordLink();
    }


    @And("^user presses the Proceed to Guest Checkout link$")
    public void userPressesTheProceedToGuestCheckoutLink() {
        PepBoysLoginPage loginPage = new PepBoysLoginPage();
        loginPage.proceedToGuestCheckout();

    }

    @Then("^user should be on \"([^\"]*)\" tab$")
    public void userShouldBeOnTab(String tabName) {

        if (tabName.contains("Delivery")) {
            assertTrue(radioListComponent.exists(), "Delivery Method Drop-Down doesn't exist");
        } else {
            assertTrue(breadcrumbWidget.isBreadcrumbActive(tabName), "Tab " + tabName + " is not an active");
        }

        assertTrue(breadcrumbWidget.isTabActive(tabName), "Tab " + tabName + " is not an active");

        CommonFunctions.attachScreenshot("User on [" + tabName + "] tab");
    }

    @And("^user checks \"([^\"]*)\" shipping method$")
    public void userChecksShippingMethod(String method) {
        shippingOptionsComponent.checkShippingOptions(method);

    }

    @Then("^user should be on \"([^\"]*)\" page$")
    public void userShouldBeOnPage(String pageName) {
        assertTrue(titleComponent.exists(pageName),
                "Unexpected Page Title. User should be on "
                        + pageName + ". It looks like the page has not loaded");
    }

    @Then("^user should see \"([^\"]*)\" form$")
    public void userShouldSeeForm(String formTitle) {
        assertTrue(BaseComponent.getContainerByTitle(formTitle).isDisplayed(),
                "Form " + formTitle + " not found");
    }

    @And("^user types \"([^\"]*)\" into \"([^\"]*)\" field of Card Form$")
    public void userTypesIntoFieldOfCardForm(String value, String field) {
        creditCardFormComponent.inputValueIntoField(value, field);
        CommonFunctions.attachScreenshot(String.format("Input '%s' into '%s'", value, field));

    }

    @And("^sees error tooltip with text \"([^\"]*)\"$")
    public void seesErrorTooltipWithText(String error) {
        assertTrue(creditCardFormComponent.hasErrorTooltipWithMessage(error),
                "Tooltip with message \"" + error + "\" not found");
    }

    @And("^sees modal error with text \"([^\"]*)\"$")
    public void seesModalErrorWithText(String text) {
        assertTrue(modalComponent.isModalOpen(), "Modal error doesn't present on page.");
        assertTrue(modalComponent.hasMessageWithText(text), "Unexpected text was displayed");
        CommonFunctions.attachScreenshot("Error Modal opened");
    }

    @And("^user clicks Terms link$")
    public void userClicksTermsLink() {
        paymentAndReviewPage.clickTerms();
    }

    @Then("^user should see Terms modal with \"([^\"]*)\"$")
    public void userShouldSeeTermsModalWith(String text) throws Throwable {
        modalComponent.isModalOpen();
        assertTrue(modalComponent.hasText(text), "Unexpected Terms");
        CommonFunctions.attachScreenshot("Terms Modal opened");
    }

    @And("^user clicks arrow for \"([^\"]*)\"$")
    public void userClicksArrowFor(String componentName) {
        paymentAndReviewPage.clickArrowFor(componentName);
    }

    @And("^user checks installation time$")
    public void userChecksInstallationTime() {
        Date installationDate = (Date) TestGlobalsManager.getTestGlobal("installationTime");
        DateFormat df = new SimpleDateFormat("EEE. MM/dd/yyyy @ h:mm a", Locale.ENGLISH);
        assertEquals(paymentAndReviewPage.getInstallationTime(), df.format(installationDate), "Unexpected installation date");
    }

    @And("^user can expand and collapse Order summary$")
    public void userCanExpandAndCollapseOrderSummary() {
        collapserComponent.setRoot(ModalComponent.getComponentByTitle("Order Summary"));
        collapserComponent.openCollapser();
        assertTrue(new OrderSummaryComponent().isVisible(), "Order Summary in invisible");
    }

    @And("^checks Pick Up in Store info$")
    public void checksPickUpInStoreInfo() {
        paymentAndReviewPage.checkPickUpInStoreInfo();
    }


    @And("^user chooses don't have a reward number$")
    public void userChoosesDonTHaveARewardNumber() {
        collapserComponent.openCollapser();
        checkboxRowComponent.check("Sign up now and GET 50 BONUS POINTS added to your account!", true);
        CommonFunctions.attachScreenshot("Choose 'Don't have a reward number'");
    }

    @And("^user checks rewards number for \"([^\"]*)\"$")
    public void userChecksRewardsNumberFor(String userName) {
        BillingUser user = DataProvider.getUser(userName);
        String actualRewardsNumber = collapserComponent.getCollapserLinkText().split("# ")[1];
        assertEquals(actualRewardsNumber, user.getRewardsNumber(), "Unexpected Rewards Number");
        CommonFunctions.attachScreenshot("Rewards Number");
    }


    @And("^user types gift card with \"([^\"]*)\" number and \"([^\"]*)\" pin code$")
    public void userTypesGiftCardWithNumberAndPinCode(String giftNumber, String pinCode) {
        collapserComponent.openCollapser();
        discountComponent.fillDiscount(giftNumber, pinCode);
        CommonFunctions.attachScreenshot("Discount info");
    }

    @And("^user continue checkout as guest$")
    public void userContinueCheckoutAsGuest() {
        signInFormComponent.fillEmail(RandomStringUtils.randomAlphabetic(10) + "@automationQA.com");
        CommonFunctions.attachScreenshot("Checkout as guest");
    }

    @And("^user continue checkout as \"([^\"]*)\"$")
    public void userContinueCheckoutAs(String userName) {
        BillingUser user = DataProvider.getUser(userName);
        assertTrue(signInFormComponent.exist(), "Sign In form component doesn't present");

        signInFormComponent.fillEmail(user.getEmail());
        buttonComponent.clickButton();
        signInFormComponent.fillPassword(user.getPassword());
        CommonFunctions.attachScreenshot("Checkout as existing user");

    }

    @And("^user presses the Where do I enter my password link$")
    public void userPressesTheWhereDoIEnterMyPasswordLink() {
        signInFormComponent.pressWhereDoIEnterMyPassword();
        CommonFunctions.attachScreenshot("Where do I enter my password");
        assertEquals(signInFormComponent.getContentAboutPasswordFill(), "If you have a QVC Password, you'll enter it on the next screen. If not, you'll enter your address.");
    }

    @And("^user clicks \"([^\"]*)\" link in note$")
    public void userClicksLinkInNote(String linkText) {
        noteComponent.clickLink(linkText);
        CommonFunctions.attachScreenshot(linkText);

    }

    @After
    public void after() {
        stopScreenVideo();
        attachScreenVideo("data");

        File webDriverEventLog = new File("logfile.log");
        CommonFunctions.attachFile("webDriverEventLog", webDriverEventLog);
    }
}