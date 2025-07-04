package herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragandDropPage {
    private WebDriver driver;

    private By columnA = By.id("column-a");
    private By columnB = By.id("column-b");

    public DragandDropPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getColumnA() {
        return driver.findElement(columnA);
    }

    public WebElement getColumnB() {
        return driver.findElement(columnB);
    }

    public String getColumnAText() {
        return getColumnA().getText();
    }

    public String getColumnBText() {
        return getColumnB().getText();
    }

    public void dragAtoB() {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(getColumnA(), getColumnB()).perform();
    }
}

