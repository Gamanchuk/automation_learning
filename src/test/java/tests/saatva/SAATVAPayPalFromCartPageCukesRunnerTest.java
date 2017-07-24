package tests.saatva;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features/saatva/paypal_from_cart_page/",
        glue = "steps",
        tags = {"@saatva", "~@Ignored"}
)
class SAATVAPayPalFromCartPageCukesRunnerTest extends AbstractTestNGCucumberTests {

}

