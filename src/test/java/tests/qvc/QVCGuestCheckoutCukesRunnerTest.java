package tests.qvc;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features/qvc/guest_checkout/",
        glue = "steps",
        tags = "@qvc"
)
class QVCGuestCheckoutCukesRunnerTest extends AbstractTestNGCucumberTests {

}

