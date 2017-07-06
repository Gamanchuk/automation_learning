package tests.qvc;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
        features = "src/test/resources/features/qvc/existing_account_payment_page",
        glue = "steps",
        tags = {"@qvc", "~@Ignored"}
)
class QVCExistingAccountPaymentPageCukesRunnerTest extends AbstractTestNGCucumberTests {

}