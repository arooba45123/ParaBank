package herokuapp.tests;

import herokuapp.base.BaseTest;
import herokuapp.pages.MultipleWindowsPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MultipleWindowsTest extends BaseTest {

    @Test
    public void testMultipleWindows_Positive() {
        MultipleWindowsPage page = new MultipleWindowsPage(driver);
        page.open();

        String mainWindow = page.getMainWindowHandle();
        page.clickHere();

        String newWindow = page.getNewWindowHandle(mainWindow);
        assertNotNull(newWindow, "New window handle should not be null.");
        page.switchToWindow(newWindow);

        String headerText = page.getHeaderText();
        assertEquals("New Window", headerText, "Expected 'New Window' text.");
        System.out.println("Positive: New Window displayed as expected.");
    }

    @Test
    public void testMultipleWindows_Negative() {
        MultipleWindowsPage page = new MultipleWindowsPage(driver);
        page.open();

        String mainWindow = page.getMainWindowHandle();
        page.clickHere();

        String newWindow = page.getNewWindowHandle(mainWindow);
        assertNotNull(newWindow, "New window handle should not be null.");
        page.switchToWindow(newWindow);

        String headerText = page.getHeaderText();
        assertNotEquals("Old Window", headerText, "Text should not be 'Old Window'.");
        System.out.println("Negative: Old Window NOT displayed, as expected.");
    }

    @Test
    public void testCloseNewWindowAndSwitchBack() {
        MultipleWindowsPage page = new MultipleWindowsPage(driver);
        page.open();

        String mainWindow = page.getMainWindowHandle();
        page.clickHere();

        String newWindow = page.getNewWindowHandle(mainWindow);
        assertNotNull(newWindow, "New window handle should not be null.");
        page.switchToWindow(newWindow);

        page.closeCurrentWindow();
        System.out.println("Closed the new window.");

        page.switchToWindow(mainWindow);

        String title = page.getTitle();
        assertEquals("The Internet", title, "Should return to main window.");
        System.out.println("Switched back to main window.");
    }
}

