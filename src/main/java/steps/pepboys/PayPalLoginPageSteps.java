package steps.pepboys;


import components.widgets.PayPalWidget;
import cucumber.api.java.en.And;
import utils.pepboys.DataProvider;

public class PayPalLoginPageSteps{

    private PayPalWidget payPalWidget = new PayPalWidget();

    @And("^user confirms purchase as \"([^\"]*)\" with PayPal$")
    public void userConfirmsPurchaseAsWithPayPal(String userName) {
        payPalWidget.doLogin(DataProvider.getUser(userName));
        payPalWidget.confirmationPay();
    }
}
