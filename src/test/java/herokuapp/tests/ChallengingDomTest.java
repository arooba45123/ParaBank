package herokuapp.tests;

import herokuapp.base.BaseTest;
import herokuapp.pages.ChallengingDomPage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ChallengingDomTest extends BaseTest {

    private final String URL = "https://the-internet.herokuapp.com/challenging_dom";

    @Test
    public void testButtonsAreClickable() throws InterruptedException {
        driver.get(URL);
        Thread.sleep(3000);

        ChallengingDomPage page = new ChallengingDomPage(driver);

        // Try clicking each button
        page.clickBlueButton();
        System.out.println("Blue button clicked successfully.");

        page.clickRedButton();
        System.out.println("Red button clicked successfully.");

        page.clickGreenButton();
        System.out.println("Green button clicked successfully.");

        // No exceptions means pass
        assertTrue(true, "All buttons are clickable.");
    }

    @Test
    public void testSpecificTableCellValue() throws InterruptedException {
        driver.get(URL);
        Thread.sleep(3000);

        ChallengingDomPage page = new ChallengingDomPage(driver);

        // Example: Validate cell Row 1, Column 1
        String cellText = page.getTableCellText(1, 1);
        System.out.println("Row 1, Col 1 Text: " + cellText);

        assertFalse(cellText.isEmpty(), "Table cell (1,1) should not be empty.");

    }
}


