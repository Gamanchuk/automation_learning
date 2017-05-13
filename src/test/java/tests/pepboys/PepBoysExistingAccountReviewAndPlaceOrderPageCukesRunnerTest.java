package tests.pepboys;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
        features = "src/test/resources/features/pepboys/existing_account_review_and_place_order_page/",
        glue = "steps",
        tags = "@pepBoys"
)
class PepBoysExistingAccountReviewAndPlaceOrderPageCukesRunnerTest extends AbstractTestNGCucumberTests {

}