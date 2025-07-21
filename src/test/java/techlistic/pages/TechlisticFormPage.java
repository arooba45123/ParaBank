package techlistic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TechlisticFormPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public TechlisticFormPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators
    private By firstNameField = By.name("firstname");
    private By lastNameField = By.name("lastname");
    private By genderMaleRadio = By.id("sex-0");
    private By genderFemaleRadio = By.id("sex-1");
    private By experience0Radio = By.id("exp-0");
    private By experience1Radio = By.id("exp-1");
    private By dateField = By.id("datepicker");
    private By professionManualCheckbox = By.id("profession-0");
    private By professionAutomationCheckbox = By.id("profession-1");
    private By toolSeleniumCheckbox = By.id("tool-2");
    private By continentDropdown = By.id("continents");
    private By commandDropdown = By.id("selenium_commands");
    private By fileUploadField = By.id("photo");
    private By submitButton = By.id("submit");

    // Actions
    public void fillForm(
            String firstName, String lastName, String gender,
            String experience, String date, String profession,
            String tool, String continent, String command, String filePath) {

        System.out.println("Filling First Name");
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).sendKeys(firstName);

        System.out.println("Filling Last Name");
        wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField)).sendKeys(lastName);

        System.out.println("Selecting Gender");
        if (gender.equalsIgnoreCase("male")) {
            wait.until(ExpectedConditions.elementToBeClickable(genderMaleRadio)).click();
        } else if (gender.equalsIgnoreCase("female")) {
            wait.until(ExpectedConditions.elementToBeClickable(genderFemaleRadio)).click();
        }

        System.out.println("Selecting Experience");
        if (experience.equals("0")) {
            wait.until(ExpectedConditions.elementToBeClickable(experience0Radio)).click();
        } else {
            wait.until(ExpectedConditions.elementToBeClickable(experience1Radio)).click();
        }

        System.out.println("Filling Date");
        wait.until(ExpectedConditions.visibilityOfElementLocated(dateField)).sendKeys(date);

        System.out.println("Selecting Profession");
        if (profession.equalsIgnoreCase("manual")) {
            wait.until(ExpectedConditions.elementToBeClickable(professionManualCheckbox)).click();
        } else if (profession.equalsIgnoreCase("automation")) {
            wait.until(ExpectedConditions.elementToBeClickable(professionAutomationCheckbox)).click();
        }

        System.out.println("Selecting Tool");
        if (tool.equalsIgnoreCase("selenium")) {
            wait.until(ExpectedConditions.elementToBeClickable(toolSeleniumCheckbox)).click();
        }

        System.out.println("Selecting Continent");
        Select continentSelect = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(continentDropdown)));
        continentSelect.selectByVisibleText(continent);

        System.out.println("Selecting Command");
        Select commandSelect = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(commandDropdown)));
        commandSelect.selectByVisibleText(command);

        System.out.println("Uploading File");
        wait.until(ExpectedConditions.presenceOfElementLocated(fileUploadField)).sendKeys(filePath);
    }

    public void clickSubmit() {
        System.out.println("Clicking Submit Button");
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }
}
