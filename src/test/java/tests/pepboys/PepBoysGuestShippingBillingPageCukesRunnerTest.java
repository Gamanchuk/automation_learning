package tests.pepboys;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions (
        features = "src/test/resources/features/pepboys/guest_shipping_and_billing_page/",
        glue = "steps",
        tags = "@pepBoys"
)
class PepBoysGuestShippingBillingPageCukesRunnerTest extends AbstractTestNGCucumberTests {

}