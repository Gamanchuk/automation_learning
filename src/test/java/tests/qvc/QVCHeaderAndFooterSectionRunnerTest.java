package tests.qvc;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features/qvc/guest_shipping_and_billing_page/header_and_footer",
        glue = "steps"
)
class QVCHeaderAndFooterSectionRunnerTest extends AbstractTestNGCucumberTests {

}

