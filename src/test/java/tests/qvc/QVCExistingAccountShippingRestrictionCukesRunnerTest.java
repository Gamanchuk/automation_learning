package tests.qvc;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
        features = "src/test/resources/features/qvc/existing_account_shipping_restrictions/",
        glue = "steps",
        tags = {"@qvc", "~@Ignored"}
)
class QVCExistingAccountShippingRestrictionCukesRunnerTest extends AbstractTestNGCucumberTests {

}