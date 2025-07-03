package herokuapp;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class MultipleWindowsTest extends BaseTest {

    // Positive Test: Verify that "New Window" is displayed in the new window.
    @Test
    public void testMultipleWindows_Positive() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");

        String mainWindow = driver.getWindowHandle();

        WebElement clickHereLink = driver.findElement(By.linkText("Click Here"));
        clickHereLink.click();

        Thread.sleep(4000); // Wait for new window to load

        Set<String> allWindows = driver.getWindowHandles();
        String newWindow = null;

        for (String window : allWindows) {
            if (!window.equals(mainWindow)) {
                newWindow = window;
                break;
            }
        }

        assertNotNull(newWindow, "Positive: New window handle should not be null.");
        driver.switchTo().window(newWindow);

        WebElement header = driver.findElement(By.tagName("h3"));
        String actualText = header.getText();

        assertEquals("New Window", actualText, "Positive: Expected 'New Window' text.");
        System.out.println("Positive: 'New Window' text displayed in the new window as expected.");
    }

    // Negative Test: Verify that incorrect text is NOT displayed in the new window.
    @Test
    public void testMultipleWindows_Negative() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");

        String mainWindow = driver.getWindowHandle();

        WebElement clickHereLink = driver.findElement(By.linkText("Click Here"));
        clickHereLink.click();

        Thread.sleep(4000); // Wait for new window to load

        Set<String> allWindows = driver.getWindowHandles();
        String newWindow = null;

        for (String window : allWindows) {
            if (!window.equals(mainWindow)) {
                newWindow = window;
                break;
            }
        }

        assertNotNull(newWindow, "Negative: New window handle should not be null.");
        driver.switchTo().window(newWindow);

        WebElement header = driver.findElement(By.tagName("h3"));
        String actualText = header.getText();

        assertNotEquals("Old Window", actualText, "Negative: Text should not be 'Old Window'.");
        System.out.println("Negative: 'Old Window' was NOT displayed in the new window (as expected).");
    }

    // Additional Test: Close new window and switch back to main window.
    @Test
    public void testCloseNewWindowAndSwitchBack() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");

        String mainWindow = driver.getWindowHandle();

        WebElement clickHereLink = driver.findElement(By.linkText("Click Here"));
        clickHereLink.click();

        Thread.sleep(4000); // Wait for new window to load

        Set<String> allWindows = driver.getWindowHandles();
        String newWindow = null;

        for (String window : allWindows) {
            if (!window.equals(mainWindow)) {
                newWindow = window;
                break;
            }
        }

        assertNotNull(newWindow, "Close & Switch: New window handle should not be null.");
        driver.switchTo().window(newWindow);

        // Close the new window
        driver.close();
        System.out.println("Closed the new window.");

        // Switch back to the main window
        driver.switchTo().window(mainWindow);

        String currentTitle = driver.getTitle();
        assertEquals("The Internet", currentTitle, "Close & Switch: Should return to main window.");
        System.out.println("Switched back to the main window successfully.");
    }
}

