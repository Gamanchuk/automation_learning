package entities.pages.pepboys;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import entities.components.ButtonComponent;
import entities.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.CommonFunctions;
import utils.DriverFactory;
import utils.TestGlobalsManager;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class PepBoysCartPage extends BasePage {
    private By payOnline = By.id("j-payOnline");
    private By payInStore = By.id("j-payInStore");
    private By payPal = By.id("j-payPalCheckout");

    private ButtonComponent buttonComponent = new ButtonComponent();
    private int RETRY_COUNT = 1;

    public boolean payUsingPaymentMethod(String method) {
        waitForAjax();

        switch (method) {
            case "Pay Online":
                assertTrue(isElementVisible(payOnline), "Pay Online button doesn't present on page.");
                CommonFunctions.attachScreenshot("Payment method");
                getDriver().findElement(payOnline).click();
                assertTrue(buttonComponent.isExist(), "Button component doesn't present on page. " +
                        "It seems that the checkout did not boot for " + TIMEOUT_SECONDS + " seconds");
                break;
            case "Pay in Store":
                int MAX_RETRY_COUNT = 2;
                if (!isElementVisible(payInStore) && RETRY_COUNT <= MAX_RETRY_COUNT) {
                    CommonFunctions.attachScreenshot("Pay In Store button is missing");
                    log.info("Pay in Store button doesn't present on page. Retrying search products #[ " + RETRY_COUNT + "] .");
                    RETRY_COUNT++;
                    return false;
                } else {
                    assertTrue(isElementVisible(payInStore), "Pay in Store button doesn't present on page.");
                    CommonFunctions.attachScreenshot("Payment method");
                    getDriver().findElement(payInStore).click();
                    RETRY_COUNT = 1;
                    assertTrue(buttonComponent.isExist(), "Button component doesn't present on page. " +
                            "It seems that the checkout did not boot for " + TIMEOUT_SECONDS + " seconds");
                    return true;
                }
            case "PayPal":
                assertTrue(isElementVisible(payPal), "PayPal button doesn't present on page.");
                CommonFunctions.attachScreenshot("Payment method");
                getDriver().findElement(payPal).click();
                break;
            default:
                assertTrue(false, "Error in code. Framework doesn't support this Payment Method: " + method);
        }
        return true;
    }

    public void waitForInstallationDialogToOpen() {
        waitForElementVisible(By.cssSelector("div.modal-dialog"));
    }

    public void moveToNextFiveDays() {
        By nextButton = By.xpath("//button[text()='Next 5 Days >>']");
        waitForElementVisible(nextButton);
        findElement(nextButton).click();
    }

    public void clickEditInstallationTime() {
        click(By.cssSelector("a.scheduleAppointmentLink"));
    }

    public void selectInstallationTime() {
        By latestDay = By.xpath("(//div[@class='dateHeader'])[5]");
        waitForElementVisible(latestDay);
        findElement(latestDay).click();

        String day = findElement(latestDay).findElement(By.cssSelector("div.subDate")).getText();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int year = calendar.get(Calendar.YEAR);

        try {
            Date date = new SimpleDateFormat("MMM d", Locale.ENGLISH).parse(day);
            calendar.setTime(date);
            calendar.set(Calendar.YEAR, year);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

        List<WebElement> availableTimeEls = getDriver().findElements(By.xpath("//div[@data-ur-state='enabled' and @class='dayColumn']//div[contains(@class, 'timeSlotOuter') and not(contains(@class, 'unavailable'))]"));
        if (availableTimeEls.size() > 0) {
            WebElement el = availableTimeEls.get(0);

            String time = el.findElement(By.cssSelector("span.time")).getText();

            calendar.set(Calendar.HOUR, Integer.parseInt(time.split(":")[0]));
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.AM_PM, time.split(" ")[1].equals("AM") ? Calendar.AM : Calendar.PM);

            scrollToElement(el);
            el.click();
        } else {
            // TODO add method to move forward if there's no free time
        }

        TestGlobalsManager.setTestGlobal("installationTime", calendar.getTime());
    }

    public void submitInstallationTime() {
        click(By.xpath("//a[text()='Next']"));
        waitForElementHidden(By.cssSelector("div.modal-dialog"));

    }

    public void cleanUpCart() {
        String script;
        try {
            script = Files.toString(new File("src/main/java/api/pepboys/postRemoveItemFromCart.js"), Charsets.UTF_8);
            script = script.replaceAll("<URL>", BASE_URL);
        } catch (IOException e) {
            log.warn("Cannot read file");
            return;
        }

        ArrayList<String> items = getItemIds();
        for (String item : items) {
            String updated_script = script.replace("<ITEM_ID>", item);
            JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();


            Object retval = js.executeScript(updated_script);
            System.out.println(retval);
        }
    }

    public void openCartPage() {
        getDriver().navigate().to(BASE_URL + "cart");
        assertTrue(isPage(), "Shopping Cart not opened");
    }

    public void clean() {
        getDriver().navigate().to(BASE_URL + "cart/empty");
        CommonFunctions.sleep(5000);
        assertTrue(isPage(), "Cart page doesn't present after cleaning.");
    }

    public boolean isPage() {
        return isElementVisible(By.xpath("//h1[@class='cartTitle']"));
    }

    public boolean isPayInStoreUnavailableMessageDisplayed() {
        return isElementVisible(By.xpath("//div[contains(text(), 'the Pay in Store option is not available')]"), 1);
    }

    public void changeLocation() {
        WebElement changeStore = findElement(By.cssSelector("a.changeTargetStore"));
        scroll(changeStore);
        changeStore.click();
        waitForElementVisible(By.cssSelector("div.modal-dialog"));
        By chooseStoreButton = By.cssSelector("button.j-chooseStore");
        if (isElementVisible(chooseStoreButton)) {
            WebElement chooseStoreButtonEl = findElement(chooseStoreButton);
            String storeId = chooseStoreButtonEl.getAttribute("data-store");
            TestGlobalsManager.setTestGlobal("storeId", storeId);
            chooseStoreButtonEl.click();
        } else {
            // TODO: 12.04.17 Search store by zip code
        }
        waitForElementHidden(By.cssSelector("div.modal-dialog"));
    }

    private ArrayList<String> getItemIds() {
        ArrayList<String> itemIds = new ArrayList<>();

        List<WebElement> items = getDriver().findElements(By.xpath("//tr[contains(@class, 'mw-item-row')]"));
        if (items.size() != 0) {
            for (WebElement item : items) {
                itemIds.add(item.getAttribute("data-itemid"));
            }
        }

        return itemIds;
    }
}
