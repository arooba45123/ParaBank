package herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ShiftingContentMenuPage {

    private WebDriver driver;

    private By menuItems = By.cssSelector("#content ul li a");

    public ShiftingContentMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public int getMenuItemCount() {
        return driver.findElements(menuItems).size();
    }

    public boolean isMenuItemPresent(String menuText) {
        List<WebElement> items = driver.findElements(menuItems);
        for (WebElement item : items) {
            if (item.getText().trim().equalsIgnoreCase(menuText)) {
                return true;
            }
        }
        return false;
    }
}
