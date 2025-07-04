package herokuapp.tests;

import org.junit.jupiter.api.Test;

import herokuapp.base.BaseTest;
import herokuapp.pages.DynamicControlsPage;

import static org.junit.jupiter.api.Assertions.*;

public class DynamicControlsTest extends BaseTest {

    @Test
    public void testDynamicControlsUsingSleep() throws InterruptedException {
        DynamicControlsPage page = new DynamicControlsPage(driver);

        // Step 1: Open the page
        page.open();

        // Step 2: Remove checkbox
        page.clickRemoveButton();
        Thread.sleep(4000);
        assertTrue(page.isCheckboxGone(), "Checkbox should be removed");
        System.out.println("Checkbox removed");

        // Step 3: Add checkbox again
        page.clickAddButton();
        Thread.sleep(4000);
        assertTrue(page.isCheckboxDisplayed(), "Checkbox should be back");
        System.out.println("Checkbox added again");

        // Step 4: Enable text field
        page.clickEnableButton();
        Thread.sleep(4000);
        assertTrue(page.isInputEnabled(), "Text field should be enabled");
        page.enterTextInInput("Testing with sleep");
        System.out.println("Text entered");

        // Step 5: Disable text field
        page.clickDisableButton();
        Thread.sleep(4000);
        assertFalse(page.isInputEnabled(), "Text field should be disabled");
        System.out.println("Text field disabled");
    }
}

