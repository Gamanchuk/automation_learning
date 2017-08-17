package steps;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import entities.components.*;
import entities.pages.PaymentAndReviewCheckoutPage;
import entities.pages.ThankYouPage;
import entities.pages.pepboys.PepBoysMainPage;
import entities.pages.pepboys.PepBoysMyAccountPage;
import entities.pages.pepboys.PepBoysTrackingPage;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import utils.CommonFunctions;
import utils.Config;
import utils.GoogleSheetsHelper;
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
import static utils.CommonFunctions.attachScreenVideo;
import static utils.CommonFunctions.stopScreenVideo;

public class CheckoutSteps {

    private ThankYouPage thankYouPage = new ThankYouPage();
    private PaymentAndReviewCheckoutPage paymentAndReviewPage = new PaymentAndReviewCheckoutPage();
    private PayPalComponent payPalComponent = new PayPalComponent();
    private TabComponent tabComponent = new TabComponent();
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
    private ShipToStoreComponent shipToStoreComponent = new ShipToStoreComponent();
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
    private SavedOptionPickerComponent savedOptionPickerComponent = new SavedOptionPickerComponent();
    private AddressVerificationComponent addressVerificationComponent = new AddressVerificationComponent();


    @Given("^user fills email field with \"([^\"]*)\"$")
    public void userFillsEmailFieldWith(String email) {
        signInFormComponent.fillEmail(email);
        CommonFunctions.attachScreenshot("Fill email");
    }

    @Then("^user should see password field$")
    public void userShouldSeePasswordField() {
        assertTrue(signInFormComponent.isPasswordFieldVisible(), "Password field was not displayed");
    }

    @And("^user fills password field with \"([^\"]*)\"$")
    public void userFillsPasswordFieldWith(String password) {
        signInFormComponent.fillPassword(password);
        CommonFunctions.attachScreenshot("Fill password");
    }

    @And("^user checks \"([^\"]*)\" checkbox$")
    public void userChecksCheckbox(String label) {
        checkboxRowComponent.check(label, true);
        CommonFunctions.attachScreenshot("Checkbox");
    }

    @And("^user chooses \"([^\"]*)\" title$")
    public void userChoosesRandomTitle(String title) {
        addressFormComponent.selectTitle(title);
        CommonFunctions.attachScreenshot("Title");
    }

    @And("^user types billing info for \"([^\"]*)\"$")
    public void typesBillingInfoFor(String userName) {
        fillBillingInfo(userName, true, true, false, false, false);
    }

    @And("^user types billing info for \"([^\"]*)\" without email$")
    public void userTypesBillingInfoForWithoutEmail(String userName) {
        fillBillingInfo(userName, true, false, false, false, false);
    }

    @And("^user types Canadian billing address for \"([^\"]*)\" without email$")
    public void userTypesCanadianBillingAddressForWithoutEmail(String userName) throws Throwable {
        fillBillingInfo(userName, true, false, false, true, true);
    }

    @And("^user types manually Canadian billing address for \"([^\"]*)\" without email$")
    public void userTypesManuallyCanadianBillingAddressForWithoutEmail(String userName) {
        fillBillingInfo(userName, false, false, false, true, true);
    }

    @And("^user types manually billing info for \"([^\"]*)\" without email$")
    public void userTypesManuallyBillingInfoForWithoutEmail(String userName) {
        fillBillingInfo(userName, false, false, false, false, false);
    }

    @And("^user types shipping address for \"([^\"]*)\"$")
    public void userTypesShippingInfoForWithoutPhone(String userName) {

        String checkBox = "Yes, shipping address and billing address are the same";

        if (checkboxRowComponent.exists(checkBox, 5)) {
            checkboxRowComponent.check(checkBox, false);
        }

        fillShippingAddress(userName, true, false, false);
        CommonFunctions.attachScreenshot("Shipping address form");
    }

    @And("^user types manually shipping address for \"([^\"]*)\"$")
    public void userTypesManuallyShippingInfoForWithoutPhone(String userName) {
        checkboxRowComponent.check("Yes, shipping address and billing address are the same", false);
        fillShippingAddress(userName, false, false, false);
        CommonFunctions.attachScreenshot("Shipping address form");
    }

    @Given("^user types manually shipping info for \"([^\"]*)\"$")
    public void userTypesManuallyShippingInfoFor(String userName) {
        String checkBox = "Yes, shipping address and billing address are the same";

        if (checkboxRowComponent.exists(checkBox, 5)) {
            checkboxRowComponent.check(checkBox, false);
        }

        fillShippingAddress(userName, false);

        CommonFunctions.attachScreenshot("Shipping address form");
    }

    @Given("^user types manually shipping info for \"([^\"]*)\" without email, phone$")
    public void userTypesManuallyShippingInfoForWithoutEmailPhone(String userName) {
        String checkBox = "Yes, shipping address and billing address are the same";

        if (checkboxRowComponent.exists(checkBox, 5)) {
            checkboxRowComponent.check(checkBox, false);
        }

        fillShippingAddress(userName, false, false, false);

        CommonFunctions.attachScreenshot("Shipping address form");
    }

    @And("^user types manually international billing info for \"([^\"]*)\" without email$")
    public void userTypesManuallyInternationalBillingInfoForWithoutEmail(String userName) {
        fillBillingInfo(userName, false, false, false, false, true);
    }

    @And("^user types customer info for \"([^\"]*)\"$")
    public void typesCustomerInfoFor(String userName) {
        BillingUser user = DataProvider.getUser(userName);

        addressFormComponent.setRoot(BaseComponent.getContainerByTitle("Customer Information"));
        fillAddressForm(user, true, false);
        emailComponent.fillEmailField(user.getEmail());
        CommonFunctions.attachScreenshot("Customer info");
    }

    @And("^user types billing info for \"([^\"]*)\" and checks email$")
    public void typesBillingInfoForUserAndChecksEmail(String userName) {
        fillBillingInfo(userName, true, false, true, false, false);
    }

    @And("^user types сustomer info for \"([^\"]*)\" and checks email$")
    public void typesСustomerInfoForAndChecksEmail(String userName) {
        fillCustomerInfo(userName, true, false);
    }

    @And("^user types manually billing info for \"([^\"]*)\" and checks email$")
    public void userTypesManuallyBillingInfoForAndChecksEmail(String userName) {
        fillBillingInfo(userName, false, false, true, false, false);
    }

    @Given("^user types manually billing info for \"([^\"]*)\"$")
    public void userTypesManuallyBillingInfoFor(String userName) {
        fillBillingInfo(userName, false, true, false, false, false);
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

    @Then("^user checks billing info for \"([^\"]*)\" without email$")
    public void userChecksBillingInfoForWithoutEmail(String userName) {
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
        addressFormComponent.setRoot(BaseComponent.getNextComponentByTitle("Shipping Address"));
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
        buttonComponent.clickButton(confirmationMethod);

        // Experiment. Trying to fix the problem with "Element is no longer attached to DOM"
        CommonFunctions.sleep(500);
    }


    @And("^presses the OK, I'll Try Again button$")
    public void pressesTheOKILlTryAgainButton() {
        buttonComponent.clickButton();
        // Experiment. Trying to fix the problem with "Element is no longer attached to DOM"
        CommonFunctions.sleep(500);
    }

    @And("^chooses \"([^\"]*)\"$")
    public void chooses(String addressType) {
        addressVerificationComponent.chooseAddressType(addressType);

        if (addressVerificationComponent.exists(5)) {
            addressVerificationComponent.chooseAddressType(addressType);
        }

        CommonFunctions.attachScreenshot("Address Verification pop-up selection");
    }

    @And("^chooses \"([^\"]*)\" shipping method$")
    public void choosesShippingMethod(String shippingMethod) {
        shippingOptionsComponent.selectShippingMethod(shippingMethod);
        CommonFunctions.attachScreenshot("Shipping method");
    }


    @And("^user remove product$")
    public void userRemoveProduct() {
        assertTrue(radioListComponent.exists(), "Looks like delivery Method Drop-Down doesn't exists");
        productListComponent.removeProduct();
        CommonFunctions.attachScreenshot("Remove product");
    }

    @And("^chooses \"([^\"]*)\" item quantity$")
    public void choosesItemQuantity(String quantity) {
        assertTrue(radioListComponent.exists(), "Item quantity Drop-Down doesn't exists");
        radioListComponent.select(quantity);
        CommonFunctions.attachScreenshot("Change item quantity: " + quantity);
    }

    @And("^chooses \"([^\"]*)\" country$")
    public void choosesCountry(String country) {
        countrySelectorComponent.setRoot(null);
        countrySelectorComponent.select(country);
        CommonFunctions.attachScreenshot("Country selected: " + country);
    }

    @And("^user should see \"([^\"]*)\" shipping country$")
    public void userShouldSeeShippingCountry(String countryTitle) {
        assertTrue(countrySelectorComponent.exists(), "Looks like shipping country drop-down doesn't present on page");
        assertEquals(countrySelectorComponent.getSelectedCountry(), countryTitle, "Default shipping country incorrect.");
    }

    @Then("^user should be see country note with text \"([^\"]*)\"$")
    public void userShouldBeSeeCountryNoteWithText(String note) {
        assertEquals(countrySelectorComponent.getCountryNote(), note, "Country note incorrect.");
    }

    @And("^uses \"([^\"]*)\" card for payment$")
    public void usesCardForPayment(String cardName) {
        CreditCard card = DataProvider.getCard(cardName);
        creditCardFormComponent.setRoot(null);
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

    @And("^user fills \"([^\"]*)\" field from \"([^\"]*)\" card$")
    public void userFillsFieldFrom(String field, String cardName) {
        CreditCard card = DataProvider.getCard(cardName);

        String cardValue = card.getValueByName(field);
        creditCardFormComponent.inputValueIntoField(cardValue, field);

        // Need sleep for screenshot created
        CommonFunctions.sleep(500);
        CommonFunctions.attachScreenshot(String.format("Input '%s' into '%s'", cardValue, field));
    }


    @And("^uses saved \"([^\"]*)\" card for payment$")
    public void usesSavedCardForPayment(String cardName) {
        CreditCard card = DataProvider.getCard(cardName);
        CommonFunctions.sleep(2000);

        //Select card uses 4 last symbols
        //radioListComponent.setRoot(null);
        assertTrue(savedOptionPickerComponent.exists(), "Looks like drop-down with saved cards doesn't present");
        savedOptionPickerComponent.select(card.getFourLastNumbers());

        if (!card.getName().equals("qCard")) {
            creditCardFormComponent.inputValueIntoField(card.getCvv(), "CVV");
        }

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


        if (project.equals("pepboys-prod") || project.equals("qvc-prod") || project.equals("shoe-prod")) {

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

        userPressesTheSignInButton();
        signInFormComponent.signIn(user.getEmail(), user.getPassword());
        CommonFunctions.attachScreenshot("Set [" + user.getEmail() + "] email and [" + user.getPassword() + "] password");
        buttonComponent.clickButton();
        TestGlobalsManager.setTestGlobal("authorised", true);
    }

    @And("^applies billing info for address \"([^\"]*)\"$")
    public void appliesBillingInfo(String address) {

        String checkBox = "Yes, billing address and shipping address are the same";

        if (checkboxRowComponent.exists(checkBox, 5)) {
            checkboxRowComponent.check(checkBox, false);
        }

        assertTrue(radioListComponent.exists(), "Billing Address Drop-Down doesn't exists");
        radioListComponent.setRoot(BaseComponent.getContainerByTitle("Billing Address"));
        assertTrue(radioListComponent.select(address), "'" + address + "' doesn't present in list");
        CommonFunctions.attachScreenshot("Billing info");
    }

    @And("^applies customer info for address \"([^\"]*)\"$")
    public void appliesCustomerInfo(String address) {
        assertTrue(radioListComponent.exists(), "Customer Information Drop-Down doesn't exists");
        radioListComponent.setRoot(BaseComponent.getContainerByTitle("Customer Information"));
        assertTrue(radioListComponent.select(address), "'" + address + "' doesn't present in list");
        CommonFunctions.attachScreenshot("Customer info");
    }

    @And("^applies shipping info for address \"([^\"]*)\"$")
    public void appliesShippingInfoForAddress(String address) {
        String checkBox = "Yes, shipping address and billing address are the same";

        if (checkboxRowComponent.exists(checkBox, 5)) {
            checkboxRowComponent.check(checkBox, false);
        }
        radioListComponent.setRoot(BaseComponent.getContainerByTitle("Shipping Address"));
        assertTrue(radioListComponent.select(address), "'" + address + "' doesn't present in list");
        CommonFunctions.attachScreenshot("Shipping info");
    }

    @And("^selects \"Enter a New Address\"$")
    public void entersNewAddress() {
        assertTrue(radioListComponent.exists(), "Billing Address Drop-Down doesn't exists");
        assertTrue(radioListComponent.select("Enter a New Address"), "Item 'Enter a New Address' doesn't present in list");
        CommonFunctions.attachScreenshot("Entering new address");
    }

    @And("^selects \"Enter a New Address\" for shipping address$")
    public void entersNewShippingAddress() {
        appliesShippingInfoForAddress("Enter a New Address");
    }

    @And("^selects \"Enter a New Address\" for billing address$")
    public void selectsForBillingAddress() {
        appliesBillingInfo("Enter a New Address");
    }

    @And("^uses PayPal for payment$")
    public void usesPayPalForPayment() {
        paymentTypesComponent.purchaseWithPayPal();
        CommonFunctions.attachScreenshot("Purchase with PayPal");
    }

    @And("^uses \"([^\"]*)\" for payment$")
    public void usesForPayment(String type) {
        this.userChoosesForPayment(type);
        paymentTypesComponent.choicePaymentType(type);
    }

    @Given("^user chooses \"([^\"]*)\" for payment$")
    public void userChoosesForPayment(String arg0) {
        paymentTypesComponent.purchasePayment();
        CommonFunctions.attachScreenshot("Payment types");
    }


    @Given("^user types \"([^\"]*)\" into the \"([^\"]*)\" field of \"([^\"]*)\" address form$")
    public void userTypesValueIntoField(String value, String field, String formTitle) {
        addressFormComponent.setRoot(BaseComponent.getContainerByTitle(formTitle));
        addressFormComponent.inputValueIntoField(value, field);
        CommonFunctions.attachScreenshot(String.format("Input '%s' into '%s'", value, field));
    }

    @And("^user types \"([^\"]*)\" into the \"([^\"]*)\" field$")
    public void userTypesIntoTheField(String value, String field) {
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

    @Given("^user presses \"([^\"]*)\" tab$")
    public void userPressesTab(String tabName) {
        tabComponent.clickTab(tabName);
        CommonFunctions.attachScreenshot("Click Tab: " + tabName);
    }

    @Given("^user navigates to \"([^\"]*)\" tab$")
    public void userNavigatesToTab(String tabName) {
        this.userPressesTab(tabName);
        assertTrue(tabComponent.active(tabName), "Tab " + tabName + " is not an active");
        CommonFunctions.attachScreenshot("Tab: " + tabName);
    }

    @And("^user fills find store field with \"([^\"]*)\"$")
    public void userFillsFindStoreFieldWith(String value) {
        shipToStoreComponent.fillField(value);
        CommonFunctions.attachScreenshot("Zip");
    }

    @Then("^user should be see Store results$")
    public void userShouldBeSeeStoreResults() {
        assertTrue(shipToStoreComponent.storeResultPresent(), "Looks like store results not present on page.");
        CommonFunctions.attachScreenshot("Store results");
    }


    @And("^user selects random store$")
    public void userSelectsRandomStore() {
        this.userShouldBeSeeStoreResults();
        shipToStoreComponent.shipTo();
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
        CommonFunctions.attachScreenshot("CheckBox");
    }

    @Given("^user types shipping info for \"([^\"]*)\"$")
    public void userTypesShippingInfoFor(String userName) {
        String checkBox = "Yes, shipping address and billing address are the same";

        if (checkboxRowComponent.exists(checkBox, 5)) {
            checkboxRowComponent.check(checkBox, false);
        }

        fillShippingAddress(userName, true);

        CommonFunctions.attachScreenshot("Shipping address form");
    }

    @Given("^user types shipping info for \"([^\"]*)\" without email, phone$")
    public void userTypesShippingInfoForWithoutEmailPhone(String userName) {
        String checkBox = "Yes, shipping address and billing address are the same";

        if (checkboxRowComponent.exists(checkBox, 5)) {
            checkboxRowComponent.check(checkBox, false);
        }

        fillShippingAddress(userName, true, false, false);
    }

    @Given("^user types shipping info for \"([^\"]*)\" without email$")
    public void userTypesShippingInfoForWithoutEmail(String userName) {
        String checkBox = "Yes, shipping address and billing address are the same";

        if (checkboxRowComponent.exists(checkBox, 5)) {
            checkboxRowComponent.check(checkBox, false);
        }

        fillShippingInfo(userName, true, false, true);
    }


    @Given("^user types manually shipping info for \"([^\"]*)\" without email$")
    public void userTypesManuallyShippingInfoForWithoutEmail(String userName) {
        String checkBox = "Yes, shipping address and billing address are the same";

        if (checkboxRowComponent.exists(checkBox, 5)) {
            checkboxRowComponent.check(checkBox, false);
        }

        fillShippingInfo(userName, false, false, true);
    }

    @And("^user types domestics shipping info for \"([^\"]*)\" without phone$")
    public void userTypesDomesticsShippingInfoFor(String userName) {
        fillShippingInfo(userName, true);
    }

    @Given("^user types international shipping info for \"([^\"]*)\"$")
    public void userTypesInternationalShippingInfoFor(String userName) {
        fillShippingInfo(userName, true);
    }

    private void fillBillingInfo(String userName, boolean autoFill, boolean fillEmail, boolean checkEmail, boolean fillPhone, boolean canadian) {
        BillingUser user = DataProvider.getUser(userName);

        addressFormComponent.setRoot(BaseComponent.getContainerByTitle("Billing Address"));
        fillAddressForm(user, autoFill, canadian);

        if (fillEmail) {
            emailComponent.fillEmailField(user.getEmail());
        }

        if (checkEmail) {
            assertEquals(user.getEmail(), emailComponent.getEmailDisplayValue(), "Unexpected email was used");
        }

        if (fillPhone) {
            addressFormComponent.fillPhone(user.getPhone());
        }

        CommonFunctions.attachScreenshot("Billing info");
    }

    private void fillCustomerInfo(String userName, boolean autoFill, boolean fillEmail) {
        BillingUser user = DataProvider.getUser(userName);

        addressFormComponent.setRoot(BaseComponent.getContainerByTitle("Customer Information"));
        fillAddressForm(user, autoFill, false);

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
        fillAddressForm(user, autoFill, false);
        CommonFunctions.attachScreenshot("Shipping info");
    }

    private void fillShippingInfo(String userName, boolean autoFill, boolean email, boolean phone) {
        BillingUser user = DataProvider.getUser(userName);
        addressFormComponent.setRoot(BaseComponent.getContainerByTitle("Shipping Address"));
        fillAddressForm(user, autoFill, false);
        CommonFunctions.attachScreenshot("Shipping info");
    }

    private void fillShippingAddress(String userName, boolean autoFill, boolean email, boolean phone) {
        BillingUser user = DataProvider.getUser(userName);
        addressDisplayComponent.javascriptScroll(300);
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

    private void fillShippingAddress(String userName, boolean autoFill) {
        BillingUser user = DataProvider.getUser(userName);
        addressDisplayComponent.javascriptScroll(300);
        addressFormComponent.setRoot(BaseComponent.getContainerByTitle("Shipping Address"));
        addressFormComponent.fillAddressForm(
                user.getFullName(),
                user.getFullAddress(),
                user.getCityInfo(),
                user.getCity(),
                user.getApartment(),
                user.getPhone(),
                user.getState(),
                user.getZipCode(),
                autoFill,
                false
        );

        emailComponent.fillEmailField(user.getEmail());
    }


    private void fillAddressForm(BillingUser user, boolean autoFill, boolean canadian) {
        addressFormComponent.fillAddressForm(
                user.getFullName(),
                user.getFullAddress(),
                user.getCityInfo(),
                user.getCity(),
                user.getApartment(),
                user.getPhone(),
                user.getState(),
                user.getZipCode(),
                autoFill,
                canadian
        );
    }

    @Given("^failed step$")
    public void failedStep() {
        footerComponent.getDriver().findElement(By.id("hu2312313123123123123123123123123123i"));
        //fail("Fail for debug");
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
        assertTrue(rewardSummaryComponent.exists(), "Find out more link doesn't present");
        rewardSummaryComponent.clickFindOutMore();
        CommonFunctions.attachScreenshot("Find Out More");
    }

    @Given("^user makes authorisation with \"([^\"]*)\" email and \"([^\"]*)\" password$")
    public void userMakesAuthorisationWithEmailAndPassword(String email, String password) {
        signInFormComponent.signIn(email, password);
        CommonFunctions.attachScreenshot("Set [" + email + "] email and [" + password + "] password");
        buttonComponent.clickButtonWithSendKeys();
    }

    @And("^user presses the signIn button$")
    public void userPressesTheSignInButton() {
        headerComponent.pressSignInButton();
        assertTrue(signInFormComponent.exists(), "Sign In form component doesn't present");
    }

    @And("^user presses the Forgot Password link$")
    public void userPressesTheForgotPasswordLink() {
        signInFormComponent.pressForgotPasswordLink();
    }


    @And("^user presses the Proceed to Guest Checkout link$")
    public void userPressesTheProceedToGuestCheckoutLink() {
        signInFormComponent.proceedToGuestCheckout();

    }

    @Then("^user should be on \"([^\"]*)\" tab$")
    public void userShouldBeOnTab(String tabName) {
        assertTrue(breadcrumbWidget.active(tabName), "Tab " + tabName + " is not an active");
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
        CommonFunctions.attachScreenshot("Tooltip");
    }

    @And("^sees modal error with text \"([^\"]*)\"$")
    public void seesModalErrorWithText(String text) {
        assertTrue(modalComponent.isModalOpen(), "Modal error doesn't present on page.");
        assertTrue(modalComponent.hasMessageWithText(text), "Unexpected text was displayed");
        CommonFunctions.attachScreenshot("Error Modal opened");
    }

    @And("^sees modal with title \"([^\"]*)\"$")
    public void seesModalWithTitle(String text) {
        assertTrue(modalComponent.isModalOpen(), "Modal error doesn't present on page.");
        assertEquals(titleComponent.getTitleText().toLowerCase(), text.toLowerCase());
        CommonFunctions.attachScreenshot("Error Modal opened");
    }

    @And("^user close modal$")
    public void userCloseModal() {
        assertTrue(modalComponent.isModalOpen(), "Modal error doesn't present on page.");
        assertTrue(modalComponent.isCloseButtonPresent(), "Modal doesn't have close button.");
    }

    @And("^user clicks Terms link$")
    public void userClicksTermsLink() {
        paymentAndReviewPage.clickTerms();
    }

    @Then("^user should see Terms modal with \"([^\"]*)\"$")
    public void userShouldSeeTermsModalWith(String text) {
        assertTrue(modalComponent.isModalOpen(), "Modal error doesn't present on page.");
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
        CommonFunctions.attachScreenshot("Collapser");
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
        assertTrue(signInFormComponent.exists(), "Sign In form component doesn't present");

        signInFormComponent.fillEmail(user.getEmail());
        buttonComponent.clickButtonWithSendKeys();
        signInFormComponent.fillPassword(user.getPassword());
        CommonFunctions.attachScreenshot("Checkout as existing user");

    }

    @Given("^user fill contact details as \"([^\"]*)\"$")
    public void userFillContactDetails(String userName) {

        addressFormComponent.setRoot(BaseComponent.getComponentByTitle("Contact Details"));
        emailComponent.setRoot(BaseComponent.getNextComponentByTitle("Contact Details"));

        BillingUser user = DataProvider.getUser(userName);

        String name = user.getFullName();
        String email = user.getEmail();

        addressFormComponent.inputValueIntoField(name, "Full Name");
        emailComponent.fillEmailField(email);
        CommonFunctions.attachScreenshot("Contact information");

        addressFormComponent.setRoot(null);
        emailComponent.setRoot(null);
    }

    @And("^user presses the Where do I enter my password link$")
    public void userPressesTheWhereDoIEnterMyPasswordLink() {
        signInFormComponent.pressWhereDoIEnterMyPassword();
        CommonFunctions.attachScreenshot("Where do I enter my password");
    }

    @Then("^user checks notes with text \"([^\"]*)\"$")
    public void userChecksNotesWithText(String note) {
        assertEquals(signInFormComponent.getContentAboutPasswordFill(), note);
        CommonFunctions.attachScreenshot("Content");
    }

    @And("^user clicks \"([^\"]*)\" link in note$")
    public void userClicksLinkInNote(String linkText) {
        noteComponent.clickLink(linkText);
        CommonFunctions.attachScreenshot(linkText);

    }

    @And("^selects \"Enter a New Card\"$")
    public void selectsEnterANewCard() {
        savedOptionPickerComponent.select("Enter a New Card");
    }

    @And("^user selects \"([^\"]*)\" Payment Option$")
    public void userSelectsPaymentOption(String options) {
        this.userShouldBeSeePaymentOption();
        radioListComponent.select(options);
        CommonFunctions.attachScreenshot("Payment Options");
    }

    @And("^user should be see Payment Option$")
    public void userShouldBeSeePaymentOption() {
        radioListComponent.setRoot(BaseComponent.getNextElementByTitle("Payment Options"));
        assertTrue(radioListComponent.exists(), "Payment Options radio list doesn't present on page");
    }

    @After
    public void after() {
        stopScreenVideo();
        attachScreenVideo("data");
    }

    @Then("^user should see \"([^\"]*)\" products$")
    public void userShouldSeeProducts(int count) {
        assertEquals(productListComponent.getCountProducts(), count, "Unexpected count product");
        CommonFunctions.attachScreenshot("Product count");
    }

    @Given("^user presses the \"([^\"]*)\" link$")
    public void userPressesTheLink(String linkTitle) {
        thankYouPage.clickLinkByTitle(linkTitle);
        CommonFunctions.attachScreenshot("Clicked on link: " + linkTitle);
    }

    @And("^user should see payment option component$")
    public void userShouldSeePaymentOptionComponent() {
        assertTrue(radioListComponent.exists(), "Radio List Does Not Present On Page");
    }

    @And("^user types shipping address for \"([^\"]*)\" with phone number$")
    public void userTypesShippingAddressForWithPhoneNumber(String userName) {
        fillShippingInfo(userName, true);
    }


    @And("^user types manually billing info for \"([^\"]*)\" with phone number$")
    public void userTypesManuallyBillingInfoForWithPhoneNumber(String userName) {
        fillBillingInfo(userName, false, false, false, true, false);
    }

    @And("^user types manually shipping info for \"([^\"]*)\" with phone number$")
    public void userTypesManuallyShippingInfoForWithPhoneNumber(String userName) {
        fillShippingAddress(userName, false, false, true);
    }

    @And("^selects \"([^\"]*)\" state$")
    public void selectState(String state) {
        addressFormComponent.setRoot(null);
        addressFormComponent.fillState(state);
        CommonFunctions.attachScreenshot("State selected: " + state);
    }

    @And("^user can expand and collapse Order summary on Thank You page$")
    public void userCanExpandAndCollapseOrderSummaryOnThankYouPage() {
        collapserComponent.setRoot(ModalComponent.getComponentByTitle("Order"));
        collapserComponent.openCollapser();
        assertTrue(new OrderSummaryComponent().isVisible(), "Order Summary in invisible");
        CommonFunctions.attachScreenshot("Collapser");
    }
}
