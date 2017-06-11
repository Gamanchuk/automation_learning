package tests.qvc;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features/qvc/header_and_footer_section",
        glue = "steps"
)
class QVCHeaderAndFooterSectionRunnerTest extends AbstractTestNGCucumberTests {

}

