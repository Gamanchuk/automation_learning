package steps.pepboys;


import cucumber.api.java.en.And;
import entities.components.PayPalComponent;
import utils.pepboys.DataProvider;

public class PayPalLoginPageSteps {

    private PayPalComponent payPalComponent = new PayPalComponent();

    @And("^user confirms purchase as \"([^\"]*)\" with PayPal$")
    public void userConfirmsPurchaseAsWithPayPal(String userName) {
        payPalComponent.doLogin(DataProvider.getUser(userName));
        payPalComponent.confirmationPay();
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
