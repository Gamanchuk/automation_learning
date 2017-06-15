package entities.components;

import org.openqa.selenium.By;
import utils.CommonFunctions;

public class ModalComponent extends BaseComponent {

    private By modal = By.cssSelector("div.component.modal");

    public boolean isModalOpen() {
        return isElementVisible(modal);
    }

    public boolean hasMessageWithText(String text) {
        CommonFunctions.sleep(4000);
        String message = getDriver().findElement(modal).findElement(By.cssSelector("div.message-body")).getText();
        return message.contains(text);
    }

    public boolean hasText(String text) {
        return isElementVisible(By.xpath("//div[@class='modal-inner' and contains(., '" + text + "')]"));
    }
}
