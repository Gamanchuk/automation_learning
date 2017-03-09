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

public class PepBoysTiresPage extends PepBoysBasePage {

    public void shopForTiresBy(String option) {
        By optionLink = By.xpath("//a[contains(text(), '" + option + "')]");
        waitForAjax();
        waitForElementVisible(optionLink);
        getDriver().findElement(optionLink).click();
    }

    public void selectVehicle(Vehicle vehicle) {
        By modelYearSelect = By.xpath("//select[contains(@class, 'yearSelector')]");
        By makeSelect = By.xpath("//select[contains(@class, 'makeSelector')]");
        By modelSelect = By.xpath("//select[contains(@class, 'modelSelector')]");
        By engineSelect = By.xpath("//select[contains(@class, 'engineSelector')]");
        By drivetrainSelect = By.xpath("//select[contains(@class, 'drivetrainSelector')]");
        By trimSelect = By.xpath("//select[contains(@class, 'trimSelector')]");


        waitForElementVisible(modelYearSelect);
        new Select(getDriver().findElement(modelYearSelect)).selectByVisibleText(vehicle.getModelYear());
        new Select(getDriver().findElement(makeSelect)).selectByVisibleText(vehicle.getMake());
        new Select(getDriver().findElement(modelSelect)).selectByVisibleText(vehicle.getModel());
        new Select(getDriver().findElement(engineSelect)).selectByVisibleText(vehicle.getEngine());
        new Select(getDriver().findElement(drivetrainSelect)).selectByVisibleText(vehicle.getDrivetrain());
        new Select(getDriver().findElement(trimSelect)).selectByVisibleText(vehicle.getTrim());

        CommonFunctions.attachScreenshot("Vehicle config");

        focusOut();
        click(By.xpath("//button[text()='Next']"));
    }

    public void addTiresToCart(String sku) {
        By addItemToCartBtn = By.xpath("//div[contains(@class,'j-results-item') and contains(., '"+ sku + "')]//button[text()='Add to cart']");
        waitForElementClickable(addItemToCartBtn);
        click(addItemToCartBtn);

        int i = 0;
        waitForElementVisible(By.xpath("//h3[text()='Your item(s) have been added to the cart']"));

//        getDriver().findElement(addItemToCartBtn).click();
    }

}
