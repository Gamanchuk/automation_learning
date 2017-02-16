package components.pages.pepboys;

import org.openqa.selenium.By;

public class PepBoysBillingPage extends PepBoysBasePage {
    public void inputBillingInfo() {
        // TODO: move info to configs or smth
        getDriver().findElement(By.id("billing-name")).sendKeys("qa moovweb");
        getDriver().findElement(By.id("billing-address-line1")).sendKeys("123 mission street 10th floor San Francisco CA 94105");
        getDriver().findElement(By.id("billing-tel")).sendKeys("4152011234");
        getDriver().findElement(By.id("billing-email")).sendKeys("qa@moovweb.com");
        click(By.xpath("//button[text()='Continue']"));

        int i = 0;
    }


}
