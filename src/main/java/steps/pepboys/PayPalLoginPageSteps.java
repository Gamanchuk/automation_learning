package steps.pepboys;


import components.pages.pepboys.PayPalLoginPage;
import cucumber.api.java.en.And;
import utils.pepboys.DataProvider;

public class PayPalLoginPageSteps{

    private PayPalLoginPage payPalLoginPage = new PayPalLoginPage();

    @And("^user confirms purchase as \"([^\"]*)\" with PayPal$")
    public void userConfirmsPurchaseAsWithPayPal(String userName) {
        payPalLoginPage.doLogin(DataProvider.getUser(userName));
        payPalLoginPage.confirmationPay();
    }
}
