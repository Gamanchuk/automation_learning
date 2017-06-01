package steps.pepboys;

import cucumber.api.java.en.Given;
import entities.components.ButtonComponent;
import entities.pages.qvc.QVCCartPage;
import entities.pages.qvc.QVCProductPage;
import utils.CommonFunctions;
import utils.pepboys.DataProvider;

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

        String color = productPage.selectRandomColor();
        CommonFunctions.attachScreenshot("Color selected: " + color);

        productPage.addToCart();
        assertTrue(cartPage.isPage(), "Cart page");

        cartPage.processToCheckout();
        assertTrue(buttonComponent.exists(), "Cart page");
    }
}
