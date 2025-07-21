package herokuapp.tests;

import herokuapp.base.BaseTest;
import herokuapp.pages.NotificationMessagesPage;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NotificationMessagesTest extends BaseTest {

    private final List<String> expectedMessages = Arrays.asList(
            "Action successful",
            "Action unsuccesful, please try again",
            "Action Unsuccessful"
    );

    @Test
    public void testNotificationMessage_Positive() throws InterruptedException {
        NotificationMessagesPage page = new NotificationMessagesPage(driver);
        page.open();

        page.clickHere();

        Thread.sleep(5000); // Wait for notification to appear

        String message = page.getNotificationMessage();

        assertTrue(expectedMessages.contains(message),
                "Positive: Message should be one of the expected options.");
        System.out.println("Notification message displayed: '" + message + "'");
    }

    @Test
    public void testNotificationMessage_Negative() throws InterruptedException {
        NotificationMessagesPage page = new NotificationMessagesPage(driver);
        page.open();

        page.clickHere();

        Thread.sleep(5000); // Wait for notification to appear

        String message = page.getNotificationMessage();

        assertNotEquals("Invalid message", message,
                "Negative: Unexpected message 'Invalid message' should NOT appear.");
        System.out.println("Negative: Unexpected message was NOT displayed (as expected).");
    }
}

