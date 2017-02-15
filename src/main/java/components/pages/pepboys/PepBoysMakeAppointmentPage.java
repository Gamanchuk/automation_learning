package components.pages.pepboys;

import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class PepBoysMakeAppointmentPage extends PepBoysMainPage {

    public void selectDifferentLocation(String locationZipCode) {
        By selectLocationBtn = By.cssSelector("button.locationBtn");
        By zipCodeField = By.id("zipCode");
        waitAndClick(selectLocationBtn);
        waitForElementVisible(zipCodeField);

        getDriver().findElement(zipCodeField).sendKeys(locationZipCode);
        getDriver().findElement(By.cssSelector("button.j-findStores")).click();
        waitForElementVisible(By.xpath("//div[contains(text(), 'store near " + locationZipCode + "')]"));

        getDriver().findElement(By.cssSelector("button.j-chooseStore")).click();
        waitForElementVisible(selectLocationBtn);

        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
}
