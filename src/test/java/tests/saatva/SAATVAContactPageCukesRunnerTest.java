package tests.saatva;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features/saatva/",
        glue = "steps",
        tags = {"@debug", "~@Ignored"}
)
class SAATVAContactPageCukesRunnerTest extends AbstractTestNGCucumberTests {

}

