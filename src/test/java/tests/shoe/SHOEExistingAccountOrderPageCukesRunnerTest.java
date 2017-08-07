package tests.shoe;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features/shoe/existing_account/existing_account_order_page/",
        glue = "steps",
        tags = {"@shoe", "~@Ignored"}
)
class SHOEExistingAccountOrderPageCukesRunnerTest extends AbstractTestNGCucumberTests {

}

