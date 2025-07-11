package herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LargeandDeepDomPage {

    private WebDriver driver;

    public LargeandDeepDomPage(WebDriver driver) {
        this.driver = driver;
    }

    // Dynamic locator for table cells
    private String tableCellLocator(int row, int col) {
        return String.format("#large-table tr:nth-child(%d) td:nth-child(%d)", row, col);
    }

    public String getTableCellText(int row, int col) {
        return driver.findElement(By.cssSelector(tableCellLocator(row, col))).getText().trim();
    }

    public boolean isTableCellPresent(int row, int col) {
        try {
            driver.findElement(By.cssSelector(tableCellLocator(row, col)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public WebElement getDeepNestedElement(String cssSelector) {
        return driver.findElement(By.cssSelector(cssSelector));
    }

    public String getDeepNestedText(String cssSelector) {
        return getDeepNestedElement(cssSelector).getText().trim();
    }

    public boolean isDeepNestedPresent(String cssSelector) {
        try {
            driver.findElement(By.cssSelector(cssSelector));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Scroll down by pixels
    public void scrollDown(int pixels) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + pixels + ")");
        Thread.sleep(1500); // Give time for content to appear
    }

    // Scroll to bottom of page
    public void scrollToBottom() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(1500);
    }
}

