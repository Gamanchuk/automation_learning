package tests.qvc;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
        features = "src/test/resources/features/qvc/existing_account_shipping_and_billing_page/",
        glue = "steps",
        tags = {"@qvc", "~@Ignored"}
)
class QVCExistingAccountShippingBillingPageCukesRunnerTest extends AbstractTestNGCucumberTests {

}