package herokuapp.tests;

import org.junit.jupiter.api.Test;

import herokuapp.base.BaseTest;
import herokuapp.pages.InputFieldPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputFieldTest extends BaseTest {

    // Positive Test
    @Test
    public void testInputFieldTypingAndArrowKeys() throws InterruptedException {
        InputFieldPage page = new InputFieldPage(driver);

        page.open();

        page.typeValue("12345");
        System.out.println("Typed value: 12345");
        Thread.sleep(3000);

        assertEquals("12345", page.getFieldValue(), "Typed value should be 12345");

        page.clearField();
        Thread.sleep(4000);

        page.pressArrowUp();
        Thread.sleep(4000);
        assertEquals("1", page.getFieldValue(), "Value after first UP arrow should be 1");

        page.pressArrowUp();
        Thread.sleep(4000);
        assertEquals("2", page.getFieldValue(), "Value after second UP arrow should be 2");

        page.pressArrowDown();
        Thread.sleep(4000);
        assertEquals("1", page.getFieldValue(), "Value after DOWN arrow should be 1");

        System.out.println("Final value after arrow keys: " + page.getFieldValue());
    }

    // Negative Test 1: Alphabet Input
    @Test
    public void testAlphabetInputNotAccepted() throws InterruptedException {
        InputFieldPage page = new InputFieldPage(driver);

        page.open();

        page.typeValue("abc");
        Thread.sleep(4000);

        assertEquals("", page.getFieldValue(), "Input field should not accept alphabet characters");
        System.out.println("Alphabet input was not accepted");
    }

    // Negative Test 2: Special Characters
    @Test
    public void testSpecialCharactersNotAccepted() throws InterruptedException {
        InputFieldPage page = new InputFieldPage(driver);

        page.open();

        page.typeValue("@#$%");
        Thread.sleep(4000);

        assertEquals("", page.getFieldValue(), "Input field should not accept special characters");
        System.out.println("Special characters were not accepted");
    }
}

