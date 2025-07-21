package herokuapp.tests;

import herokuapp.base.BaseTest;
import herokuapp.pages.SecureFileDownloadPage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SecureFileDownloadTest extends BaseTest {

    private final String BASE_URL = "https://the-internet.herokuapp.com/download_secure";
    private final String VALID_CREDENTIALS_URL = "https://admin:admin@the-internet.herokuapp.com/download_secure";
    private final String INVALID_CREDENTIALS_URL = "https://wrong:wrong@the-internet.herokuapp.com/download_secure";

    @Test
    public void testSecureDownloadWithValidCredentials() throws InterruptedException {
        driver.get(VALID_CREDENTIALS_URL);
        Thread.sleep(3000);

        SecureFileDownloadPage page = new SecureFileDownloadPage(driver);

        System.out.println("Page Title: " + page.getPageTitle());
        assertTrue(page.areFilesListed(), "Files should be listed for authorized user.");
        System.out.println("Positive Test: Files listed successfully.");
    }

    @Test
    public void testSecureDownloadWithoutCredentials() throws InterruptedException {
        driver.get(BASE_URL);
        Thread.sleep(3000);

        SecureFileDownloadPage page = new SecureFileDownloadPage(driver);

        String message = page.getUnauthorizedMessage();
        System.out.println("Page Message: " + message);

        assertTrue(message.toLowerCase().contains("not authorized") || message.isEmpty(),
                "Expected 'Not authorized' or blank page.");
        System.out.println("Negative Test: Unauthorized message shown as expected.");
    }

    @Test
    public void testSecureDownloadWithInvalidCredentials() throws InterruptedException {
        driver.get(INVALID_CREDENTIALS_URL);
        Thread.sleep(3000);

        SecureFileDownloadPage page = new SecureFileDownloadPage(driver);

        String message = page.getUnauthorizedMessage();
        System.out.println("Page Message: " + message);

        assertTrue(message.toLowerCase().contains("not authorized") || message.isEmpty(),
                "Expected 'Not authorized' message for invalid credentials.");
        System.out.println("Negative Test: Invalid credentials result in unauthorized message.");
    }
}



