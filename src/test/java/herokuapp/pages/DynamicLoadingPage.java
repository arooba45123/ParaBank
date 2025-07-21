package herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage {
    private WebDriver driver;

    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
    }

    private By startButton = By.cssSelector("#start button");
    private By finishElement = By.id("finish");

    public void openExample1() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
    }

    public void openExample2() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
    }

    public void clickStartButton() {
        driver.findElement(startButton).click();
    }

    public String getFinishText() {
        return driver.findElement(finishElement).getText();
    }
}
