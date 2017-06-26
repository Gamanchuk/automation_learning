package tests.qvc;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
        features = "src/test/resources/features/qvc/qvc_existing_account_payment_page.xml",
        glue = "steps",
        tags = {"@qvc", "~@Ignored"}
)
class QVCExistingAccountPaymentPageCukesRunnerTest extends AbstractTestNGCucumberTests {

}