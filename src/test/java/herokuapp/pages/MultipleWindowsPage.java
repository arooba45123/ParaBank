package herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class MultipleWindowsPage {
    private WebDriver driver;

    // Constructor
    public MultipleWindowsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By clickHereLink = By.linkText("Click Here");
    private By header = By.tagName("h3");

    // Actions
    public void open() {
        driver.get("https://the-internet.herokuapp.com/windows");
    }

    public void clickHere() {
        driver.findElement(clickHereLink).click();
    }

    public String getMainWindowHandle() {
        return driver.getWindowHandle();
    }

    public String getNewWindowHandle(String mainWindow) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(mainWindow)) {
                return window;
            }
        }
        return null;
    }

    public void switchToWindow(String windowHandle) {
        driver.switchTo().window(windowHandle);
    }

    public void closeCurrentWindow() {
        driver.close();
    }

    public String getHeaderText() {
        return driver.findElement(header).getText();
    }

    public String getTitle() {
        return driver.getTitle();
    }
}

