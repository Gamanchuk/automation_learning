package components.pages.pepboys;

import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class PepBoysMakeAppointmentPage extends PepBoysMainPage {

    public void selectDifferentLocation(String locationZipCode) {
        By selectLocationBtn = By.cssSelector("button.locationBtn");
        By zipCodeField = By.id("zipCode");
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
