package tests.pepboys;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions (
        features = "src/test/resources/features/pepboys/",
        glue = "steps.pepboys",
        tags = "@regression"
)
class PepBoysGuestShippingBillingPageCukesRunnerTest extends AbstractTestNGCucumberTests {

}