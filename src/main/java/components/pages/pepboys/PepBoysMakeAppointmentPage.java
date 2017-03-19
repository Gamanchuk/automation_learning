package components.pages.pepboys;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import utils.CommonFunctions;
import utils.DriverFactory;
import utils.pepboys.Vehicle;

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

    public void setStoreLocationApi() {
        String fileContents = null;
        try {
            fileContents = Files.toString(new File("src/main/java/api/pepboys/postNewStoreLocation.js"), Charsets.UTF_8);
            fileContents = fileContents.replaceAll("<URL>", BASE_URL);
        } catch (IOException e) {
            log.warn("Cannot read file");
        }

        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
        js.executeScript(fileContents);
    }

    public void selectVehicle(Vehicle vehicle) {
        By addVehicleBtn = By.xpath("//*[text()='Add Vehicle']/..");
        getDriver().findElement(addVehicleBtn).click();

        By modelYearSelect = By.xpath("//select[contains(@class, 'yearSelector')]");
        By makeSelect = By.xpath("//select[contains(@class, 'makeSelector')]");
        By modelSelect = By.xpath("//select[contains(@class, 'modelSelector')]");
        By engineSelect = By.xpath("//select[contains(@class, 'engineSelector')]");

        waitForElementVisible(modelYearSelect);
        new Select(getDriver().findElement(modelYearSelect)).selectByVisibleText(vehicle.getModelYear());
        new Select(getDriver().findElement(makeSelect)).selectByVisibleText(vehicle.getMake());
        new Select(getDriver().findElement(modelSelect)).selectByVisibleText(vehicle.getModel());
        new Select(getDriver().findElement(engineSelect)).selectByVisibleText(vehicle.getEngine());

        CommonFunctions.attachScreenshot("Vehicle config");

        getDriver().findElement(By.xpath("//button[contains(@class, 'j-saveVehicle')]")).click();
    }
}
