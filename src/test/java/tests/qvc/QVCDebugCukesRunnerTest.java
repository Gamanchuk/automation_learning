package tests.qvc;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features/qvc/",
        glue = "steps",
        tags = "@debug"
)
class QVCDebugCukesRunnerTest extends AbstractTestNGCucumberTests {

}

