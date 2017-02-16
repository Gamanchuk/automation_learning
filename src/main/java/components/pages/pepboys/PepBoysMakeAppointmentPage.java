package components.pages.pepboys;

import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class PepBoysMakeAppointmentPage extends PepBoysMainPage {

    public void selectDifferentLocation(String locationZipCode) {
        By selectLocationBtn = By.cssSelector("button.locationBtn");
        By img = By.cssSelector("img.storeButtonImage");
        By zipCodeField = By.id("zipCode");

        waitForAttributeVisible(img,"src","https://static.pepboys.com/images/eServe2.0/Location-Selector-Button-Icon-14x20.gif");

        waitForImageLoaded(By.cssSelector("img.storeButtonImage"));
        click(selectLocationBtn);
        waitForElementVisible(zipCodeField);

        getDriver().findElement(zipCodeField).sendKeys(locationZipCode);
        click(By.cssSelector("button.j-findStores"));
        waitForElementVisible(By.xpath("//div[contains(text(), 'store near " + locationZipCode + "')]"));

        click(By.cssSelector("button.j-chooseStore"));
        waitForElementVisible(selectLocationBtn);

        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}
