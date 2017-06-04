package entities.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import utils.CommonFunctions;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class SignInFormComponent extends BaseComponent {
    private By forgotPassword = By.xpath("//div[contains(@class,'login-buttons')]//a");
    private By emailField = By.id("shipping-email");
    private By passwordField = By.id("password");

    final static String EMAIL = "email";
    final static String PASSWORD = "password";


    public void signIn(String email, String password) {

        fillEmail(email);
        fillPassword(password);

        //focusOut(passwordFieldEl);
        CommonFunctions.attachScreenshot("Login page");
    }

    public void pressForgotPasswordLink() {
        assertTrue(isElementClickable(forgotPassword), "Forgot password link not clickable. Or doesn't exist");
        CommonFunctions.attachScreenshot("Login page: Forgot Password");
        getDriver().findElement(forgotPassword).click();
    }

    public boolean exist() {
        return isElementVisible(emailField);
    }


    public void fillEmail(String value) {
        fillField(emailField, value);
        List<LogEntry> entries = getDriver().manage().logs().get(LogType.PERFORMANCE).getAll();

        log.info("Perf logs");
        for (LogEntry logEntry : entries) {
            log.info(logEntry.getMessage());
        }

    }

    public void fillPassword(String value) {
        fillField(passwordField, value);
    }

    private void fillField(By field, String value) {
        assertTrue(isElementVisible(field), "Field " + field.toString() + " doesn't present on page.");
        WebElement element = getDriver().findElement(field);
        element.clear();
        element.sendKeys(value);
    }
}
