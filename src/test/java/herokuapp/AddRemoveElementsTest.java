package herokuapp;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddRemoveElementsTest extends BaseTest {

    @Test
    public void testAddAndRemoveElements() throws InterruptedException {
        // Step 1: Open the Add/Remove Elements page
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        // Step 2: Click the "Add Element" button
        WebElement addButton = driver.findElement(By.xpath("//button[text()='Add Element']"));
        addButton.click();
        System.out.println("Clicked 'Add Element'");

        // Step 3: Wait for 3 seconds so element can be added
        Thread.sleep(3000);

        // Step 4: Find the "Delete" button
        WebElement deleteButton = driver.findElement(By.className("added-manually"));

        // Step 5: Assert the Delete button is displayed
        assertTrue(deleteButton.isDisplayed(), "Delete button is not visible!");
        System.out.println("'Delete' button appeared");

        // Step 6: Click the Delete button
        deleteButton.click();
        System.out.println("'Delete' button clicked");

        // Step 7: Wait 3 seconds to visually confirm
        Thread.sleep(3000);
    }
}
