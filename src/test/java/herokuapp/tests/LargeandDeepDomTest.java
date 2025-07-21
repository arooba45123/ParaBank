package herokuapp.tests;

import herokuapp.base.BaseTest;
import herokuapp.pages.LargeandDeepDomPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LargeandDeepDomTest extends BaseTest {

    private final String URL = "https://the-internet.herokuapp.com/large";

    @Test
    public void testSpecificLargeDomCell() throws InterruptedException {
        driver.get(URL);
        Thread.sleep(3000);

        LargeandDeepDomPage page = new LargeandDeepDomPage(driver);

        String cellText = page.getTableCellText(50, 3);
        System.out.println("Cell (50,3) Text: " + cellText);

        assertNotNull(cellText, "Large DOM: Specific cell text retrieved.");
    }

    @Test
    public void testDeepDomElement() throws InterruptedException {
        driver.get(URL);
        Thread.sleep(3000);

        LargeandDeepDomPage page = new LargeandDeepDomPage(driver);

        // Example: Deeply nested element
        String deepSelector = "#large-table tr:nth-child(10) td:nth-child(5)";
        boolean isPresent = page.isDeepNestedPresent(deepSelector);

        assertTrue(isPresent, "Deep DOM: Nested element found.");
        System.out.println("Deeply nested element text: " + page.getDeepNestedText(deepSelector));
    }



    @Test
    public void testScrollToBottomAndCheck() throws InterruptedException {
        driver.get(URL);
        Thread.sleep(3000);

        LargeandDeepDomPage page = new LargeandDeepDomPage(driver);

        page.scrollToBottom();

        // Example: check if very last cell exists
        boolean lastCellExists = page.isTableCellPresent(100, 5);
        if (lastCellExists) {
            String lastCellText = page.getTableCellText(100, 5);
            System.out.println("Last Cell Text: " + lastCellText);
            assertNotNull(lastCellText, "Last cell text is retrieved after scrolling to bottom.");
        } else {
            System.out.println("Last cell does not exist — page might not be that deep.");
        }
    }
}
