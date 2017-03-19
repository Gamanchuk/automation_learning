package components.widgets;

import components.Component;
import org.openqa.selenium.By;

public class EmailWidget extends Component {
    private By emailField = By.id("billing-email");

    public void fillEmailField(String email) {
        getDriver().findElement(emailField).sendKeys(email);
    }
}
