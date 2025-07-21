package herokuapp.pages;

import org.openqa.selenium.WebDriver;

public class JavaScriptErrorPage {
    private final WebDriver driver;

    public JavaScriptErrorPage(WebDriver driver) {
        this.driver = driver;
    }

    // Nothing to return from the page visually — no h3 or p.
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}

