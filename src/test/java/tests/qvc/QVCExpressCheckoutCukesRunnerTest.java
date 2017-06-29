package tests.qvc;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features/qvc/express_checkout/",
        glue = "steps",
        tags = {"@qvc", "~@Ignored"}
)
class QVCExpressCheckoutCukesRunnerTest extends AbstractTestNGCucumberTests {

}

