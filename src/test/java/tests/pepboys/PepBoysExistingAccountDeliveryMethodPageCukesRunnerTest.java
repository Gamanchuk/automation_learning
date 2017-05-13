package tests.pepboys;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
        features = "src/test/resources/features/pepboys/existing_account_delivery_method_page/",
        glue = "steps",
        tags = "@pepBoys"
)
class PepBoysExistingAccountDeliveryMethodPageCukesRunnerTest extends AbstractTestNGCucumberTests {

}