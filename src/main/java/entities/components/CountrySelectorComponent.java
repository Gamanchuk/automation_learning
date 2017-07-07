package entities.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonFunctions;

import static org.testng.Assert.assertTrue;

public class CountrySelectorComponent extends BaseComponent {
    private By selectedCountry = By.xpath("//div[@class='selected-country']");
    private By countryNote = By.xpath("//div[contains(@class, 'invalid-country-note')]");

    public void select(String itemName) {
        By countryList = By.xpath("//div[@class='country' and text()='" + itemName + "']");

        WebElement selectedCountryEl = getDriver().findElement(selectedCountry);
        String actualItem = selectedCountryEl.getText();
        log.info("Actual item: " + actualItem + ". Expected item: " + itemName);
        if (!itemName.equals(actualItem)) {
            selectedCountryEl.click();
            CommonFunctions.sleep(1000);
            assertTrue(isElementVisible(countryList), "Looks like country drop-down doesn't have Country: " + itemName);
            getDriver().findElement(countryList).click();
        } else {
            log.info("Item selected by default: " + itemName);
        }
    }

    public boolean exists() {
        return isElementVisible(selectedCountry);
    }

    public String getSelectedCountry() {
        return getDriver().findElement(selectedCountry).getText();
    }

    public String getCountryNote() {
        assertTrue(isElementVisible(countryNote), "Looks like country note doesn't present on page");
        return getDriver().findElement(countryNote).getText();
    }
}
