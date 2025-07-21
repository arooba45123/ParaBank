package herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyPressesPage {

    private final WebDriver driver;

    // Locators
    private final By resultText = By.id("result");

    // Constructor
    public KeyPressesPage(WebDriver driver) {
        this.driver = driver;
    }

    // Perform a key press (supports Keys and String)
    public void pressKey(CharSequence key) {
        Actions actions = new Actions(driver);
        actions.sendKeys(key).perform();
    }

    // Get the displayed result message
    public String getResultMessage() {
        return driver.findElement(resultText).getText().trim();
    }
}
