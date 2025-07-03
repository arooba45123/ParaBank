package herokuapp;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HoverTest extends BaseTest {

    @Test
    public void testHoverOverAllImagesAndProfiles() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/hovers");
        Actions actions = new Actions(driver);

        for (int i = 1; i <= 3; i++) {
            // Step 1: Hover over image
            WebElement image = driver.findElement(By.xpath("(//div[@class='figure'])[" + i + "]"));
            actions.moveToElement(image).perform();
            System.out.println("Hovered over image " + i);

            Thread.sleep(4000);

            // Step 2: Get the user name and print
            WebElement userName = driver.findElement(By.xpath("(//div[@class='figcaption']/h5)[" + i + "]"));
            System.out.println("Found user: " + userName.getText());
            assertTrue(userName.isDisplayed(), "User name should be visible");

            // Step 3: Click on 'View profile'
            WebElement viewProfile = driver.findElement(By.xpath("(//div[@class='figcaption']/a)[" + i + "]"));
            viewProfile.click();
            System.out.println("Clicked on View Profile of user " + i);

            Thread.sleep(4000);

            // Step 4: Validate that the Not Found page is shown
            WebElement notFoundMessage = driver.findElement(By.tagName("h1"));
            assertTrue(notFoundMessage.getText().contains("Not Found"), "❌ Profile not found message should appear");
            System.out.println("Result: " + notFoundMessage.getText());

            // Step 5: Go back to Hovers page
            driver.navigate().back();
            Thread.sleep(4000);
        }
    }
}

