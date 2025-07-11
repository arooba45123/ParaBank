package herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChallengingDomPage {

    private WebDriver driver;

    private final By blueButton = By.cssSelector(".button");
    private final By redButton = By.cssSelector(".button.alert");
    private final By greenButton = By.cssSelector(".button.success");

    public ChallengingDomPage(WebDriver driver) {
        this.driver = driver;
    }

    // Click Blue button
    public void clickBlueButton() {
        driver.findElement(blueButton).click();
    }

    // Click Red button
    public void clickRedButton() {
        driver.findElement(redButton).click();
    }

    // Click Green button
    public void clickGreenButton() {
        driver.findElement(greenButton).click();
    }

    // Get text of a specific table cell
    public String getTableCellText(int row, int col) {
        String cellXpath = "//table//tr[" + (row + 1) + "]//td[" + col + "]";
        return driver.findElement(By.xpath(cellXpath)).getText();
    }
}


    
    
    
    
    
    
    
    