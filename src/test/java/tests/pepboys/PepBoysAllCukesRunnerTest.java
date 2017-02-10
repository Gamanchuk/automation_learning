package tests.pepboys;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.AllureListener;
import utils.TestListener;


@CucumberOptions (
        features = "src/test/resources/feature/pepboys/",
        glue = "steps")


class PepBoysAllCukesRunnerTest extends AbstractTestNGCucumberTests {

}