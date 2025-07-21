package herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage {
    private WebDriver driver;

    public FileUploadPage(WebDriver driver) {
        this.driver = driver;
    }

    private By uploadInput = By.id("file-upload");
    private By uploadButton = By.id("file-submit");
    private By successMessage = By.tagName("h3");
    private By uploadedFileName = By.id("uploaded-files");

    public void open() {
        driver.get("https://the-internet.herokuapp.com/upload");
    }

    public void uploadFile(String filePath) {
        driver.findElement(uploadInput).sendKeys(filePath);
    }

    public void clickUploadButton() {
        driver.findElement(uploadButton).click();
    }

    public boolean isUploadMessageDisplayed() {
        return driver.findElement(successMessage).getText().contains("File Uploaded!");
    }

    public String getUploadedFileName() {
        return driver.findElement(uploadedFileName).getText();
    }
}
