package herokuapp.tests;

import herokuapp.base.BaseTest;
import herokuapp.pages.EntryAdPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EntryAdTest extends BaseTest {

    
     // Positive Test: Verify that the Entry Ad modal appears on page load and can be closed successfully.
     
    @Test
    public void testEntryAdModalAppearsAndCanBeClosed() {
        driver.get("https://the-internet.herokuapp.com/entry_ad");

        EntryAdPage entryAdPage = new EntryAdPage(driver);

        // Check that modal appears
        assertTrue(entryAdPage.isModalDisplayed(), "Modal should appear on page load");
        System.out.println("Positive Test: Modal displayed with title: " + entryAdPage.getModalTitle());

        // Close the modal
        entryAdPage.closeModal();
        System.out.println("Positive Test: Modal closed successfully");
    }

    
     // Negative Test 1: Verify that the modal does NOT display unexpected text in the title.
     
    @Test
    public void testModalTitleDoesNotHaveUnexpectedText() {
        driver.get("https://the-internet.herokuapp.com/entry_ad");

        EntryAdPage entryAdPage = new EntryAdPage(driver);

        String actualTitle = entryAdPage.getModalTitle();
        assertNotEquals("Unexpected Title", actualTitle, "Modal title should not be 'Unexpected Title'");
        System.out.println("Negative Test 1: Modal title is correct and not unexpected.");
    }

    
      // Negative Test 2: Verify that the modal is no longer visible or click able after being closed.
     
    @Test
    public void testModalNotVisibleAfterClose() {
        driver.get("https://the-internet.herokuapp.com/entry_ad");

        EntryAdPage entryAdPage = new EntryAdPage(driver);

        // Check modal appears
        assertTrue(entryAdPage.isModalDisplayed(), "Modal should appear on page load");
        System.out.println("Modal displayed initially");

        // Close modal
        entryAdPage.closeModal();
        System.out.println("Modal closed");

        // Verify modal no longer visible
        boolean modalStillVisible;
        try {
            modalStillVisible = entryAdPage.isModalDisplayed();
        } catch (Exception e) {
            modalStillVisible = false; // Modal element is not found anymore
        }

        assertFalse(modalStillVisible, "Modal should NOT remain visible or clickable after closing.");
        System.out.println("Negative Test 2: Modal not visible after closing (as expected).");
    }
}
