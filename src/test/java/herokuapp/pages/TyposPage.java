package herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TyposPage {
	
	private WebDriver driver;
	
    // Locators
    private final By heading = By.tagName("h3");
    private final By paragraph = By.cssSelector("#content > div > p");
    
    public TyposPage (WebDriver driver) {
    	this.driver = driver;
    }
    // get heading text
    public String getHeadingText() {
    	return driver.findElement(heading).getText();
    }
    // get paragraph text
    public String getParagraphText() {
    	return driver.findElement(paragraph).getText();
    	
    }
    // check if typo is present
    public boolean isTypoPresent() {
    	String text = getParagraphText();
    	return text.contains ("won,t");
    }
}
