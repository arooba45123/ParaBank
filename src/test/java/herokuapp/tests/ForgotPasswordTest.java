package herokuapp.tests;

import herokuapp.base.BaseTest;
import herokuapp.pages.ForgotPasswordPage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ForgotPasswordTest extends BaseTest {

    private final String URL = "https://the-internet.herokuapp.com/forgot_password";

    
   // Negative Test: Verify that submitting the Forgot Password form results in "Internal Server Error" message.
     
    @Test
    public void testForgotPassword_InternalServerError() throws InterruptedException {
        driver.get(URL);

        ForgotPasswordPage forgotPage = new ForgotPasswordPage(driver);

        // Enter any dummy email
        forgotPage.enterEmail("test@example.com");
        forgotPage.clickRetrievePassword();

        Thread.sleep(4000); // Wait for page to load

        String bodyText = forgotPage.getBodyText();

        assertTrue(bodyText.contains("Internal Server Error"),
                "Forgot Password page should display 'Internal Server Error' after submission.");

        System.out.println("Forgot Password test passed: Internal Server Error detected.");
    }
}
