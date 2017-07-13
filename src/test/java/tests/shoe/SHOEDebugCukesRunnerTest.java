package tests.shoe;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features/shoe/",
        glue = "steps",
        tags = {"@debug", "~@Ignored"}
)
class SHOEDebugCukesRunnerTest extends AbstractTestNGCucumberTests {

}

