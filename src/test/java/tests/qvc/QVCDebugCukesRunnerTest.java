package tests.qvc;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features/qvc/",
        monochrome = true,
        glue = "steps",
        tags = {"@debug", "~@Ignored"}
)
class QVCDebugCukesRunnerTest extends AbstractTestNGCucumberTests {

}

