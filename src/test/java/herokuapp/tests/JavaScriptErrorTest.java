package herokuapp.tests;

import herokuapp.base.BaseTest;
import herokuapp.pages.JavaScriptErrorPage;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import static org.junit.jupiter.api.Assertions.*;

public class JavaScriptErrorTest extends BaseTest {

    private final String URL = "https://the-internet.herokuapp.com/javascript_error";

    @Test
    public void testJavaScriptErrorInConsole() throws InterruptedException {
        driver.get(URL);
        Thread.sleep(3000);
        
        
        JavaScriptErrorPage page = new JavaScriptErrorPage(driver);
        System.out.println("Current URL: " + page.getCurrentUrl());

        LogEntries logs = driver.manage().logs().get(LogType.BROWSER);

        boolean jsErrorDetected = false;

        System.out.println("Browser Console Logs:");
        for (LogEntry entry : logs) {
            System.out.println(entry.getLevel() + ": " + entry.getMessage());
            if (entry.getMessage().contains("Uncaught")) {
                jsErrorDetected = true;
            }
        }

        assertTrue(jsErrorDetected, "JavaScript error should be present in browser logs.");
        System.out.println("Verified: JavaScript error detected in console.");
    }
}
