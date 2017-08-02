package tests.shoe;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features/shoe/guest_order_review/",
        glue = "steps",
        tags = {"@shoe", "~@Ignored"}
)
class SHOEGuestReviewPageCukesRunnerTest extends AbstractTestNGCucumberTests {

}

