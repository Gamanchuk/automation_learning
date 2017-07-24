package tests.saatva;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
        features = "src/test/resources/features/saatva/happy_path/",
        glue = "steps",
        tags = {"@saatva", "~@Ignored"}
)
class SAATVAHappyPathCukesRunnerTest extends AbstractTestNGCucumberTests {

}