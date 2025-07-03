package herokuapp;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputFieldTest extends BaseTest {

    //  Positive Test
    @Test
    public void testInputFieldTypingAndArrowKeys() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/inputs");

        WebElement inputField = driver.findElement(By.tagName("input"));

        inputField.sendKeys("12345");
        System.out.println("Typed value: 12345");
        Thread.sleep(3000);

        String typedValue = inputField.getAttribute("value");
        assertEquals("12345", typedValue, "Typed value should be 12345");

        inputField.clear();
        Thread.sleep(3000);

        inputField.sendKeys(Keys.ARROW_UP);
        Thread.sleep(3000);
        String afterFirstUp = inputField.getAttribute("value");
        assertEquals("1", afterFirstUp, "Value after first UP arrow should be 1");

        inputField.sendKeys(Keys.ARROW_UP);
        Thread.sleep(3000);
        String afterSecondUp = inputField.getAttribute("value");
        assertEquals("2", afterSecondUp, "Value after second UP arrow should be 2");

        inputField.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(3000);
        String afterDown = inputField.getAttribute("value");
        assertEquals("1", afterDown, "Value after DOWN arrow should be 1");

        System.out.println("Final value after arrow keys: " + afterDown);
    }

    //  Negative Test 1: Alphabet Input
    @Test
    public void testAlphabetInputNotAccepted() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/inputs");

        WebElement inputField = driver.findElement(By.tagName("input"));

        inputField.sendKeys("abc");
        Thread.sleep(3000);

        String actualValue = inputField.getAttribute("value");
        assertEquals("", actualValue, "Input field should not accept alphabet characters");
        System.out.println("Alphabet input was not accepted");
    }

    // Negative Test 2: Special Characters
    @Test
    public void testSpecialCharactersNotAccepted() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/inputs");

        WebElement inputField = driver.findElement(By.tagName("input"));

        inputField.sendKeys("@#$%");
        Thread.sleep(3000);

        String actualValue = inputField.getAttribute("value");
        assertEquals("", actualValue, "Input field should not accept special characters");
        System.out.println("Special characters were not accepted");
    }
}
