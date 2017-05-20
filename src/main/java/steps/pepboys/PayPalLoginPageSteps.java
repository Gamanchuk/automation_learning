package steps.pepboys;


import cucumber.api.java.en.And;
import entities.components.PayPalComponent;
import entities.pages.pepboys.PepBoysBasePage;
import entities.pages.pepboys.PepBoysCheckoutPage;
import utils.TestGlobalsManager;
import utils.pepboys.BillingUser;
import utils.pepboys.DataProvider;

public class PayPalLoginPageSteps {

    private PayPalComponent payPalComponent = new PayPalComponent();
    private PepBoysCheckoutPage checkoutPage = new PepBoysCheckoutPage();

    @And("^user confirms purchase as \"([^\"]*)\" with PayPal$")
    public void userConfirmsPurchaseAsWithPayPal(String userName) {
        BillingUser user = DataProvider.getUser(userName);

        payPalComponent.doLogin(user);
        payPalComponent.confirmationPay();

        TestGlobalsManager.setTestGlobal("CARDHOLDER", user.getFullName());
        TestGlobalsManager.setTestGlobal("CARDINFO", "PayPal - " + user.getPaypalEmail());

        checkoutPage.waitForPepBoysPage();
        checkoutPage.checkURL();
    }

    @And("^user logOut from PayPal$")
    public void userLogOutFromPayPal() throws Throwable {
        payPalComponent.logOut();
    }

    @And("^user confirms purchase with PayPal$")
    public void userConfirmsPurchaseWithPayPal() {
        payPalComponent.confirmationPay();
    }
}
