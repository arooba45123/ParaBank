package herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicControlsPage {
    private WebDriver driver;

    public DynamicControlsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By removeButton = By.xpath("//button[text()='Remove']");
    private By addButton = By.xpath("//button[text()='Add']");
    private By checkbox = By.id("checkbox");
    private By enableButton = By.xpath("//button[text()='Enable']");
    private By disableButton = By.xpath("//button[text()='Disable']");
    private By inputField = By.xpath("//form[@id='input-example']/input");

    public void open() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
    }

    public void clickRemoveButton() {
        driver.findElement(removeButton).click();
    }

    public boolean isCheckboxGone() {
        return driver.findElements(checkbox).isEmpty();
    }

    public void clickAddButton() {
        driver.findElement(addButton).click();
    }

    public boolean isCheckboxDisplayed() {
        return driver.findElement(checkbox).isDisplayed();
    }

    public void clickEnableButton() {
        driver.findElement(enableButton).click();
    }

    public void clickDisableButton() {
        driver.findElement(disableButton).click();
    }

    public boolean isInputEnabled() {
        return driver.findElement(inputField).isEnabled();
    }

    public void enterTextInInput(String text) {
        driver.findElement(inputField).sendKeys(text);
    }
}

