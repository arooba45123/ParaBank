package herokuapp.tests;

import herokuapp.base.BaseTest;
import herokuapp.pages.KeyPressesPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static org.junit.jupiter.api.Assertions.*;

public class KeyPressesTest extends BaseTest {

    private final String URL = "https://the-internet.herokuapp.com/key_presses";

    @Test
    public void testEnterKey() throws InterruptedException {
        driver.get(URL);
        Thread.sleep(3000);

        KeyPressesPage page = new KeyPressesPage(driver);
        page.pressKey(Keys.ENTER);
        Thread.sleep(3000);

        String result = page.getResultMessage();
        assertTrue(result.contains("ENTER"), "Result should contain 'ENTER'");
        System.out.println("ENTER key press detected: " + result);
    }

    @Test
    public void testShiftKey() throws InterruptedException {
        driver.get(URL);
        Thread.sleep(3000);

        KeyPressesPage page = new KeyPressesPage(driver);
        page.pressKey(Keys.SHIFT);
        Thread.sleep(3000);

        String result = page.getResultMessage();
        assertTrue(result.contains("SHIFT"), "Result should contain 'SHIFT'");
        System.out.println("SHIFT key press detected: " + result);
    }

    @Test
    public void testCharacterKey() throws InterruptedException {
        driver.get(URL);
        Thread.sleep(3000);

        KeyPressesPage page = new KeyPressesPage(driver);
        page.pressKey("A");
        Thread.sleep(3000);

        String result = page.getResultMessage();
        assertTrue(result.contains("A"), "Result should contain 'A'");
        System.out.println("Character A key press detected: " + result);
    }
}

