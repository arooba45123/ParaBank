package herokuapp.tests;

import herokuapp.base.BaseTest;
import herokuapp.pages.EntryAdPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EntryAdTest extends BaseTest {

    private final String url = "https://the-internet.herokuapp.com/entry_ad";

    @Test
    public void testEntryAdModalAppearsAndCanBeClosed() {
        driver.manage().deleteAllCookies();
        driver.get(url);

        EntryAdPage entryAdPage = new EntryAdPage(driver);

        assertTrue(entryAdPage.waitForModalDisplayed(), "Modal should appear on page load");
        System.out.println("Positive Test: Modal displayed with title: " + entryAdPage.getModalTitle());

        entryAdPage.closeModal();
        System.out.println("Positive Test: Modal closed successfully");
    }

    @Test
    public void testModalTitleDoesNotHaveUnexpectedText() {
        driver.manage().deleteAllCookies();
        driver.get(url);

        EntryAdPage entryAdPage = new EntryAdPage(driver);

        assertTrue(entryAdPage.waitForModalDisplayed(), "Modal should appear on page load");

        String actualTitle = entryAdPage.getModalTitle();
        assertNotEquals("Unexpected Title", actualTitle, "Modal title should not be 'Unexpected Title'");
        System.out.println("Negative Test 1: Modal title is correct and not unexpected.");
    }

    @Test
    public void testModalNotVisibleAfterClose() {
        driver.manage().deleteAllCookies();
        driver.get(url);

        EntryAdPage entryAdPage = new EntryAdPage(driver);

        assertTrue(entryAdPage.waitForModalDisplayed(), "Modal should appear on page load");
        System.out.println("Modal displayed initially");

        entryAdPage.closeModal();
        System.out.println("Modal closed");

        boolean modalStillVisible;
        try {
            modalStillVisible = entryAdPage.waitForModalDisplayed();
        } catch (Exception e) {
            modalStillVisible = false; // Modal element is not found anymore
        }

        assertFalse(modalStillVisible, "Modal should NOT remain visible or clickable after closing.");
        System.out.println("Negative Test 2: Modal not visible after closing (as expected).");
    }
}

