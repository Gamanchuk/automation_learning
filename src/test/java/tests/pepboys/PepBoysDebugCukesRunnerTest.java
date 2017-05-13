package tests.pepboys;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features/pepboys/",
        glue = "steps",
        tags = "@debug"
)
class PepBoysDebugCukesRunnerTest extends AbstractTestNGCucumberTests {

}