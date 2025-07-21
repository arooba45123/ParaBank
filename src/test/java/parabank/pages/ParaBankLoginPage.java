package parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ParaBankLoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public ParaBankLoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton = By.xpath("//input[@value='Log In']");
    private By errorMessage = By.xpath("//p[@class='error']"); // adjust if site changes

    // Actions
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

    public String getErrorMessage() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText();
        } catch (Exception e) {
            return ""; // no error message shown
        }
    }

    public boolean isLoggedIn() {
        return driver.getTitle().contains("ParaBank") && driver.getPageSource().contains("Accounts Overview");
    }
}

