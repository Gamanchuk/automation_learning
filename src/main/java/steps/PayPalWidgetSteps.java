package steps;


import cucumber.api.java.en.And;
import pages.PayPalWidget;
import ru.yandex.qatools.allure.annotations.Step;

import static org.testng.Assert.assertTrue;


public class PayPalWidgetSteps {

    PayPalWidget payPalLoginPage = new PayPalWidget();


    @And("he login on paypal \"([^\"]*)\" , \"([^\"]*)\"")
    public void doLogin(String email, String password) {
        assertTrue(payPalLoginPage.isPage(), "Not pay pal login page");
        payPalLoginPage.switchIFrame();

        payPalLoginPage.setEmail(email).setPassword(password).actionLogin().switchIFrameToDefault();
    }


    @And("he confirmation pay")
    public void confirmPay() {
        //payPalLoginPage.s
        payPalLoginPage.actionContinuePay();
    }

}
