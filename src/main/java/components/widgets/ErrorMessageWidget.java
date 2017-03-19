package components.widgets;

import components.Component;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class ErrorMessageWidget extends Component {
    private final String PATH_BASE = "//div[@class='component message-panel message-panel-form-error']";

    By errorTitleEl = By.xpath(PATH_BASE + "/h2");
    By errorMessageEl = By.xpath(PATH_BASE + "/div");

    public void checkError(String title, String message) {
        getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        String errorTitleText = getDriver().findElement(errorTitleEl).getText();
        String errorMessageText = getDriver().findElement(errorMessageEl).getText();

        assertEquals("Unexpected error title", title, errorTitleText);
        assertEquals("Unexpected error message", message, errorMessageText);

//        getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//        String path = "//div[@class='component message-panel message-panel-form-error']";
//        String errorTitle = getDriver().findElement(By.xpath(path + "/h2")).getText();
//        String errorMessage = getDriver().findElement(By.xpath(path + "/div")).getText();
//        boolean flag = false;
//
//        assertEquals(errorTitle.toLowerCase(), "form errors");
//
//        if (errorMessage.toLowerCase().equals("please review all inputs.") ||
//                errorMessage.toLowerCase().equals("last name is invalid") ||
//                errorMessage.toLowerCase().equals("address 1 is required") ||
//                errorMessage.toLowerCase().equals("zip code is invalid (xxxxx or xxxxx-xxxx)") ||
//                errorMessage.toLowerCase().equals("email address is invalid")) {
//            flag = true;
//        }
//
//        assertTrue("Error message: '" + errorMessage.toLowerCase() + "' doesn't equals", flag);
    }
}
