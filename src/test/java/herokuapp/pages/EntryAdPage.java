package herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EntryAdPage {

    private WebDriver driver;

    // Locators
    private By modal = By.id("modal");
    private By modalTitle = By.cssSelector("#modal .modal-title");
    private By closeButton = By.cssSelector("#modal .modal-footer p");

    // Constructor
    public EntryAdPage(WebDriver driver) {
        this.driver = driver;
    }

    
    //  Wait for the modal to appear and return true if it does.
     
    public boolean waitForModalDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            WebElement modalElement = wait.until(ExpectedConditions.visibilityOfElementLocated(modal));
            return modalElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getModalTitle() {
        WebElement title = driver.findElement(modalTitle);
        return title.getText().trim();
    }

    public void closeModal() {
        driver.findElement(closeButton).click();
    }
}
