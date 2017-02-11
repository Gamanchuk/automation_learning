package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import pages.BagWidget;
import pages.PepBoysPage;
import ru.yandex.qatools.allure.annotations.Step;

import static org.testng.Assert.assertTrue;

public class PepBoysPageSteps {


    PepBoysPage pepBoysPage = new PepBoysPage();
    BagWidget bagWidget = new BagWidget();


    @Given("user go to page \"([^\"]*)\"")
    public void goToPage(String page) {
        pepBoysPage.goToPage(page);
        assertTrue(false);
    }


    @And("accept ship to home & add product to bag")
    public void addProductToBag() {
        pepBoysPage.clickShipToHome().clickAddToCard().clickViewCard();
    }


    @And("^user check out with PayPal$")
    public void userCheckOutWithPayPal() throws Throwable {
        pepBoysPage.clickCheckOutWithPayPal();
    }


    @And("^continue pay$")
    public void continuePay() throws Throwable {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       bagWidget.switchToFrame();
       pepBoysPage.clickContinuePay();
    }





}
