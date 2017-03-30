package entities.components;

import org.openqa.selenium.By;
import utils.CommonFunctions;

import static org.testng.Assert.assertEquals;

public class FooterComponent extends BaseComponent {
    private final String FOOTER_PATH = "//div[contains(@class, 'footer')]";
    private final String PHONE_PATH = FOOTER_PATH + "//div[@class='footer-phone']/a";

    public void checkNote(String expectedText) {
        By note = By.xpath(FOOTER_PATH + "//div[@class='footer-footnote']");
        String actualText = getDriver().findElement(note).getText();
        assertEquals(actualText, expectedText, "Unexpected footer note");
    }

    public void pressCall() {
        getDriver().findElement(By.xpath(PHONE_PATH)).click();
    }

    public void checkCallAlert(String expectedNumber) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getDriver().findElement(By.linkText("Cancel")).click();

        CommonFunctions.attachScreenshot("Call Alert");
//        String actualNumber = alert.getText();
//        assertEquals(actualNumber, expectedNumber, "Unexpected phone number");

        //alert.dismiss();
        javascriptScroll(-500);
    }


    public void checkPhoneNumberLabel(String expectedText) {
        javascriptScroll(500);
        By note = By.xpath(PHONE_PATH);
        String actualText = getDriver().findElement(note).getText();
        assertEquals(actualText, expectedText, "Unexpected footer phone label");
    }


}
