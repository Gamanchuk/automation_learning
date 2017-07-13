package steps;


import entities.components.ButtonComponent;
import entities.components.HeaderComponent;

import static entities.Entity.TIMEOUT_SECONDS;
import static org.testng.Assert.assertTrue;

public class BaseSteps {

    private ButtonComponent buttonComponent = new ButtonComponent();
    private HeaderComponent headerComponent = new HeaderComponent();

    public void waitForCheckout() {
        assertTrue(buttonComponent.exists(), "Button component doesn't present on page. " +
                "It seems that the checkout did not boot for " + TIMEOUT_SECONDS + " seconds");
    }

    public void waitForSignIn() {
        assertTrue(headerComponent.signinExists(), "Button component doesn't present on page. " +
                "It seems that the checkout did not boot for " + TIMEOUT_SECONDS + " seconds");
    }
}
