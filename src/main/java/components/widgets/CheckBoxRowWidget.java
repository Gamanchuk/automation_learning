package components.widgets;


import components.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckBoxRowWidget extends Component {
    private By checkBoxRow = By.cssSelector("label.checkbox-row");

    private WebElement getCheckBoxRowElementByLabel(String label) {
        for (WebElement el : getDriver().findElements(checkBoxRow)) {
            if (el.findElements(By.xpath("//span[contains(text(), " + label + ")]")).size() > 0) {
                return el;
            }
        }
        throw new Error("CheckBox by label '" + label + "' was not found");
    }

    public void setCheckBox(String label, boolean checked) {
        WebElement checkBoxRowEl = getCheckBoxRowElementByLabel(label);
        WebElement checkBox = checkBoxRowEl.findElement(By.xpath("//input[@type='checkbox']"));
        if (checkBox.getAttribute("data-analytics-name").contains("_check") != checked) {
            checkBox.click();
        }
    }
}
