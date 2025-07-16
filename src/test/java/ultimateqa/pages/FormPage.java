package ultimateqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FormPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By nameField = By.id("et_pb_contact_name_0");
    private By messageField = By.id("et_pb_contact_message_0");
    private By submitButton = By.cssSelector(".et_pb_contact_submit:nth-of-type(1)");
    private By successMessage = By.cssSelector(".et-pb-contact-message");

    // Constructor
    public FormPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterName(String name) {
        WebElement nameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(nameField));
        nameInput.clear();
        nameInput.sendKeys(name);
    }

    public void enterMessage(String message) {
        WebElement messageInput = wait.until(ExpectedConditions.visibilityOfElementLocated(messageField));
        messageInput.clear();
        messageInput.sendKeys(message);
    }

    public void clickSubmit() {
        WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submitBtn.click();
    }

    public String getSuccessMessage() {
        WebElement success = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return success.getText().trim();
    }
}
