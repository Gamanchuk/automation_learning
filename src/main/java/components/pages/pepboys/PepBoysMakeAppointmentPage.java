package components.pages.pepboys;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import utils.DriverFactory;

import java.io.File;
import java.io.IOException;

public class PepBoysMakeAppointmentPage extends PepBoysBasePage {
    public final String STORE_PATH = "eserve/appointment/";

    private By img = By.cssSelector("img.storeButtonImage");
    private By selectLocationBtn = By.cssSelector("button.locationBtn");


    public boolean isPage() {
        waitForElementVisible(By.id("locationForm"));
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

    public void setLocationStoreApi() {
        String fileContents = null;
        try {
            fileContents = Files.toString(new File("src/main/java/api/pepboys/postNewStoreLocation.js"), Charsets.UTF_8);
        } catch (IOException e) {
            log.warn("Cannot read file");
        }

        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
        js.executeScript(fileContents);
    }
}
