package tests.shoe;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features/shoe/express_paypal",
        glue = "steps",
        tags = {"@shoe", "~@Ignored"}
)
class SHOEExpressPayPalCukesRunnerTest extends AbstractTestNGCucumberTests {

}

