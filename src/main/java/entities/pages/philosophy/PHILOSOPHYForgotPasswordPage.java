package entities.pages.philosophy;


import entities.pages.BasePage;
import org.openqa.selenium.By;

public class PHILOSOPHYForgotPasswordPage extends BasePage {

    //private By title = By.xpath("//h2[@class='title']");
    private By emailMyPassword = By.id("atg_store_profilePasswordForgotSubmit");

    @Override
    public boolean isPage() {
        return isElementVisible(emailMyPassword) && isElementClickable(emailMyPassword);
    }

}
