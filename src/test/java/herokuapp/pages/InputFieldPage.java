package herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class InputFieldPage {
    private WebDriver driver;

    public InputFieldPage(WebDriver driver) {
        this.driver = driver;
    }

    private By inputField = By.tagName("input");

    public void open() {
        driver.get("https://the-internet.herokuapp.com/inputs");
    }

    public void typeValue(String value) {
        driver.findElement(inputField).sendKeys(value);
    }

    public void clearField() {
        driver.findElement(inputField).clear();
    }

    public void pressArrowUp() {
        driver.findElement(inputField).sendKeys(Keys.ARROW_UP);
    }

    public void pressArrowDown() {
        driver.findElement(inputField).sendKeys(Keys.ARROW_DOWN);
    }

    public String getFieldValue() {
        return driver.findElement(inputField).getAttribute("value");
    }
}
