package herokuapp;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;

public class DynamicControlsTest extends BaseTest {

    @Test
    public void testDynamicControlsUsingSleep() throws InterruptedException {
        // Step 1: Open the Dynamic Controls page
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // Step 2: Remove checkbox
        WebElement removeButton = driver.findElement(By.xpath("//button[text()='Remove']"));
        removeButton.click();

        Thread.sleep(4000); // Wait for checkbox to disappear

        // Try to find the checkbox again, handle if it's gone
        boolean checkboxGone = driver.findElements(By.id("checkbox")).isEmpty();
        assertTrue(checkboxGone, "Checkbox should be removed");
        System.out.println("Checkbox removed");

        // Step 3: Add checkbox again
        WebElement addButton = driver.findElement(By.xpath("//button[text()='Add']"));
        addButton.click();

        Thread.sleep(4000); // Wait for checkbox to reappear

        WebElement checkboxBack = driver.findElement(By.id("checkbox"));
        assertTrue(checkboxBack.isDisplayed(), "Checkbox should be back");
        System.out.println("Checkbox added again");

        // Step 4: Enable text field
        WebElement enableButton = driver.findElement(By.xpath("//button[text()='Enable']"));
        enableButton.click();

        Thread.sleep(4000); // Wait for it to become enabled

        WebElement inputField = driver.findElement(By.xpath("//form[@id='input-example']/input"));
        assertTrue(inputField.isEnabled(), "Text field should be enabled");
        inputField.sendKeys("Testing with sleep");
        System.out.println("Text entered");

        // Step 5: Disable text field
        WebElement disableButton = driver.findElement(By.xpath("//button[text()='Disable']"));
        disableButton.click();

        Thread.sleep(4000); // Wait to disable

        assertFalse(inputField.isEnabled(), "Text field should be disabled");
        System.out.println("Text field disabled");
    }
}
