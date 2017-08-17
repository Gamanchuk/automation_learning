package tests.philosophy;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features/philosophy/happy_path",
        glue = "steps",
        tags = {"@philosophy", "~@Ignored"}
)
class PHILOSOPHYHappyPathCukesRunnerTest extends AbstractTestNGCucumberTests {

}

