package components.pages.pepboys;

import org.openqa.selenium.By;

public class PepBoysMakeAppointmentPage extends PepBoysBasePage {
    public final String STORE_PATH = "eserve/appointment/";

    private By img = By.cssSelector("img.storeButtonImage");
    private By selectLocationBtn = By.cssSelector("button.locationBtn");


    public boolean isPage() {
        waitForElementClickable(selectLocationBtn);
        //waitForAttributeVisible(img, "src", "https://static.pepboys.com/images/eServe2.0/Location-Selector-Button-Icon-14x20.gif");
       waitForAjax();
        return true;
    }

    public void openPage() {

        navigateWithCookies(BASE_URL + STORE_PATH, COOKIES);
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
