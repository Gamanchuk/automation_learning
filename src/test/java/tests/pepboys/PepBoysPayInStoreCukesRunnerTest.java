package tests.pepboys;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
        features = "src/test/resources/features/pepboys/pay_in_store/",
        glue = "steps",
        tags = "@pepBoys"
)
class PepBoysPayInStoreCukesRunnerTest extends AbstractTestNGCucumberTests {

}