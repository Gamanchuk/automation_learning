package entities.pages.shoe;


import entities.pages.BasePage;
import org.openqa.selenium.By;
import utils.CommonFunctions;
import utils.Config;

public class SHOECheckoutPage extends BasePage {

    private By loginForm = By.id("atg_store_accountLogin");


    @Override
    public boolean isPage() {
        return isElementVisible(loginForm) && isElementClickable(loginForm);
    }

    public void processToCheckout() {

        CommonFunctions.sleep(3000);

        String currentUrl = getDriver().getCurrentUrl();
        String url = String.format("%s&%s", currentUrl, COOKIES);

        if (Config.PR_NUMBER != null && !Config.PR_NUMBER.isEmpty()) {
            url += String.format("%s", Config.PR_NUMBER);
        }

        if (Config.PR_NUMBER != null && Config.PR_LOADER) {
            url += String.format("%s", Config.PR_LOADER);
        }

        log.info("Modified url: " + url);

        getDriver().navigate().to(url);
    }
}
