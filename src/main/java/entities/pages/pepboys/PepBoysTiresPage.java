package entities.pages.pepboys;

import entities.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import utils.CommonFunctions;
import utils.Config;
import utils.pepboys.Vehicle;

public class PepBoysTiresPage extends BasePage {

    //private final String TIRES_URL = "https://mstage.stage.pepboys.com/tires/details/Hankook/Dynapro%2520RA33/1158139/07923/2015/CHEVROLET/CAPTIVA/0/4-146%2520%25202.4L%2520DOHC/4WD/1/";
    private final String TIRES_URL = Config.BASE_URL + "/tires/details/Falken/ZIEX%2520ZE950/1006386/07923/2015/CHEVROLET/CAPTIVA/0/4-146%2520%25202.4L%2520DOHC/4WD/1";

    public void shopForTiresBy(String option) {
        By optionLink = By.xpath("//a[contains(text(), '" + option + "')]");
        waitForDocumentReady();
        waitForElementVisible(optionLink);
        click(optionLink);
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
        By nextBtn = By.xpath("//button[text()='Next']");
        scrollToElement(getDriver().findElement(nextBtn));
        click(nextBtn);
    }

    public void addTiresToCart(String sku) {
        By addItemToCartBtn = By.xpath("//div[contains(@class,'j-results-item') and contains(., '"+ sku + "')]//button[text()='Add to cart']");
        scrollToElement(getDriver().findElement(addItemToCartBtn));
        click(addItemToCartBtn);
        waitForElementVisible(By.xpath("//h3[text()='Your item(s) have been added to the cart']"));
    }


    public void addAnyTiresToCart() {
        By addItemToCartBtn = By.xpath("(//div[contains(@class,'j-results-item')]//button[text()='Add to cart'])[1]");
        scrollToElement(getDriver().findElement(addItemToCartBtn));
        click(addItemToCartBtn);
        waitForElementVisible(By.xpath("//h3[text()='Your item(s) have been added to the cart']"));
    }

    public void openTiresPage() {
        getDriver().navigate().to(TIRES_URL);
        CommonFunctions.attachScreenshot("Tires page");
//        click(By.xpath("//button[text()='Add to cart']"));
    }

    @Override
    public boolean isPage() {
        return false;
    }
}
