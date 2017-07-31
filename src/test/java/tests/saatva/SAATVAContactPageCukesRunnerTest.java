package tests.saatva;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features/saatva/contact_page",
        glue = "steps",
        tags = {"@saatva", "~@Ignored"}
)
class SAATVAContactPageCukesRunnerTest extends AbstractTestNGCucumberTests {

}

