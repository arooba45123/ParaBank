package herokuapp;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IFrameTest extends BaseTest {

    @Test
    public void testIFrameTextEdit() throws InterruptedException {
        // Step 1: Open the iframe page
        driver.get("https://the-internet.herokuapp.com/iframe");

        // Step 2: Switch to the iframe
        driver.switchTo().frame("mce_0_ifr");

        // Step 3: Use JavaScript to clear and set the text
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String text = "Automation test inside iframe!";
        js.executeScript("arguments[0].innerHTML = '<p>" + text + "</p>';", 
                         driver.findElement(By.id("tinymce")));

        Thread.sleep(2000); // Pause to see the effect

        // Step 4: Get text and assert
        WebElement editor = driver.findElement(By.id("tinymce"));
        String actualText = editor.getText();
        assertEquals(text, actualText, "Editor text should match the expected text");

        System.out.println("IFrame test passed with text: " + actualText);
    }
}

