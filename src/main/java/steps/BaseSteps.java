package steps;


import entities.components.ButtonComponent;

import static entities.Entity.TIMEOUT_SECONDS;
import static org.testng.Assert.assertTrue;

public class BaseSteps {

    private ButtonComponent buttonComponent = new ButtonComponent();

    public void waitForCheckout() {
        assertTrue(buttonComponent.exists(), "Button component doesn't present on page. " +
                "It seems that the checkout did not boot for " + TIMEOUT_SECONDS + " seconds");
    }
}
