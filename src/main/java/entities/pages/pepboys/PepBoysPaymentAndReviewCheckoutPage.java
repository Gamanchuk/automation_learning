package entities.pages.pepboys;

import entities.components.BaseComponent;
import org.openqa.selenium.By;

public class PepBoysPaymentAndReviewCheckoutPage extends PepBoysBasePage {
    public void clickTerms() {
        click(By.xpath("//a[text()='Terms']"));
    }

    public void clickArrowFor(String componentName) {
        waitForElementPresence(By.xpath("//a[text()='Terms']"));
        BaseComponent.getComponentByTitle(componentName).findElement(By.cssSelector("div.display-well-arrow")).click();
    }
}
