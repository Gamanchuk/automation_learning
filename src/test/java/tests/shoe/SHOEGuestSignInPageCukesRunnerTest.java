package tests.shoe;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features/shoe/sign_in_page/",
        glue = "steps",
        tags = {"@shoe", "~@Ignored"}
)
class SHOEGuestSignInPageCukesRunnerTest extends AbstractTestNGCucumberTests {

}

