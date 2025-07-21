package herokuapp.tests;

import herokuapp.base.BaseTest;
import herokuapp.pages.ShiftingContentMenuPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShiftingContentMenuTest extends BaseTest {

    private final String URL = "https://the-internet.herokuapp.com/shifting_content/menu";

    @Test
    public void testShiftingMenuOnRefresh() throws InterruptedException {
        driver.get(URL);
        Thread.sleep(3000); // Initial load wait

        ShiftingContentMenuPage page = new ShiftingContentMenuPage(driver);

        // Loop through 3 refreshes
        for (int i = 1; i <= 3; i++) {
            driver.navigate().refresh(); // Refresh the page
            Thread.sleep(2000); // Wait for refresh

            int count = page.getMenuItemCount();
            System.out.println("Refresh #" + i + ": Menu has " + count + " items.");
            assertTrue(count >= 3, "Menu should have at least 3 items after refresh #" + i);

            Thread.sleep(3000);
        }
    }

    @Test
    public void testSpecificMenuItemExists() throws InterruptedException {
        driver.get(URL);
        Thread.sleep(3000);

        ShiftingContentMenuPage page = new ShiftingContentMenuPage(driver);

        Thread.sleep(3000);
        assertTrue(page.isMenuItemPresent("Home") || page.isMenuItemPresent("About"),
                "At least 'Home' or 'About' link should be present");
        System.out.println("Verified specific menu item exists.");
    }

    @Test
    public void testUnexpectedMenuItemNotPresent() throws InterruptedException {
        driver.get(URL);
        Thread.sleep(3000);

        ShiftingContentMenuPage page = new ShiftingContentMenuPage(driver);

        Thread.sleep(3000);
        assertFalse(page.isMenuItemPresent("InvalidLink"),
                "'InvalidLink' should NOT be present in the menu");
        System.out.println("Verified invalid menu item is not present.");
    }
}
