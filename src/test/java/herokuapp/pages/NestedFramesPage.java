package herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NestedFramesPage {
    private WebDriver driver;

    public NestedFramesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/nested_frames");
    }

    public void switchToMiddleFrame() {
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
    }

    public String getMiddleFrameText() {
        WebElement middleText = driver.findElement(By.id("content"));
        return middleText.getText();
    }

    public void switchToInvalidFrame() {
        driver.switchTo().frame("nonexistent-frame");
    }
}
