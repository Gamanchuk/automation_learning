package components.pages.pepboys;

import org.openqa.selenium.By;
import utils.CommonFunctions;

public class PepBoysMainPage extends PepBoysBasePage {

    private By searchBox = By.id("search-site");

    public boolean isPageLoaded() {
        waitForElementVisible(searchBox);
        return true;
    }

    public void navigateMainPage() {
        getDriver().navigate().to(BASE_URL);
        getDriver().navigate().to(BASE_URL);
        waitForElementVisible(By.xpath("//h2[text()='Popular Categories']"));
    }

    public void openMainPage() {
        waitAndClick(By.cssSelector("a.mw-logo"));
    }

    public void openMakeAppointment() {
        getDriver().findElement(By.xpath("//a[text()='Make Appointment']")).click();
        waitForElementPresence(By.cssSelector("button.locationBtn"));
    }

//    private String itemId = null;
//
//    private By searchSubmit = By.id("search-icon");
//    private By checkOutWithPayPalButton = By.id("j-payPalCheckout");
//    private By addToCardButton  = By.xpath("//button[@type='submit']");
//    private By shipToHome;
//    private By cartButton = By.xpath("//span[@class='icm icon-pb-cart']");
//    private By viewCard = By.xpath("//button[contains(text(),'View Cart')]");
//    private By continuePayButton = By.xpath("//button[contains(text(),'Continue')]");
//    private Log log = LogFactory.getLog(this.getClass());
//
//    //Hopkins GoGear Tower Fan 12V
//    //555667
//
//    @Override
//    public boolean isPage() {
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        waitForElementVisible(this.searchBox);
//        return true;
//    }
//
//    public PepBoysMainPage goToPage(String url) {
//        driver.navigate().to(url);
//        assertTrue(this.isPage(), "User is not on main page");
//        return this;
//    }
//
//    public PepBoysMainPage setTextInSearch(String searchText) {
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
//    public PepBoysMainPage submitSearch() {
//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        driver.findElement(this.searchSubmit).click();
//        return this;
//    }
//
//    public PepBoysMainPage clickAddToCard() {
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
//    public PepBoysMainPage clickShipToHome() {
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
//    public PepBoysMainPage clickOnCard() {
//        waitForElementVisible(this.cartButton);
//        driver.findElement(this.cartButton).click();
//        return this;
//    }
//
//
//    public PepBoysMainPage clickViewCard() {
//
//       // waitForElementVisible(this.viewCard);
//        driver.findElement(this.viewCard).click();
//        return this;
//    }
//
//    public PepBoysMainPage clickCheckOutWithPayPal() {
//        waitForElementVisible(this.checkOutWithPayPalButton);
//        driver.findElement(this.checkOutWithPayPalButton).click();
//        return this;
//    }
//
//    public PepBoysMainPage clickContinuePay() {
//        waitForElementVisible(this.continuePayButton);
//        driver.findElement(this.continuePayButton).click();
//        return this;
//    }
}
