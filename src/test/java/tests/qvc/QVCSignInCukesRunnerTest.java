package tests.qvc;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
        features = "src/test/resources/features/qvc/sign_into_existing_account/",
        glue = "steps",
        tags = "@qvc"
)
class QVCSignInCukesRunnerTest extends AbstractTestNGCucumberTests {

}