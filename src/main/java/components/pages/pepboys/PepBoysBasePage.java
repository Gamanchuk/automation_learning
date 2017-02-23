package components.pages.pepboys;

import components.Component;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertTrue;

public abstract class PepBoysBasePage extends Component {
    public final String BASE_URL = "http://mstage.stage.pepboys.com/";
    public final String START_URL = BASE_URL + "?_mwexperienceid=75b123b0-6444-4893-9825-1303473bc59f";

//    private String itemId = null;
//
//    private By searchBox = By.id("search-site");
//    private By searchSubmit = By.id("search-icon");
//    private By checkOutWithPayPalButton = By.id("j-payPalCheckout");
//    private By addToCardButton  = By.xpath("//button[@type='submit']");
//    private By shipToHome;
//    private By cartButton = By.xpath("//span[@class='icm icon-pb-cart']");
//    private By viewCard = By.xpath("//button[contains(text(),'View Cart')]");
//    private By continuePayButton = By.xpath("//button[contains(text(),'Continue')]");
//    private Log log = LogFactory.getLog(this.getClass());

    //Hopkins GoGear Tower Fan 12V
    //555667

//    public PepBoysBasePage goToPage(String url) {
//        driver.navigate().to(url);
//        assertTrue(this.isPage(), "BillingUser is not on main page");
//        return this;
//    }

//    public PepBoysBasePage setTextInSearch(String searchText) {
//
//        log.info("Set text in search field");
//        itemId = searchText;
//        WebElement searchBox = driver.findElement(this.searchBox);
//       // searchBox.click();
//        searchBox.clear();
//        searchBox.sendKeys(searchText);
//        return this;
//    }
//
//    public PepBoysBasePage submitSearch() {
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        driver.findElement(this.searchSubmit).click();
//        return this;
//    }
//
//    public PepBoysBasePage clickAddToCard() {
//        log.info("wait 5 sec");
//        try {
//            Thread.sleep(8000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        log.info(" stop wait 5 sec");
//
//        driver.findElement(this.addToCardButton).click();
//        log.info("Click on radio button");
//        return this;
//    }
//
//    public PepBoysBasePage clickShipToHome() {
//
//        By element  = By.id("radio-PHYSICAL_SHIP-" + itemId);
//
//        try {
//            Thread.sleep(8000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//
//        JavascriptExecutor jse = (JavascriptExecutor)driver;
//        jse.executeScript("scroll(0, 500)"); //y value '250' can be altered
//
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        driver.findElement(element).click();
//        return this;
//    }
//
//    public PepBoysBasePage clickOnCard() {
//        waitForElementVisible(this.cartButton);
//        driver.findElement(this.cartButton).click();
//        return this;
//    }
//
//
//    public PepBoysBasePage clickViewCard() {
//
//       // waitForElementVisible(this.viewCard);
//        driver.findElement(this.viewCard).click();
//        return this;
//    }
//
//    public PepBoysBasePage clickCheckOutWithPayPal() {
//        waitForElementVisible(this.checkOutWithPayPalButton);
//        driver.findElement(this.checkOutWithPayPalButton).click();
//        return this;
//    }
//
//    public PepBoysBasePage clickContinuePay() {
//        waitForElementVisible(this.continuePayButton);
//        driver.findElement(this.continuePayButton).click();
//        return this;
//    }
}
