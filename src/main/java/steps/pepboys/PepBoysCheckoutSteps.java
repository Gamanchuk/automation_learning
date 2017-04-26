package steps.pepboys;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import entities.components.*;
import entities.pages.pepboys.*;
import utils.CommonFunctions;
import utils.TestGlobalsManager;
import utils.pepboys.BillingUser;
import utils.pepboys.CreditCard;
import utils.pepboys.DataProvider;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static utils.CommonFunctions.attachScreeVideo;
import static utils.DriverFactory.stopScreenVideo;

public class PepBoysCheckoutSteps {

    private PepBoysThankYouPage thankYouPage = new PepBoysThankYouPage();
    private PepBoysPaymentAndReviewCheckoutPage paymentAndReviewPage = new PepBoysPaymentAndReviewCheckoutPage();

    private AddressFormComponent addressFormComponent = new AddressFormComponent();
    private AddressDisplayComponent addressDisplayComponent = new AddressDisplayComponent();
    private AddressVerificationComponent addressVerificationComponent = new AddressVerificationComponent();
    private EmailComponent emailComponent = new EmailComponent();
    private ButtonComponent buttonComponent = new ButtonComponent();
    private ErrorMessageComponent errorMessageComponent = new ErrorMessageComponent();
    private BreadcrumbComponent breadcrumbWidget = new BreadcrumbComponent();
    private ShippingOptionsComponent shippingOptionsComponent = new ShippingOptionsComponent();
    private CreditCardFormComponent creditCardFormComponent = new CreditCardFormComponent();
    private HeaderComponent headerComponent = new HeaderComponent();
    private FooterComponent footerComponent = new FooterComponent();
    private SignInFormComponent signInFormComponent = new SignInFormComponent();
    private RadioListComponent radioListComponent = new RadioListComponent();
    private PaymentTypesComponent paymentTypesComponent = new PaymentTypesComponent();
    private PayPalWellComponent payPalWellComponent = new PayPalWellComponent();
    private CollapserComponent collapserComponent = new CollapserComponent();
    private CheckboxRowComponent checkboxRowComponent = new CheckboxRowComponent();
    private RewardSummaryComponent rewardSummaryComponent = new RewardSummaryComponent();
    private TitleComponent titleComponent = new TitleComponent();
    private ModalComponent modalComponent = new ModalComponent();
    private RewardsAccountComponent rewardsAccountComponent = new RewardsAccountComponent();

    private PepBoysThankYouPage pepBoysThankYouPage = new PepBoysThankYouPage();

    @And("^user types billing info for \"([^\"]*)\"$")
    public void typesBillingInfoFor(String userName) {
        fillBillingInfo(userName, true, true);
    }

    @And("^user types billing info for \"([^\"]*)\" and checks email$")
    public void typesBillingInfoForUserAndChecksEmail(String userName) {
        fillBillingInfo(userName, true, false);
    }

    @And("^user types manually billing info for \"([^\"]*)\" and checks email$")
    public void userTypesManuallyBillingInfoForAndChecksEmail(String userName) {
        fillBillingInfo(userName, false, false);
    }

    @Given("^user types manually billing info for \"([^\"]*)\"$")
    public void userTypesManuallyBillingInfoFor(String userName) {
        fillBillingInfo(userName, false, true);
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

    @And("^presses the \"([^\"]*)\" button$")
    public void pressesTheButton(String confirmationMethod) {
        buttonComponent.javascriptScroll(200);
        buttonComponent.clickButton();
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
    }

    @Then("^user should be on thank you page$")
    public void userShouldBeOnThankYouPage() {
        assertTrue(thankYouPage.isOnThankYouPage(), "User is not on \"Thank You\" page");
        assertTrue(pepBoysThankYouPage.isCollapsed(), "Order collapser not collapsed");
        CommonFunctions.attachScreenshot("Thank You Page");
    }

    @And("^user presses the reschedule link$")
    public void userPressesTheRescheduleLink() {
        PepBoysTrackingPage trackingPage = new PepBoysTrackingPage();
        PepBoysMyAccountPage myAccountPage = new PepBoysMyAccountPage();
        pepBoysThankYouPage.openCollapser();
        pepBoysThankYouPage.clickOnReschedule();
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
        radioListComponent.select(address);
        CommonFunctions.attachScreenshot("Billing info");
    }

    @And("^applies shipping info for address \"([^\"]*)\"$")
    public void appliesShippingInfoForAddress(String address) {
        assertTrue(radioListComponent.exists(), "Billing Address Drop-Down doesn't exist");
        checkboxRowComponent.check("Yes, shipping address and billing address are the same", false);
        radioListComponent.setRoot(BaseComponent.getContainerByTitle("Shipping Address"));
        radioListComponent.select(address);
        CommonFunctions.attachScreenshot("Shipping info");
    }

    @And("^selects \"Enter a New Address\"$")
    public void entersNewAddress() {
        assertTrue(radioListComponent.exists(), "Billing Address Drop-Down doesn't exist");
        radioListComponent.select("Enter a New Address");
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
        breadcrumbWidget.clickBreadcrumb(breadcrumb);
        CommonFunctions.attachScreenshot("Click Breadcrumb: " + breadcrumb);
    }

    @Then("^user checks \"([^\"]*)\" with value \"([^\"]*)\" on \"([^\"]*)\" tab$")
    public void userChecksWithValueOnTab(String field, String value, String breadcrumb) throws Throwable {
        breadcrumbWidget.waitForBreadcrumbActive(breadcrumb);
        addressDisplayComponent.checkFieldValue(field, value);
        CommonFunctions.attachScreenshot("Checks " + field + " on " + breadcrumb + " tab");
    }


    @Then("^user checks phone with value \"([^\"]*)\" on \"([^\"]*)\" tab$")
    public void userChecksPhoneWithValueOnTab(String phone, String breadcrumb) {
        breadcrumbWidget.waitForBreadcrumbActive(breadcrumb);
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
        breadcrumbWidget.waitForBreadcrumbActive(breadcrumb);
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
        breadcrumbWidget.waitForBreadcrumbActive(breadcrumb);
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
    public void userTypesRewardsNumber(String rewardsCode) {
        collapserComponent.openCollapser();
        rewardsAccountComponent.setRewards(rewardsCode);
        CommonFunctions.attachScreenshot("Rewards Number");
    }

    @And("^checks payment details for \"([^\"]*)\"$")
    public void checksPaymentDetails(String userName) {
        payPalWellComponent.checkPayPalAccount(DataProvider.getUser(userName).getPaypalEmail());
    }

    private void fillShipping(String userName, boolean autoFill) {
        addressFormComponent.setRoot(BaseComponent.getContainerByTitle("Shipping Address"));
        BillingUser user = DataProvider.getUser(userName);
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
        CommonFunctions.attachScreenshot("Shipping info");
    }

    @Given("^user types manually shipping info for \"([^\"]*)\"$")
    public void userTypesManuallyShippingInfoFor(String userName) {
        checkboxRowComponent.check("Yes, shipping address and billing address are the same", false);
        fillShippingInfo(userName, false);
    }

    @And("^unset checkbox \"([^\"]*)\"$")
    public void unsetCheckbox(String label) {
        checkboxRowComponent.check(label, false);
    }

    @Given("^user types shipping info for \"([^\"]*)\"$")
    public void userTypesShippingInfoFor(String userName) throws Throwable {
        checkboxRowComponent.check("Yes, shipping address and billing address are the same", false);
        fillShippingInfo(userName, true);
    }


    private void fillBillingInfo(String userName, boolean autoFill, boolean fillEmail) {
        BillingUser user = DataProvider.getUser(userName);
        addressFormComponent.setRoot(BaseComponent.getContainerByTitle("Billing Address"));
        fillAddressForm(user, autoFill);

        if (fillEmail) {
            emailComponent.fillEmailField(user.getEmail());
        } else {
            assertEquals(user.getEmail(), emailComponent.getEmailDisplayValue(), "Unexpected email was used");
        }

        CommonFunctions.attachScreenshot("Billing info");
    }

    private void fillShippingInfo(String userName, boolean autoFill) {
        BillingUser user = DataProvider.getUser(userName);
        addressFormComponent.setRoot(BaseComponent.getContainerByTitle("Shipping Address"));
        fillAddressForm(user, autoFill);
        CommonFunctions.attachScreenshot("Shipping info");
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
        assertTrue(false);
    }

    @Given("^user presses the logo$")
    public void userPressesTheLogo() {
        headerComponent.pressLogoLink();
        CommonFunctions.attachScreenshot("Press the logo link");
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
        //TODO: need found solution for check text in native alert
        //  footerComponent.pressCall();
        //footerComponent.checkCallAlert(phoneNumber);
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
        breadcrumbWidget.waitForBreadcrumbActive(tabName);
        assertTrue(breadcrumbWidget.isTabActive(tabName), "Tab " + tabName + " is not an active");
        CommonFunctions.attachScreenshot("User on [" + tabName + "] tab");
    }

    @And("^user checks \"([^\"]*)\" shipping method$")
    public void userChecksShippingMethod(String method) {
        shippingOptionsComponent.checkShippingOptions(method);

    }

    @Then("^user should be on \"([^\"]*)\" page$")
    public void userShouldBeOnPage(String pageName) {
        assertTrue(titleComponent.exists(pageName), "Unexpected Page Title.");
    }

    @After
    public void after() {
        stopScreenVideo();
        attachScreeVideo("data");
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
        modalComponent.waitForModalToOpen();
        assertTrue(modalComponent.hasMessageWithText(text), "Unexpected text was displayed");
        CommonFunctions.attachScreenshot("Error Modal opened");
    }

    @And("^user clicks Terms link$")
    public void userClicksTermsLink() {
        paymentAndReviewPage.clickTerms();
    }

    @Then("^user should see Terms modal with \"([^\"]*)\"$")
    public void userShouldSeeTermsModalWith(String text) throws Throwable {
        modalComponent.waitForModalToOpen();
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


}
