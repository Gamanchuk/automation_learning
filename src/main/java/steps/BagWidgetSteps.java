package steps;

import cucumber.api.java.en.Given;
import pages.BagWidget;

import static org.testng.Assert.assertTrue;

public class BagWidgetSteps {

    BagWidget bagWidget = new BagWidget();


    @Given("the user go to page \"([^\"]*)\"")
    public void goToPage(String page) {
        bagWidget.goToPage(page);
    }

    @Given("assert \"([^\"]*)\"")
    public void assertSet(boolean flag) {
       assertTrue(flag);
    }

}
