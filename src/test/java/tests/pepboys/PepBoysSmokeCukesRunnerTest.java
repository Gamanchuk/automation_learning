package tests.pepboys;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions (
        features = "src/test/resources/feature/pepboys/",
        glue = "steps",
        tags = "@smoke"
)
class PepBoysSmokeCukesRunnerTest extends AbstractTestNGCucumberTests {

}