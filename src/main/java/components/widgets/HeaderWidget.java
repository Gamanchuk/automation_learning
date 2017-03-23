package components.widgets;

import components.Component;
import org.openqa.selenium.By;

public class HeaderWidget extends Component {
    private final String HEADER_PATH = "//header[contains(@class, 'header')]";

    public void pressSignInButton() {
        getDriver().findElement(By.xpath(HEADER_PATH + "//button[text()='Sign In']")).click();
    }
}
