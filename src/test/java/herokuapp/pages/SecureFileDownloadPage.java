package herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SecureFileDownloadPage {

    private WebDriver driver;

    // Locators
    private By pageTitle = By.tagName("h3");
    private By unauthorizedMessage = By.cssSelector("body");
    private By fileLinks = By.cssSelector("#content a");

    public SecureFileDownloadPage(WebDriver driver) {
        this.driver = driver;
    }

    // Get the page heading/title
    public String getPageTitle() {
        return driver.findElement(pageTitle).getText().trim();
    }

    // Check if files are listed
    public boolean areFilesListed() {
        List<WebElement> files = driver.findElements(fileLinks);
        return !files.isEmpty();
    }

    // Get text of unauthorized page (or blank page)
    public String getUnauthorizedMessage() {
        return driver.findElement(unauthorizedMessage).getText().trim();
    }
}

	
	
	
	
	
	
	
	
	
	
	
	
	

