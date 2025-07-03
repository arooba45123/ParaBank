package herokuapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownTest extends BaseTest {

    @Test
    public void testDropdownSelection() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
        Select dropdown = new Select(dropdownElement);
        
        // Select Option 1
        dropdown.selectByVisibleText("Option 1");
        System.out.println("Option 1 selected");
        Thread.sleep(3000); // Just to keep browser open for 3 sec so you can see
        
        // Assertion
        WebElement selected = dropdown.getFirstSelectedOption();
        assertEquals("Option 1", selected.getText()); 
        System.out.println("Assertion passed: Option 1 is selected");

        // Select Option 2
        dropdown.selectByVisibleText("Option 2");
        System.out.println("Option 2 selected");
        Thread.sleep(2000);  
        
        // Assertion
        WebElement selected2 = dropdown.getFirstSelectedOption();
        assertEquals("Option 2", selected2.getText()); 
        System.out.println("Assertion passed: Option 2 is selected");
    }
}
