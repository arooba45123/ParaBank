package herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DisappearingElementsPage {
    private WebDriver driver;

    private final By menuItems = By.cssSelector("#content ul li a");

    public DisappearingElementsPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getMenuItems() {
        return driver.findElements(menuItems);
    }

    public void clickMenuItem(String menuName) {
        for (WebElement item : getMenuItems()) {
            if (item.getText().equalsIgnoreCase(menuName)) {
                item.click();
                break;
            }
        }
    }

    public String getPageHeading() {
        List<WebElement> headings = driver.findElements(By.tagName("h1"));
        if (!headings.isEmpty()) {
            return headings.get(0).getText();
        } else {
            return "Not Found";  // fallback value
        }
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}

