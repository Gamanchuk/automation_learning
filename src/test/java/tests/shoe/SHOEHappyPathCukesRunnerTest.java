package tests.shoe;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features/shoe/happy_path/",
        glue = "steps",
        tags = {"@shoe", "~@Ignored"}
)
class SHOEHappyPathCukesRunnerTest extends AbstractTestNGCucumberTests {

}

