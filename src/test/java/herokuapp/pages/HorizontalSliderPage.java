package herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HorizontalSliderPage {

    private WebDriver driver;

    // Locators
    private final By slider = By.cssSelector("input[type='range']");
    private final By valueText = By.id("range");

    public HorizontalSliderPage(WebDriver driver) {
        this.driver = driver;
    }

    // Move the slider by sending arrow keys
    public void moveSliderTo(double targetValue) {
        WebElement sliderElement = driver.findElement(slider);

        // Reset to minimum
        sliderElement.click();

        double currentValue = Double.parseDouble(driver.findElement(valueText).getText());

        // Keep pressing ARROW_RIGHT until we reach the target value
        while (currentValue < targetValue) {
            sliderElement.sendKeys(Keys.ARROW_RIGHT);
            currentValue = Double.parseDouble(driver.findElement(valueText).getText());
        }

        while (currentValue > targetValue) {
            sliderElement.sendKeys(Keys.ARROW_LEFT);
            currentValue = Double.parseDouble(driver.findElement(valueText).getText());
        }
    }

    // Get current displayed value
    public String getCurrentValue() {
        return driver.findElement(valueText).getText();
    }
}
