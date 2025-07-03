package herokuapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckboxTest extends BaseTest {

    @Test
    public void testCheckboxFlow() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkbox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));

        // 1. Make sure both checkboxes are unchecked
        if (checkbox1.isSelected()) {
            checkbox1.click();
        }
        if (checkbox2.isSelected()) {
            checkbox2.click();
        }

        System.out.println("Both checkboxes are initially unchecked");
        Thread.sleep(3000);

        // 2. Select checkbox 1
        checkbox1.click();
        System.out.println("Checkbox 1 selected");
        Thread.sleep(3000);

        // 3. Unselect checkbox 1, select checkbox 2
        checkbox1.click();
        checkbox2.click();
        System.out.println("Checkbox 2 selected");
        Thread.sleep(3000);

        // 4. Final assertions
        assertFalse(checkbox1.isSelected(), "Checkbox 1 should be unchecked");
        assertTrue(checkbox2.isSelected(), "Checkbox 2 should be checked");
    }
}

