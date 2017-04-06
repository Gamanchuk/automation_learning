package entities.pages.pepboys;

import org.openqa.selenium.By;

public class PepBoysThankYouPage extends PepBoysBasePage {
    public boolean isOnThankYouPage() {
        return isElementPresent(By.xpath("//span[@class='thankmsg' and text()='Thank You for Your Order']"));
    }
}
