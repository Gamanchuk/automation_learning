package tests.pepboys;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions (
        features = "src/test/resources/feature/pepboys/",
        glue = "steps.pepboys")
class PepBoysAllCukesRunnerTest extends AbstractTestNGCucumberTests {

}