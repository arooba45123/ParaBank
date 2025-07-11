package herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class InfiniteScrollPage {

    private final WebDriver driver;
    private final By paragraphs = By.cssSelector(".jscroll-added");

    public InfiniteScrollPage(WebDriver driver) {
        this.driver = driver;
    }

    // Get count of loaded paragraphs
    public int getParagraphCount() {
        return driver.findElements(paragraphs).size();
    }

    // Scroll down to load more content
    public void scrollDown() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(2000); // Wait for new content to load visually
    }
}
