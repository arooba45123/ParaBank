package herokuapp.tests;

import org.junit.jupiter.api.Test;

import herokuapp.base.BaseTest;
import herokuapp.pages.DynamicLoadingPage;

import static org.junit.jupiter.api.Assertions.*;

public class DynamicLoadingTest extends BaseTest {

    @Test
    public void testDynamicLoadingExample1_Positive() throws InterruptedException {
        DynamicLoadingPage page = new DynamicLoadingPage(driver);

        page.openExample1();
        page.clickStartButton();

        Thread.sleep(6000);

        String actualText = page.getFinishText();
        assertEquals("Hello World!", actualText, "Example 1 Positive: Expected 'Hello World!' to appear.");
        System.out.println("Example 1 Positive: 'Hello World!' displayed as expected.");
    }

    @Test
    public void testDynamicLoadingExample1_Negative() throws InterruptedException {
        DynamicLoadingPage page = new DynamicLoadingPage(driver);

        page.openExample1();
        page.clickStartButton();

        Thread.sleep(6000);

        String actualText = page.getFinishText();
        assertNotEquals("Goodbye World!", actualText, "Example 1 Negative: Text should not be 'Goodbye World!'");
        System.out.println("Example 1 Negative: 'Goodbye World!' was NOT displayed (as expected).");
    }

    @Test
    public void testDynamicLoadingExample2_Positive() throws InterruptedException {
        DynamicLoadingPage page = new DynamicLoadingPage(driver);

        page.openExample2();
        page.clickStartButton();

        Thread.sleep(6000);

        String actualText = page.getFinishText();
        assertEquals("Hello World!", actualText, "Example 2 Positive: Expected 'Hello World!' to appear.");
        System.out.println("Example 2 Positive: 'Hello World!' displayed as expected.");
    }

    @Test
    public void testDynamicLoadingExample2_Negative() throws InterruptedException {
        DynamicLoadingPage page = new DynamicLoadingPage(driver);

        page.openExample2();
        page.clickStartButton();

        Thread.sleep(6000);

        String actualText = page.getFinishText();
        assertNotEquals("Goodbye World!", actualText, "Example 2 Negative: Text should not be 'Goodbye World!'");
        System.out.println("Example 2 Negative: 'Goodbye World!' was NOT displayed (as expected).");
    }
}

