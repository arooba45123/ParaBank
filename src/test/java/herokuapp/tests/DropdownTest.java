package herokuapp.tests;

import org.junit.jupiter.api.Test;

import herokuapp.base.BaseTest;
import herokuapp.pages.DropdownPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DropdownTest extends BaseTest {

    @Test
    public void testDropdownSelection() throws InterruptedException {
        DropdownPage page = new DropdownPage(driver);

        page.open();

        // Select Option 1
        page.selectOptionByVisibleText("Option 1");
        System.out.println("Option 1 selected");
        Thread.sleep(4000);

        // Assertion
        assertEquals("Option 1", page.getSelectedOption());
        System.out.println("Assertion passed: Option 1 is selected");

        // Select Option 2
        page.selectOptionByVisibleText("Option 2");
        System.out.println("Option 2 selected");
        Thread.sleep(4000);

        // Assertion
        assertEquals("Option 2", page.getSelectedOption());
        System.out.println("Assertion passed: Option 2 is selected");
    }
}

