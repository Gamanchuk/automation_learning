package tests.shoe;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features/shoe/guest_payment_page/",
        glue = "steps",
        tags = {"@shoe", "~@Ignored"}
)
class SHOEPaymentPageCukesRunnerTest extends AbstractTestNGCucumberTests {

}

