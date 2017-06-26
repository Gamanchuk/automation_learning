package tests.qvc;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
        features = "src/test/resources/features/qvc/speed_buy_from_cart/",
        glue = "steps",
        tags = {"@qvc", "~@Ignored"}
)
class QVCSpeedBuyFromCartCukesRunnerTest extends AbstractTestNGCucumberTests {

}