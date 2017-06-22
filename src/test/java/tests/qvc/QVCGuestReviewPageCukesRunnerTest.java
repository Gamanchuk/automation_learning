package tests.qvc;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features/qvc/guest_review_page/",
        glue = "steps",
        tags = {"@qvc", "~@Ignored"}
)
class QVCGuestReviewPageCukesRunnerTest extends AbstractTestNGCucumberTests {

}

