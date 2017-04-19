package entities.components;

import org.openqa.selenium.By;

/**
 * Created by vmaksimenko on 05.04.17.
 */
public class ModalComponent extends BaseComponent {

    private By modal = By.cssSelector("div.component.modal");

    public void waitForModalToOpen() {
        waitForElementVisible(modal);
    }

    public boolean hasMessageWithText(String text) {
        String message = findElement(modal).findElement(By.cssSelector("div.message-body p")).getText();
        return message.contains(text);
    }

    public boolean hasText(String text) {
        return isElementVisible(By.xpath("//div[@class='modal-inner' and contains(., '" + text + "')]"));
    }
}