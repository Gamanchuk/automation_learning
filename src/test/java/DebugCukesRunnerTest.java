import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions (
        features = "src/test/resources/feature/",
        glue = "steps",
        tags = "@debug"
)
class DebugCukesRunnerTest extends AbstractTestNGCucumberTests {

}