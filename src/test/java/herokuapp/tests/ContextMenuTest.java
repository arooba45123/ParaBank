package herokuapp.tests;

import herokuapp.base.BaseTest;
import herokuapp.pages.ContextMenuPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContextMenuTest extends BaseTest {

    ContextMenuPage contextMenuPage;

    @Test
    public void testRightClickShowsAlert_Positive() {
        contextMenuPage = new ContextMenuPage(driver);
        contextMenuPage.open();

        contextMenuPage.rightClickInBox();
        String alertText = contextMenuPage.getAlertText();

        assertEquals("You selected a context menu", alertText, "Alert text should match.");
        contextMenuPage.acceptAlert();
        System.out.println("Positive: Alert appeared and was accepted.");
    }

    @Test
    public void testRightClickOutside_NoAlert_Negative() {
        contextMenuPage = new ContextMenuPage(driver);
        contextMenuPage.open();

        contextMenuPage.rightClickOutsideBox();

        boolean alertPresent = contextMenuPage.isAlertPresent();
        assertFalse(alertPresent, "No alert should appear when right-clicking outside the box.");
        System.out.println("Negative: No alert when right-clicking outside the hotspot.");
    }

    @Test
    public void testLeftClickInBox_NoAlert_Negative() {
        contextMenuPage = new ContextMenuPage(driver);
        contextMenuPage.open();

        contextMenuPage.leftClickInBox();

        boolean alertPresent = contextMenuPage.isAlertPresent();
        assertFalse(alertPresent, "No alert should appear when left-clicking the box.");
        System.out.println("Negative: No alert when left-clicking inside the hotspot.");
    }
}
