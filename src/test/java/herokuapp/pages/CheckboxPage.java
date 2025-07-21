package herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckboxPage {
    private WebDriver driver;

    public CheckboxPage(WebDriver driver) {
        this.driver = driver;
    }

    private By checkbox1 = By.xpath("//form[@id='checkboxes']/input[1]");
    private By checkbox2 = By.xpath("//form[@id='checkboxes']/input[2]");

    public void open() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    public boolean isCheckbox1Selected() {
        return driver.findElement(checkbox1).isSelected();
    }

    public boolean isCheckbox2Selected() {
        return driver.findElement(checkbox2).isSelected();
    }

    public void clickCheckbox1() {
        driver.findElement(checkbox1).click();
    }

    public void clickCheckbox2() {
        driver.findElement(checkbox2).click();
    }
}
