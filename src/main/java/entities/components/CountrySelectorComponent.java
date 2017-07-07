package entities.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CountrySelectorComponent extends BaseComponent {
    private By selectedCountry = By.xpath("//div[@class='selected-country']");

    public void select(String itemName) {
        By countryList = By.xpath("//div[@class='country' and text()='" + itemName + "']");

        WebElement selectedCountryEl = getDriver().findElement(selectedCountry);
        String actualItem = selectedCountryEl.getText();
        log.info("Actual item: " + actualItem + ". Expected item: " + itemName);
        if (!itemName.equals(actualItem)) {
            selectedCountryEl.click();
            waitForAjax();
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
}
