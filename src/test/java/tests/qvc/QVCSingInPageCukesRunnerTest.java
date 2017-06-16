package tests.qvc;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features/qvc/sign_into_page",
        glue = "steps",
        tags = {"@qvc", "~@Ignored"}
)
class QVCSingInPageCukesRunnerTest extends AbstractTestNGCucumberTests {

}

