package parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ParaBankRegistrationPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public ParaBankRegistrationPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
	}
	// Locators
	
	private By firstNameField = By.id("customer.firstName");
	private By lastNameField = By.id("customer.lastName");
	private By addressField = By.id("customer.address.street");
	private By cityField = By.id("customer.address.city");
	private By stateField = By.id("customer.address.state");
	private By zipCodeField = By.id("customer.address.zipCode");
	private By phoneField = By.id("customer.phoneNumber");
	private By ssnField = By.id("customer.ssn");
	private By usernameField = By.id("customer.username");
	private By passwordField = By.id("customer.password");
	private By confirmPasswordField = By.id("repeatedPassword");
	private By registerButton = By.xpath("//input[@value='Register']");
	private By successMessage = By.xpath("//p[contains(text(), 'Your account was created successfully')]");
	

	// actions 
	
	public void fillRegistrationForm(String firstName, String lastName, String address, String city, 
			String state, String zip, String phone, String ssn, String username, String password, String confirmpassword) {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).sendKeys(firstName);
		driver.findElement(lastNameField).sendKeys(lastName);
		driver.findElement(addressField).sendKeys(address);
		driver.findElement(cityField).sendKeys(city);
		driver.findElement(stateField).sendKeys(state);
		driver.findElement(zipCodeField).sendKeys(zip);
		driver.findElement(phoneField).sendKeys(phone);
		driver.findElement(ssnField).sendKeys(ssn);
		driver.findElement(usernameField).sendKeys(username);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(confirmPasswordField).sendKeys(confirmpassword);
		driver.findElement(lastNameField).sendKeys(lastName);
		driver.findElement(lastNameField).sendKeys(lastName);
		
		
	}
	
	public void clickRegister() {
		driver.findElement(registerButton).click();
	}
	 public String getSuccessMessage() {
	        try {
	            return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).getText();
	        } catch (Exception e) {
	            return "Unknown";
	        }
	
	 }
}
