package herokuapp.tests;

import org.junit.jupiter.api.Test;

import herokuapp.base.BaseTest;
import herokuapp.pages.CheckboxPage;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckboxTest extends BaseTest {

    @Test
    public void testCheckboxFlow() throws InterruptedException {
        CheckboxPage page = new CheckboxPage(driver);

        page.open();

        // 1. Make sure both checkboxes are unchecked
        if (page.isCheckbox1Selected()) {
            page.clickCheckbox1();
        }
        if (page.isCheckbox2Selected()) {
            page.clickCheckbox2();
        }

        System.out.println("Both checkboxes are initially unchecked");
        Thread.sleep(3000);

        // 2. Select checkbox 1
        page.clickCheckbox1();
        System.out.println("Checkbox 1 selected");
        Thread.sleep(4000);

        // 3. Unselect checkbox 1, select checkbox 2
        page.clickCheckbox1();
        page.clickCheckbox2();
        System.out.println("Checkbox 2 selected");
        Thread.sleep(4000);

        // 4. Final assertions
        assertFalse(page.isCheckbox1Selected(), "Checkbox 1 should be unchecked");
        assertTrue(page.isCheckbox2Selected(), "Checkbox 2 should be checked");
    }
}

