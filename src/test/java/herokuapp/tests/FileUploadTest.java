package herokuapp.tests;

import org.junit.jupiter.api.Test;

import herokuapp.base.BaseTest;
import herokuapp.pages.FileUploadPage;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileUploadTest extends BaseTest {

    @Test
    public void testFileUpload() throws InterruptedException {
        FileUploadPage page = new FileUploadPage(driver);

        // Step 1: Navigate to page
        page.open();
        Thread.sleep(4000);

        // Step 2: Upload file
        String filePath = System.getProperty("user.dir") + File.separator + "sample.txt";
        page.uploadFile(filePath);
        System.out.println("File path set: " + filePath);
        Thread.sleep(4000);

        // Step 3: Click upload
        page.clickUploadButton();
        System.out.println("Upload button clicked");
        Thread.sleep(4000);

        // Step 4: Assert upload successful
        assertTrue(page.isUploadMessageDisplayed(), "Upload message should appear");
        assertTrue(page.getUploadedFileName().equals("sample.txt"), "Uploaded file name should be sample.txt");

        System.out.println("File uploaded successfully and assertions passed.");
    }
}

