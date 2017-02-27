package components.pages.pepboys;

import org.openqa.selenium.By;
import utils.CommonFunctions;

public class PepBoysMakeAppointmentPage extends PepBoysMainPage {
    private By img = By.cssSelector("img.storeButtonImage");
    private By selectLocationBtn = By.cssSelector("button.locationBtn");


    public boolean isPage() {
        waitForAttributeVisible(img, "src", "https://static.pepboys.com/images/eServe2.0/Location-Selector-Button-Icon-14x20.gif");
        waitForAjax();
        return true;
    }

    public void navigate() {
        getDriver().navigate().to(BASE_URL + STORE_PATH);
        waitForAjax();
        isPage();
    }

    public void navigateWithCookies() {
        getDriver().navigate().to(BASE_URL + STORE_PATH + COOKIES);
        waitForAjax();
        isPage();
    }

    public void selectDifferentLocation(String locationZipCode) {
        By zipCodeField = By.id("zipCode");

        focusOut();
        getDriver().findElement(selectLocationBtn).click();
        waitForElementVisible(zipCodeField);
        waitForAjax();

        getDriver().findElement(zipCodeField).sendKeys(locationZipCode);
        getDriver().findElement(By.cssSelector("button.j-findStores")).click();
        waitForAjax();

        getDriver().findElement(By.cssSelector("button.j-chooseStore")).click();
        waitForAjax();
    }
}
