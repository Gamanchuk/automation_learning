package tests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import org.testng.annotations.Test;


@CucumberOptions (
        features = "src/test/resources/feature/ulta/",
        glue = "steps",
        tags = "@testdiary")
class CukesRunnerTest extends AbstractTestNGCucumberTests {

}