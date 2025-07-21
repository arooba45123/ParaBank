package herokuapp.tests;

import org.junit.jupiter.api.Test;

import herokuapp.base.BaseTest;
import herokuapp.pages.HoverPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HoverTest extends BaseTest {

    @Test
    public void testHoverOverAllImagesAndProfiles() throws InterruptedException {
        HoverPage page = new HoverPage(driver);

        page.open();

        for (int i = 1; i <= 3; i++) {
            // Step 1: Hover
            page.hoverOverImage(i);
            System.out.println("Hovered over image " + i);
            Thread.sleep(4000);

            // Step 2: User name
            String userName = page.getUserName(i);
            System.out.println("Found user: " + userName);
            assertTrue(page.isUserNameDisplayed(i), "User name should be visible");

            // Step 3: Click profile
            page.clickViewProfile(i);
            System.out.println("Clicked on View Profile of user " + i);
            Thread.sleep(4000);

            // Step 4: Validate Not Found
            String notFoundText = page.getNotFoundMessage();
            assertTrue(notFoundText.contains("Not Found"), "❌ Profile not found message should appear");
            System.out.println("Result: " + notFoundText);

            // Step 5: Go back
            page.goBack();
            Thread.sleep(4000);
        }
    }
}


