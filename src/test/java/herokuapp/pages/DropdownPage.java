package herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage {
    private WebDriver driver;

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
    }

    private By dropdown = By.id("dropdown");

    public void open() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    public void selectOptionByVisibleText(String optionText) {
        Select select = new Select(driver.findElement(dropdown));
        select.selectByVisibleText(optionText);
    }

    public String getSelectedOption() {
        Select select = new Select(driver.findElement(dropdown));
        return select.getFirstSelectedOption().getText();
    }
}
