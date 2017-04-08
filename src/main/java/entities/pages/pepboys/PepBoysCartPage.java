package entities.pages.pepboys;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.CommonFunctions;
import utils.DriverFactory;
import utils.TestGlobalsManager;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PepBoysCartPage extends PepBoysBasePage {

    public void payUsingPaymentMethod(String method) {
        if (method.equals("Pay Online")) {
            click(By.id("j-payOnline"));
        } else if (method.equals("PayPal")) {
            click(By.id("j-payPalCheckout"));
        } else if (method.equals("Pay in Store")) {
            click(By.id("j-payInStore"));
        }

        CommonFunctions.attachScreenshot("Payment method");

        if (method.equals("Pay Online")) {
            waitForElementVisible(By.xpath("//button[text()='Continue']"));
            waitForElementClickable(By.xpath("//button[text()='Continue']"));
        }
    }

    public void waitForInstallationDialogToOpen() {
        waitForElementVisible(By.xpath("//h4[text()='Schedule Your Installation Time']"));
    }

    public void moveToNextFiveDays() {
        findElement(By.xpath("//button[text()='Next 5 Days >>']"));
    }

    public void clickEditInstallationTime() {
        click(By.cssSelector("a.scheduleAppointmentLink"));
    }

    public void selectInstallationTime() {
        waitForElementVisible(By.xpath("(//div[@class='dateHeader'])[1]"));

        // We are going to install tires in 3 days
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 3);
        date = calendar.getTime();

        DateFormat df = new SimpleDateFormat("EEE", Locale.ENGLISH);
        String dateOfWeek = df.format(date);
        findElement(By.xpath("//div[@class='dateHeader' and contains(., '" + dateOfWeek + "')]")).click();

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

        TestGlobalsManager.setTestGlobal("installationName", calendar.getTime());
    }

    public void submitInstallationTime() {
        click(By.xpath("//a[text()='Next']"));
    }

    public void cleanUpCart() {
        String script = null;
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

    private ArrayList<String> getItemIds() {
        ArrayList<String> itemIds = new ArrayList<>();

        List<WebElement> items = getDriver().findElements(By.xpath("//tr[contains(@class, 'mw-item-row')]"));
        if(items.size() != 0) {
            for (WebElement item : items) {
                itemIds.add(item.getAttribute("data-itemid"));
            }
        }

        return itemIds;
    }

    public void openCartPage() {
        getDriver().navigate().to(BASE_URL + "cart");
        waitForElementVisible(By.xpath("//h1[@class='cartTitle']"));
    }
}
