package entities.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonFunctions;

public class ModalComponent extends BaseComponent {

    private By modal = By.cssSelector("div.component.modal");
    private By modalClose = By.className("modal-close");

    public boolean isModalOpen() {
        return isElementPresent(modal);
    }

    public boolean isCloseButtonPresent() {
        return isElementVisible(modalClose);
    }

    public void closeModal() {
        getDriver().findElement(modalClose).click();
    }

    public boolean hasMessageWithText(String text) {
        // Need hard sleep. iPhone have problems
        // Sometimes Element is no longer attached to the DOM
        CommonFunctions.sleep(4000);
        WebElement modalEl = getDriver().findElement(modal);
        String message = modalEl.findElement(By.cssSelector("div.message-body")).getText();
        return message.contains(text);
    }

    public boolean hasText(String text) {
        return isElementVisible(By.xpath("//div[@class='modal-inner' and contains(., '" + text + "')]"));
    }
}
