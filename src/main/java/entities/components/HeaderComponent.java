package entities.components;

import entities.Component;
import org.openqa.selenium.By;

public class HeaderComponent extends Component {
    private final String HEADER_PATH = "//header[contains(@class, 'header')]";

    public void pressSignInButton() {
        getDriver().findElement(By.xpath(HEADER_PATH + "//button[text()='Sign In']")).click();
    }
}
