package entities.components;

import org.openqa.selenium.By;

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
        //javascriptScroll(500);
        By note = By.xpath(PHONE_PATH);

        String actualPhoneLabelText = getDriver().findElement(note).getText();
        assertEquals(actualPhoneLabelText, expectedPhoneLabelText, "Unexpected footer phone label");

        String actualHyperLinkNumber = getDriver().findElement(note).getAttribute("href");
        assertEquals(actualHyperLinkNumber, "tel:" + expectedHyperLinkNumber, "Unexpected footer phone number (hyper link)");
    }


}
