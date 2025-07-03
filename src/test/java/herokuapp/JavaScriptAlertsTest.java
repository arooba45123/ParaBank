package herokuapp;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaScriptAlertsTest extends BaseTest {

    @Test
    public void testSimpleAlert() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // Click the "Click for JS Alert" button
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

        // Switch to alert and accept it
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        assertEquals("I am a JS Alert", alertText, "Alert text should match expected message");
        alert.accept();

        // Verify result message
        String result = driver.findElement(By.id("result")).getText();
        assertEquals("You successfully clicked an alert", result);
        System.out.println("Simple Alert Test Passed");
        Thread.sleep(3000);
    }

    @Test
    public void testConfirmAlert_OK() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // Click the "Click for JS Confirm" button
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();

        Alert alert = driver.switchTo().alert();
        assertEquals("I am a JS Confirm", alert.getText());
        alert.accept(); // Click OK

        String result = driver.findElement(By.id("result")).getText();
        assertEquals("You clicked: Ok", result);
        System.out.println("Confirm Alert OK Test Passed");
        Thread.sleep(3000);
    }

    @Test
    public void testConfirmAlert_Cancel() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss(); // Click Cancel

        String result = driver.findElement(By.id("result")).getText();
        assertEquals("You clicked: Cancel", result);
        System.out.println("Confirm Alert Cancel Test Passed");
        Thread.sleep(3000);
    }

    @Test
    public void testPromptAlert() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Hello Arooba!"); // Input text into prompt
        alert.accept(); // Click OK

        String result = driver.findElement(By.id("result")).getText();
        assertEquals("You entered: Hello Arooba!", result);
        System.out.println("Prompt Alert Test Passed");
        Thread.sleep(3000);
    }

    @Test
    public void testPromptAlert_Cancel() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss(); // Click Cancel

        String result = driver.findElement(By.id("result")).getText();
        assertEquals("You entered: null", result);
        System.out.println("Prompt Cancel Test Passed");
        Thread.sleep(3000);
    }
}
