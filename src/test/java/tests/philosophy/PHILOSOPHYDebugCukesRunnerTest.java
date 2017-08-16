package tests.philosophy;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features/philosophy/",
        glue = "steps",
        tags = {"@debug", "~@Ignored"}
)
class PHILOSOPHYDebugCukesRunnerTest extends AbstractTestNGCucumberTests {

}

