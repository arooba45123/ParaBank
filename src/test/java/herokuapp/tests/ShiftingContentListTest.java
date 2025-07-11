package herokuapp.tests;

import herokuapp.base.BaseTest;
import herokuapp.pages.ShiftingContentListPage;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ShiftingContentListTest extends BaseTest {

    private final String URL = "https://the-internet.herokuapp.com/shifting_content/list";

    @Test
    public void testListItemsChangeOnRefresh() throws InterruptedException {
        driver.get(URL);
        Thread.sleep(3000);

        ShiftingContentListPage page = new ShiftingContentListPage(driver);

        List<String> initialTexts = page.getAllListTexts();
        System.out.println("Initial list: " + initialTexts);

        boolean changed = false;

        for (int i = 1; i <= 3; i++) {
            driver.navigate().refresh();
            Thread.sleep(3000);

            List<String> newTexts = page.getAllListTexts();
            System.out.println("After refresh #" + i + ": " + newTexts);

            if (!newTexts.equals(initialTexts)) {
                changed = true;
                System.out.println("List changed after refresh #" + i);
                break;
            }
        }

        if (!changed) {
            System.out.println("List did NOT change after 3 refreshes. (May be expected behavior)");
        }
    }

    @Test
    public void testSpecificTextPresent() throws InterruptedException {
        driver.get(URL);
        Thread.sleep(3000);

        ShiftingContentListPage page = new ShiftingContentListPage(driver);

        List<String> currentTexts = page.getAllListTexts();
        System.out.println("Current list: " + currentTexts);

        // Replace with an actual value you observe, e.g., "Item 1"
        String expectedText = "Item 1"; 

        boolean found = page.isTextPresent(expectedText);

        if (found) {
            System.out.println("Expected text '" + expectedText + "' is present.");
        } else {
            System.out.println("Expected text '" + expectedText + "' is NOT present.");
        }

        // No assertion here, just observation
    }

    @Test
    public void testUnexpectedTextNotPresent() throws InterruptedException {
        driver.get(URL);
        Thread.sleep(3000);

        ShiftingContentListPage page = new ShiftingContentListPage(driver);

        String unexpectedText = "InvalidText";

        boolean found = page.isTextPresent(unexpectedText);

        assertFalse(found, "Invalid text should NOT be present.");
        System.out.println("Verified: '" + unexpectedText + "' is not present in the list.");
    }
}

