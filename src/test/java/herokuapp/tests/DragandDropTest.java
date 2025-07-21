package herokuapp.tests;

import herokuapp.base.BaseTest;
import herokuapp.pages.DragandDropPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DragandDropTest extends BaseTest {

    @Test
    public void testDragAndDropColumns() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        DragandDropPage dragAndDropPage = new DragandDropPage(driver);

        // Get initial texts
        String initialA = dragAndDropPage.getColumnAText();
        String initialB = dragAndDropPage.getColumnBText();

        System.out.println("Before Drag: Column A = " + initialA + ", Column B = " + initialB);

        // Perform drag and drop
        dragAndDropPage.dragAtoB();

        Thread.sleep(4000);

        // Get texts after drag & drop
        String afterA = dragAndDropPage.getColumnAText();
        String afterB = dragAndDropPage.getColumnBText();

        System.out.println("After Drag: Column A = " + afterA + ", Column B = " + afterB);

        // Assert that columns swapped
        assertEquals(initialB, afterA, "Column A should now have what Column B had before");
        assertEquals(initialA, afterB, "Column B should now have what Column A had before");

        System.out.println("Drag and drop completed: Columns swapped correctly.");
    }
}

