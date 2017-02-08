package tests;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
        features = "src/test/resources/feature/",
        glue = "steps",
        tags = "@testdiary1")
class CukesRunnerTest extends AbstractTestNGCucumberTests {

}