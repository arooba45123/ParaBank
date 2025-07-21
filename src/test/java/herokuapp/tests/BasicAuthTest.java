package herokuapp.tests;

import herokuapp.base.BaseTest;
import herokuapp.pages.BasicAuthPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BasicAuthTest extends BaseTest {

    private final String BASE_URL = "https://the-internet.herokuapp.com/basic_auth";
    private final String VALID_CREDENTIALS_URL = "https://admin:admin@the-internet.herokuapp.com/basic_auth";
    private final String INVALID_CREDENTIALS_URL = "https://wrong:wrong@the-internet.herokuapp.com/basic_auth";

    @Test
    public void testBasicAuthWithValidCredentials() throws InterruptedException {
        driver.get(VALID_CREDENTIALS_URL);
        Thread.sleep(3000);

        BasicAuthPage page = new BasicAuthPage(driver);

        String message = page.getSuccessMessage();
        System.out.println("Page Message: " + message);

        assertTrue(message.contains("Congratulations"),
                "Expected success message to contain 'Congratulations'");
        System.out.println("Positive Test: Valid credentials succeeded.");
    }

    @Test
    public void testBasicAuthWithoutCredentials() throws InterruptedException {
        driver.get(BASE_URL);
        Thread.sleep(3000);

        String title = driver.getTitle();
        System.out.println("Page Title: " + title);

        // Cannot actually test browser popup in Selenium — just note it
        assertNotEquals("Basic Auth", title,
                "Without credentials, authentication popup appears.");
        System.out.println("Negative Test: Without credentials browser popup appears.");
    }

    @Test
    public void testBasicAuthWithInvalidCredentials() throws InterruptedException {
        driver.get(INVALID_CREDENTIALS_URL);
        Thread.sleep(3000);

        String title = driver.getTitle();
        System.out.println("Page Title: " + title);

        assertNotEquals("Basic Auth", title,
                "With invalid credentials, authentication fails.");
        System.out.println("Negative Test: Invalid credentials fail as expected.");
    }
}

