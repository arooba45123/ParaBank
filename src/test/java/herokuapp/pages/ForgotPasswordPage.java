package herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private WebDriver driver;

    // Locators
    private By emailInput = By.id("email");
    private By retrieveButton = By.id("form_submit");
    private By body = By.tagName("body");

    // Constructor
    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    // Enter email into input field
    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    // Click the Retrieve Password button
    public void clickRetrievePassword() {
        driver.findElement(retrieveButton).click();
    }

    // Get the full body text of the resulting page
    public String getBodyText() {
        return driver.findElement(body).getText();
    }
}
