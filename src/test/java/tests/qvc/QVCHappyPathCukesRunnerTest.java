package tests.qvc;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
        features = "src/test/resources/features/qvc/happy_path/",
        glue = "steps",
        tags = "@qvc"
)
class QVCHappyPathCukesRunnerTest extends AbstractTestNGCucumberTests {

}