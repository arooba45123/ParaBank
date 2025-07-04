package herokuapp;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NotificationMessagesTest extends BaseTest {

    private final List<String> expectedMessages = Arrays.asList(
            "Action successful",
            "Action unsuccesful, please try again",
            "Action Unsuccessful"
    );

    // Positive: Verify notification is shown and text is valid
    @Test
    public void testNotificationMessage_Positive() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/notification_message_rendered");

        WebElement clickHereLink = driver.findElement(By.linkText("Click here"));
        clickHereLink.click();

        Thread.sleep(5000); // Wait for notification to appear

        WebElement notification = driver.findElement(By.id("flash"));
        String message = notification.getText().trim().replace("×", "").trim();

        assertTrue(expectedMessages.contains(message),
                "Positive: Message should be one of the expected options.");
        System.out.println("Positive: Notification message displayed: '" + message + "'");
    }

    // Negative: Verify that incorrect message is NOT displayed
    @Test
    public void testNotificationMessage_Negative() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/notification_message_rendered");

        WebElement clickHereLink = driver.findElement(By.linkText("Click here"));
        clickHereLink.click();

        Thread.sleep(5000); // Wait for notification to appear

        WebElement notification = driver.findElement(By.id("flash"));
        String message = notification.getText().trim().replace("×", "").trim();

        assertNotEquals("Invalid message", message,
                "Negative: Unexpected message 'Invalid message' should NOT appear.");
        System.out.println("Negative: Unexpected message was NOT displayed (as expected).");
    }
}
