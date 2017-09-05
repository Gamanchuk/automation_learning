package entities.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertEquals;


public class FooterComponent extends BaseComponent {
    private final String FOOTER_PATH = "//div[contains(@class, 'footer')]";
    private final String PHONE_PATH = FOOTER_PATH + "//div[@class='footer-phone']/a";

    public void checkNote(String expectedText) {
        By note = By.xpath(FOOTER_PATH + "//div[@class='footer-footnote']");
        String actualText = getDriver().findElement(note).getText();
        assertEquals(actualText, expectedText, "Unexpected footer note");
    }

    public void checkPhoneNumber(String expectedPhoneLabelText, String expectedHyperLinkNumber) {
        By note = By.xpath(PHONE_PATH);

        WebElement phoneEl = getDriver().findElement(note);

        assertEquals(phoneEl.getText(), expectedPhoneLabelText, "Unexpected footer phone label");
        assertEquals(phoneEl.getAttribute("href"),
                "tel:" + expectedHyperLinkNumber,
                "Unexpected footer phone number (hyper link)");
    }

    @Override
    public boolean isExist() {
        return isElementVisible(By.xpath(FOOTER_PATH));
    }

    @Override
    public boolean isExist(int timeout) {
        return isElementVisible(By.xpath(FOOTER_PATH), timeout);
    }
}
