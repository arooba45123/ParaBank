package herokuapp.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavaScriptAlertsPage {
    private WebDriver driver;

    public JavaScriptAlertsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By jsAlertButton = By.xpath("//button[text()='Click for JS Alert']");
    private By jsConfirmButton = By.xpath("//button[text()='Click for JS Confirm']");
    private By jsPromptButton = By.xpath("//button[text()='Click for JS Prompt']");
    private By resultText = By.id("result");

    public void open() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    public void clickJSAlert() {
        driver.findElement(jsAlertButton).click();
    }

    public void clickJSConfirm() {
        driver.findElement(jsConfirmButton).click();
    }

    public void clickJSPrompt() {
        driver.findElement(jsPromptButton).click();
    }

    public Alert switchToAlert() {
        return driver.switchTo().alert();
    }

    public String getResultText() {
        return driver.findElement(resultText).getText();
    }
}
