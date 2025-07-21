package herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IFramePage {
    private WebDriver driver;

    public IFramePage(WebDriver driver) {
        this.driver = driver;
    }

    private String iframeId = "mce_0_ifr";
    private By editorBody = By.id("tinymce");

    public void open() {
        driver.get("https://the-internet.herokuapp.com/iframe");
    }

    public void switchToIFrame() {
        driver.switchTo().frame(iframeId);
    }

    public void setTextInEditor(String text) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement editor = driver.findElement(editorBody);
        js.executeScript("arguments[0].innerHTML = '<p>" + text + "</p>';", editor);
    }

    public String getEditorText() {
        WebElement editor = driver.findElement(editorBody);
        return editor.getText();
    }
}
