package herokuapp.tests;

import herokuapp.base.BaseTest;
import herokuapp.pages.SortableDataTablesPage;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SortableDataTablesTest extends BaseTest {

    private final String URL = "https://the-internet.herokuapp.com/tables";

    @Test
    public void testSortTable1ByLastNameAscending() throws InterruptedException {
        driver.get(URL);
        Thread.sleep(4000);

        SortableDataTablesPage page = new SortableDataTablesPage(driver);

        int colIndex = page.getColumnIndex(1, "Last Name");

        // Before sorting
        List<String> beforeSort = page.getColumnValues(1, colIndex);

        // Click header to sort
        page.clickHeader(1, "Last Name");
        Thread.sleep(1000);

        // After sorting
        List<String> afterSort = page.getColumnValues(1, colIndex);

        // Make a copy of afterSort and sort it manually
        List<String> sorted = new ArrayList<>(afterSort);
        Collections.sort(sorted);

        assertEquals(sorted, afterSort, "Table 1: Last Name should be sorted ascending.");
    }

    @Test    
    public void testSortTable2ByDueDescending() throws InterruptedException {
        driver.get(URL);
        Thread.sleep(4000);

        SortableDataTablesPage page = new SortableDataTablesPage(driver);

        int colIndex = page.getColumnIndex(2, "Due");

        // Click header twice to sort descending
        page.clickHeader(2, "Due");
        Thread.sleep(4000);
        page.clickHeader(2, "Due");
        Thread.sleep(4000);

        // After sorting
        List<String> afterSort = page.getColumnValues(2, colIndex);

        // Remove $ and convert to Double for comparison
        List<Double> dueAmounts = new ArrayList<>();
        for (String value : afterSort) {
            dueAmounts.add(Double.parseDouble(value.replace("$", "")));
        }

        // Check if sorted descending
        for (int i = 0; i < dueAmounts.size() - 1; i++) {
            assertTrue(dueAmounts.get(i) >= dueAmounts.get(i + 1),
                    "Table 2: Due should be sorted descending.");
        }
    }
}
