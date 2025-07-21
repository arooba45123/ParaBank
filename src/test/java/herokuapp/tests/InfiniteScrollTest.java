package herokuapp.tests;

import herokuapp.base.BaseTest;
import herokuapp.pages.InfiniteScrollPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InfiniteScrollTest extends BaseTest {

    @Test
    public void testInfiniteScrollLoadsMoreContent() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/infinite_scroll");
        Thread.sleep(3000); // Wait for initial page load

        InfiniteScrollPage page = new InfiniteScrollPage(driver);

        int initialCount = page.getParagraphCount();
        System.out.println("Initial paragraph count: " + initialCount);

        // Scroll 3 times
        for (int i = 1; i <= 3; i++) {
            page.scrollDown();
            int newCount = page.getParagraphCount();
            System.out.println("After scroll #" + i + ", paragraph count: " + newCount);
            assertTrue(newCount > initialCount, "New content should load after scrolling.");
            initialCount = newCount;
        }

        System.out.println("Infinite Scroll test passed: More content loaded successfully.");
    }
}
