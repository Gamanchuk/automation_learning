package tests.philosophy;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features/philosophy/get_started_page",
        glue = "steps",
        tags = {"@philosophy", "~@Ignored"}
)
class PHILOSOPHYGetStartedPageCukesRunnerTest extends AbstractTestNGCucumberTests {

}

