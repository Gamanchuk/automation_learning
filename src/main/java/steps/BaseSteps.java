package steps;


import entities.components.ButtonComponent;
import entities.components.CheckoutMethodsComponent;
import entities.components.HeaderComponent;
import gherkin.formatter.model.Scenario;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.annotations.BeforeTest;

import static entities.Entity.TIMEOUT_SECONDS;
import static org.testng.Assert.assertTrue;

public class BaseSteps {

    private ButtonComponent buttonComponent = new ButtonComponent();
    private HeaderComponent headerComponent = new HeaderComponent();
    private CheckoutMethodsComponent checkoutMethodsComponent = new CheckoutMethodsComponent();

    private static Log log = LogFactory.getLog(BaseSteps.class.getSimpleName());

    public void waitForCheckout() {
        assertTrue(buttonComponent.exists(), "Button component doesn't present on page. " +
                "It seems that the checkout did not boot for " + TIMEOUT_SECONDS + " seconds");
    }

    public void waitForSignIn() {
        assertTrue(headerComponent.signinExists(), "Button component doesn't present on page. " +
                "It seems that the checkout did not boot for " + TIMEOUT_SECONDS + " seconds");
    }

    public void waitForCheckoutMethodsComponent() {
        assertTrue(checkoutMethodsComponent.exists(), "Checkout Methods component doesn't present on page. " +
                "It seems that the checkout did not boot for " + TIMEOUT_SECONDS + " seconds");
    }

    @BeforeTest
    public void before(Scenario scenario) {
        log.info("BeforeTest");

        log.info(scenario.getName());
    }
}
