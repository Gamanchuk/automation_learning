package entities.pages.shoe;


import entities.pages.BasePage;
import org.openqa.selenium.By;

public class SHOEForgotPasswordPage extends BasePage {

    //private By title = By.xpath("//h2[@class='title']");
    private By emailMyPassword = By.id("atg_store_profilePasswordForgotSubmit");

    @Override
    public boolean isPage() {
        return isElementVisible(emailMyPassword) && isElementClickable(emailMyPassword);
    }

}
