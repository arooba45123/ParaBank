package herokuapp.tests;

import org.junit.jupiter.api.Test;

import herokuapp.base.BaseTest;
import herokuapp.pages.IFramePage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IFrameTest extends BaseTest {

    @Test
    public void testIFrameTextEdit() throws InterruptedException {
        IFramePage page = new IFramePage(driver);

        // Step 1: Open page
        page.open();

        // Step 2: Switch to iframe
        page.switchToIFrame();

        // Step 3: Set text
        String text = "Automation test inside iframe!";
        page.setTextInEditor(text);

        Thread.sleep(4000); // Pause to see effect

        // Step 4: Verify text
        String actualText = page.getEditorText();
        assertEquals(text, actualText, "Editor text should match the expected text");

        System.out.println("IFrame test passed with text: " + actualText);
    }
}

