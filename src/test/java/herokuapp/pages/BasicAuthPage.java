package herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasicAuthPage {

	private WebDriver driver;

	// Locator
	private By message = By.cssSelector("#content p");
	
	public BasicAuthPage (WebDriver driver) {
		this.driver = driver;
	}
	public String getSuccessMessage() {
		return driver.findElement(message).getText().trim();
	}
		
}
