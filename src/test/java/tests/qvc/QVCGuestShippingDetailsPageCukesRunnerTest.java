package tests.qvc;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features/qvc/guest_shipping_details_page/",
        glue = "steps",
        tags = "@qvc"
)
class QVCGuestShippingDetailsPageCukesRunnerTest extends AbstractTestNGCucumberTests {

}

