import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions (
        features = "src/test/resources/features/",
        glue = "steps",
        tags = "@debug1"
)
class DebugCukesRunnerTest extends AbstractTestNGCucumberTests {

}