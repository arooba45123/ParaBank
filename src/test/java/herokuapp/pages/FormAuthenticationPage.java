package herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormAuthenticationPage {

    private WebDriver driver;

    // Locators
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.cssSelector("button.radius");
    private By logoutButton = By.cssSelector("a.button.secondary.radius");
    private By flashMessage = By.id("flash");

    // Assuming popup dialog has these locators:
    private By changePasswordDialog = By.id("change-password-dialog");  // example
    private By changePasswordOkButton = By.id("change-password-ok");    // example

    // Constructor
    public FormAuthenticationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).clear();
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public String getFlashMessage() {
        String msg = driver.findElement(flashMessage).getText().replace("×", "").trim();
        return msg;
    }

    public void clickLogout() {
        driver.findElement(logoutButton).click();
    }

    
    // If change password dialog appears, click OK.Otherwise, ignore.
     
    public void handleChangePasswordDialogIfPresent() {
        try {
            if (driver.findElement(changePasswordDialog).isDisplayed()) {
                driver.findElement(changePasswordOkButton).click();
                System.out.println("✅ Change Password dialog handled.");
            }
        } catch (Exception e) {
            System.out.println("ℹ️ No Change Password dialog appeared.");
        }
    }
}


