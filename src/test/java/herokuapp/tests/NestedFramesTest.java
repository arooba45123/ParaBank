package herokuapp.tests;

import herokuapp.base.BaseTest;
import herokuapp.pages.NestedFramesPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NestedFramesTest extends BaseTest {

    @Test
    public void testMiddleFrameText() {
        NestedFramesPage page = new NestedFramesPage(driver);
        page.open();

        page.switchToMiddleFrame();
        String actualText = page.getMiddleFrameText();

        assertEquals("MIDDLE", actualText, "Middle frame text mismatch");
        System.out.println("Middle frame text verified.");
    }

    @Test
    public void testInvalidFrameAccess() {
        NestedFramesPage page = new NestedFramesPage(driver);
        page.open();

        Exception exception = assertThrows(org.openqa.selenium.NoSuchFrameException.class, page::switchToInvalidFrame);

        System.out.println("Negative test passed: " + exception.getMessage());
    }
}

