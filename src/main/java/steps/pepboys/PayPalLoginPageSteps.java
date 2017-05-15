package steps.pepboys;


import cucumber.api.java.en.And;
import entities.components.PayPalComponent;
import utils.TestGlobalsManager;
import utils.pepboys.BillingUser;
import utils.pepboys.DataProvider;

public class PayPalLoginPageSteps {

    private PayPalComponent payPalComponent = new PayPalComponent();

    @And("^user confirms purchase as \"([^\"]*)\" with PayPal$")
    public void userConfirmsPurchaseAsWithPayPal(String userName) {
        BillingUser user = DataProvider.getUser(userName);

        payPalComponent.doLogin(user);
        payPalComponent.confirmationPay();

        TestGlobalsManager.setTestGlobal("CARDHOLDER", user.getFullName());
        TestGlobalsManager.setTestGlobal("CARDINFO", "PayPal - " + user.getPaypalEmail());
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
