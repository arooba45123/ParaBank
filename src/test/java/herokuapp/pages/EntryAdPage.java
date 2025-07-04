package herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

    
     // Check if the modal is displayed
     
    public boolean isModalDisplayed() {
        WebElement modalElement = driver.findElement(modal);
        return modalElement.isDisplayed();
    }

    
     //  Get the modal's title text
     
    public String getModalTitle() {
        return driver.findElement(modalTitle).getText().trim();
    }

    
     // Close the modal by clicking the close button
     
    public void closeModal() {
        driver.findElement(closeButton).click();
    }
}
