package herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShiftingContentImagePage {

    private WebDriver driver;

    private By image = By.cssSelector("#content img");

    public ShiftingContentImagePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isImageDisplayed() {
        return driver.findElement(image).isDisplayed();
    }

    public int getImageXPosition() {
        WebElement img = driver.findElement(image);
        Point location = img.getLocation();
        return location.getX();
    }

    public int getImageYPosition() {
        WebElement img = driver.findElement(image);
        Point location = img.getLocation();
        return location.getY();
    }
}

