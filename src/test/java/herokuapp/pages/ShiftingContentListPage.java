package herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShiftingContentListPage {

    private WebDriver driver;

    private final By listItems = By.cssSelector("#content ul li");

    public ShiftingContentListPage(WebDriver driver) {
        this.driver = driver;
    }

    // Get all list items as WebElements
    public List<WebElement> getAllListItems() {
        return driver.findElements(listItems);
    }

    // Get list items' text as List<String>
    public List<String> getAllListTexts() {
        return driver.findElements(listItems).stream()
                .map(e -> e.getText().trim())
                .toList();
    }

    // Count of list items
    public int getListItemCount() {
        return driver.findElements(listItems).size();
    }

    // Check if specific text is present
    public boolean isTextPresent(String text) {
        return driver.findElements(listItems).stream()
                .anyMatch(e -> e.getText().trim().equalsIgnoreCase(text));
    }
}
