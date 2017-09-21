package tests.philosophy;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features/philosophy/guest/guest_shipping_page",
        glue = "steps",
        tags = {"@philosophy", "~@Ignored"}
)
class PHILOSOPHYGuestShippingPageCukesRunnerTest extends AbstractTestNGCucumberTests {

}

