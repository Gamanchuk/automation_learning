import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "steps",
        tags = "@refactoring"
)
class RefactoringCukesRunnerTest extends AbstractTestNGCucumberTests {

}