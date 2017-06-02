package tests.pepboys;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
        features = "src/test/resources/features/pepboys/sign_in_page/",
        glue = "steps",
        tags = "@pepBoys"
)
class PepBoysSingInPageCukesRunnerTest extends AbstractTestNGCucumberTests {

}