package steps.pepboys;

import cucumber.api.java.en.Given;
import entities.components.ButtonComponent;
import entities.pages.qvc.QVCCartPage;
import entities.pages.qvc.QVCProductPage;
import utils.CommonFunctions;
import utils.pepboys.DataProvider;

import static entities.Entity.TIMEOUT_SECONDS;
import static org.testng.Assert.assertTrue;

public class QVCPageSteps {

    ButtonComponent buttonComponent = new ButtonComponent();

    QVCProductPage productPage = new QVCProductPage();
    QVCCartPage cartPage = new QVCCartPage();

    @Given("^user adds to cart product$")
    public void userAddsToCartProduct() {
        StringBuilder scuGroup = new StringBuilder(DataProvider.getRandomItemId());
        productPage.setCookies();
        productPage.openPage(scuGroup.toString());
        CommonFunctions.attachScreenshot("Product Page");

        //TODO: return color
        String color = productPage.selectRandomColor();
        CommonFunctions.attachScreenshot("Color selected: " + color);

        productPage.addToCart();
        assertTrue(cartPage.isPage(), "Cart page doesn't present.");

        cartPage.processToCheckout();
        assertTrue(buttonComponent.exists(), "Button component doesn't present on page. " +
                "It seems that the checkout did not boot for " + TIMEOUT_SECONDS + " seconds");
    }
}
