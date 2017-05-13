package tests.pepboys;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
        features = "src/test/resources/features/pepboys/express_paypal/",
        glue = "steps",
        tags = "@pepBoys"
)
class PepBoysExpressPaypalCukesRunnerTest extends AbstractTestNGCucumberTests {

}