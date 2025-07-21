package orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrangeHRMLoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public OrangeHRMLoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton = By.cssSelector("button[type='submit']");
    private By dashboardHeader = By.xpath("//h6[text()='Dashboard']");
    private By errorMessage = By.cssSelector("p.oxd-alert-content-text");
    private By userDropdown = By.cssSelector(".oxd-userdropdown-tab");
    private By logoutLink = By.xpath("//a[text()='Logout']");

    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField)).clear();
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public String getLoginResult() {
        System.out.println("Checking login result");

        try {
            wait.until(driver ->
                driver.findElements(dashboardHeader).size() > 0 ||
                driver.findElements(errorMessage).size() > 0
            );

            if (driver.findElements(dashboardHeader).size() > 0) {
                System.out.println("Login Successful");
                return "Success";
            } else if (driver.findElements(errorMessage).size() > 0) {
                String errorText = driver.findElement(errorMessage).getText().trim();
                System.out.println("Error message found on page: [" + errorText + "]");
                return errorText;
            } else {
                System.out.println("Neither Dashboard nor Error Message found.");
                return "Unknown";
            }
        } catch (Exception e) {
            System.out.println("Exception while checking result: " + e.getMessage());
            return "Unknown";
        }
    }

    public void logoutIfLoggedIn() {
        if (driver.findElements(userDropdown).size() > 0) {
            wait.until(ExpectedConditions.elementToBeClickable(userDropdown)).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(logoutLink)).click();
            System.out.println("Logged out successfully");
        }
    }
}


	
	
	
	
	
	
	
	

