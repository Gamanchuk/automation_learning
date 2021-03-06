package tests.pepboys;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
        features = "src/test/resources/features/pepboys/happy_path/",
        glue = "steps",
        tags = "@pepBoys"
)
class PepBoysHappyPathCukesRunnerTest extends AbstractTestNGCucumberTests {

}