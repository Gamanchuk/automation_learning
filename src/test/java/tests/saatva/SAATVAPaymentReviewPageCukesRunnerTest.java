package tests.saatva;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features/saatva/payment_review_page/",
        glue = "steps",
        tags = {"@saatva", "~@Ignored"}
)
class SAATVAPaymentReviewPageCukesRunnerTest extends AbstractTestNGCucumberTests {

}

