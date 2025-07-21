package herokuapp.tests;

import herokuapp.base.BaseTest;
import herokuapp.pages.ShiftingContentImagePage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShiftingContentImageTest extends BaseTest {

    private final String URL = "https://the-internet.herokuapp.com/shifting_content/image";

    @Test
    public void testImageShiftsOnRefresh() throws InterruptedException {
        driver.get(URL);
        Thread.sleep(3000); // wait for initial page load

        ShiftingContentImagePage page = new ShiftingContentImagePage(driver);

        assertTrue(page.isImageDisplayed(), "Image should be displayed");
        System.out.println("Image displayed on load.");

        int xInitial = page.getImageXPosition();
        int yInitial = page.getImageYPosition();
        System.out.printf("Initial position: (%d, %d)%n", xInitial, yInitial);

        // Loop to refresh and check position
        for (int i = 1; i <= 3; i++) {
            Thread.sleep(3000);
            driver.navigate().refresh();
            Thread.sleep(3000);

            int xNew = page.getImageXPosition();
            int yNew = page.getImageYPosition();

            System.out.printf("After refresh #%d: (%d, %d)%n", i, xNew, yNew);

            assertNotEquals(xInitial, xNew, "X position should change after refresh #" + i);
            xInitial = xNew; // update for next iteration
            yInitial = yNew;
        }

        System.out.println("Image position shifted across refreshes as expected.");
    }
}
