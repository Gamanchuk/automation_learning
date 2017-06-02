package entities.pages.pepboys;

import entities.pages.BasePage;
import org.openqa.selenium.By;

public class PepBoysMainPage extends BasePage {

    private By searchBox = By.id("search-site");

    public boolean isPage() {
        return isElementClickable(searchBox)
                && isElementVisible(By.xpath("//span[@class='mw_category_title' and text()='Tires']"));
    }

    public void openPageWithCookies(){
        navigateWithCookies(BASE_URL, COOKIES);
    }

    public void openPage(){
        navigate(BASE_URL);
    }

    public void openMainPage() {
        click(By.cssSelector("a.mw-logo"));
    }

    public void openMakeAppointment() {
        click(By.xpath("//a[text()='Make Appointment']"));
        waitForElementPresence(By.cssSelector("button.locationBtn"));
    }

    public void doLogout() {
        getDriver().navigate().to(BASE_URL + "logout");
    }
}
