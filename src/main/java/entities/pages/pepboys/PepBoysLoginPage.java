package entities.pages.pepboys;

import org.openqa.selenium.By;

public class PepBoysLoginPage extends PepBoysBasePage {

    public void proceedToGuestCheckout() {
        getDriver().findElement(By.xpath("//div[@class='guest-checkout-link']//a")).click();
    }
}
