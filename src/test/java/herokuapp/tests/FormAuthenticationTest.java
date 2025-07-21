package herokuapp.tests;

import herokuapp.base.BaseTest;
import herokuapp.pages.FormAuthenticationPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FormAuthenticationTest extends BaseTest {

    private final String URL = "https://the-internet.herokuapp.com/login";

    // Positive Test: Login with valid credentials and logout
    @Test
    public void testValidLoginAndLogout() throws InterruptedException {
        driver.get(URL);

        FormAuthenticationPage authPage = new FormAuthenticationPage(driver);

        authPage.enterUsername("tomsmith");
        authPage.enterPassword("SuperSecretPassword!");
        authPage.clickLogin();

        Thread.sleep(4000);

        String successMessage = authPage.getFlashMessage();
        assertTrue(successMessage.contains("You logged into a secure area!"), "Positive: Login success message mismatch");

        // Handle optional dialog
        authPage.handleChangePasswordDialogIfPresent();

        authPage.clickLogout();

        Thread.sleep(4000);

        String logoutMessage = authPage.getFlashMessage();
        assertTrue(logoutMessage.contains("You logged out of the secure area!"), "Positive: Logout success message mismatch");
    }

    // Negative Test 1: Invalid Username
    @Test
    public void testInvalidUsername() throws InterruptedException {
        driver.get(URL);

        FormAuthenticationPage authPage = new FormAuthenticationPage(driver);

        authPage.enterUsername("invalidUser");
        authPage.enterPassword("SuperSecretPassword!");
        authPage.clickLogin();

        Thread.sleep(4000);

        String errorMessage = authPage.getFlashMessage();
        assertTrue(errorMessage.contains("Your username is invalid!"), "Negative: Invalid username message mismatch");
    }

    // Negative Test 2: Invalid Password
    @Test
    public void testInvalidPassword() throws InterruptedException {
        driver.get(URL);

        FormAuthenticationPage authPage = new FormAuthenticationPage(driver);

        authPage.enterUsername("tomsmith");
        authPage.enterPassword("wrongPassword");
        authPage.clickLogin();

        Thread.sleep(4000);

        String errorMessage = authPage.getFlashMessage();
        assertTrue(errorMessage.contains("Your password is invalid!"), "Negative: Invalid password message mismatch");
    }
}


