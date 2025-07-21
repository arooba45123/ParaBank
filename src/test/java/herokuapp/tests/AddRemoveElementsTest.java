package herokuapp.tests;

import org.junit.jupiter.api.Test;

import herokuapp.base.BaseTest;
import herokuapp.pages.AddRemoveElementsPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddRemoveElementsTest extends BaseTest {

    @Test
    public void testAddAndRemoveElements() throws InterruptedException {
        AddRemoveElementsPage page = new AddRemoveElementsPage(driver);

        // Step 1: Open the page
        page.open();
        System.out.println("Opened Add/Remove Elements page");

        // Step 2: Click Add Element
        page.clickAddElement();
        System.out.println("Clicked 'Add Element'");

        Thread.sleep(4000);

        // Step 3: Verify Delete button appears
        assertTrue(page.isDeleteButtonDisplayed(), "Delete button is not visible!");
        System.out.println("'Delete' button appeared");

        // Step 4: Click Delete
        page.clickDeleteButton();
        System.out.println("'Delete' button clicked");

        Thread.sleep(4000);
    }
}
