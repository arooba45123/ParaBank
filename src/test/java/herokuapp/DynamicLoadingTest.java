package herokuapp;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;

public class DynamicLoadingTest extends BaseTest {

    
      // Positive Test: Example 1 Verify that "Hello World!" is displayed after loading completes.
     
    @Test
    public void testDynamicLoadingExample1_Positive() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        WebElement startButton = driver.findElement(By.cssSelector("#start button"));
        startButton.click();

        Thread.sleep(6000); // Wait for loading to finish

        WebElement finishElement = driver.findElement(By.id("finish"));
        String actualText = finishElement.getText();

        assertEquals("Hello World!", actualText, "Example 1 Positive: Expected 'Hello World!' to appear.");
        System.out.println("✅ Example 1 Positive: 'Hello World!' displayed as expected.");
    }

    
      // Negative Test: Example 1 Verify that incorrect text does NOT appear.
     
    @Test
    public void testDynamicLoadingExample1_Negative() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        WebElement startButton = driver.findElement(By.cssSelector("#start button"));
        startButton.click();

        Thread.sleep(6000);

        WebElement finishElement = driver.findElement(By.id("finish"));
        String actualText = finishElement.getText();

        assertNotEquals("Goodbye World!", actualText, "Example 1 Negative: Text should not be 'Goodbye World!'");
        System.out.println("🚩 Example 1 Negative: 'Goodbye World!' was NOT displayed (as expected).");
    }

    
      // Positive Test: Example 2 Verify that "Hello World!" is displayed after loading completes.
     
    @Test
    public void testDynamicLoadingExample2_Positive() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");

        WebElement startButton = driver.findElement(By.cssSelector("#start button"));
        startButton.click();

        Thread.sleep(6000);

        WebElement finishElement = driver.findElement(By.id("finish"));
        String actualText = finishElement.getText();

        assertEquals("Hello World!", actualText, "Example 2 Positive: Expected 'Hello World!' to appear.");
        System.out.println("✅ Example 2 Positive: 'Hello World!' displayed as expected.");
    }

    
     // Negative Test: Example 2 Verify that incorrect text does NOT appear.
     
    @Test
    public void testDynamicLoadingExample2_Negative() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");

        WebElement startButton = driver.findElement(By.cssSelector("#start button"));
        startButton.click();

        Thread.sleep(6000);

        WebElement finishElement = driver.findElement(By.id("finish"));
        String actualText = finishElement.getText();

        assertNotEquals("Goodbye World!", actualText, "Example 2 Negative: Text should not be 'Goodbye World!'");
        System.out.println("🚩 Example 2 Negative: 'Goodbye World!' was NOT displayed (as expected).");
    }
}


