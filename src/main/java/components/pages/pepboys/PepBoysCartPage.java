package components.pages.pepboys;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.CommonFunctions;
import utils.DriverFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    public void scheduleInstallationTime() {
        waitForElementVisible(By.xpath("//h4[text()='Schedule Your Installation Time']"));
        waitForElementVisible(By.xpath("(//div[@class='dateHeader'])[5]"));
        getDriver().findElement(By.xpath("(//div[@class='dateHeader'])[5]")).click();

        By availableTime = By.xpath("//div[@data-ur-state='enabled' and @class='dayColumn']//div[contains(@class, 'timeSlotOuter') and not(contains(@class, 'unavailable'))]");
        scrollToElement(getDriver().findElement(availableTime));
        getDriver().findElement(availableTime).click();

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
