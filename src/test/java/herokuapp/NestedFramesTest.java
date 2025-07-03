package herokuapp;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NestedFramesTest extends BaseTest {

    @Test
    public void testMiddleFrameText() {
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        // Switch to frame hierarchy: top > middle
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");

        WebElement middleText = driver.findElement(By.id("content"));
        String actualText = middleText.getText();

        assertEquals("MIDDLE", actualText, "Middle frame text mismatch");
    }

    // Negative Test Case: Trying to access non-existent frame
    @Test
    public void testInvalidFrameAccess() {
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        Exception exception = assertThrows(org.openqa.selenium.NoSuchFrameException.class, () -> {
            driver.switchTo().frame("nonexistent-frame");
        });

        System.out.println("Negative Test Passed: " + exception.getMessage());
    }
}
