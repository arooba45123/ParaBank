package herokuapp;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileUploadTest extends BaseTest {

    @Test
    public void testFileUpload() throws InterruptedException {
        // Step 1: Navigate to the File Upload page
        driver.get("https://the-internet.herokuapp.com/upload");
        Thread.sleep(3000);

        // Step 2: Locate the file input element
        WebElement uploadInput = driver.findElement(By.id("file-upload"));

        // Step 3: Provide path of the file to upload
        String filePath = System.getProperty("user.dir") + File.separator + "sample.txt";
        uploadInput.sendKeys(filePath);
        System.out.println("File path set: " + filePath);
        Thread.sleep(3000);

        // Step 4: Click the upload button
        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();
        System.out.println("Upload button clicked");
        Thread.sleep(3000);

        // Step 5: Assert that file was uploaded successfully
        WebElement successMessage = driver.findElement(By.tagName("h3"));
        assertTrue(successMessage.getText().contains("File Uploaded!"), "Upload message should appear");

        WebElement uploadedFileName = driver.findElement(By.id("uploaded-files"));
        assertTrue(uploadedFileName.getText().equals("sample.txt"), "Uploaded file name should be sample.txt");

        System.out.println("File uploaded successfully and assertions passed.");
    }
}
