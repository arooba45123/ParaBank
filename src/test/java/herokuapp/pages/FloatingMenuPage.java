package herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FloatingMenuPage {

    private WebDriver driver;

    // Locators
    private By menu = By.id("menu");
    private By homeLink = By.linkText("Home");
    private By newsLink = By.linkText("News");
    private By contactLink = By.linkText("Contact");
    private By aboutLink = By.linkText("About");

    // Constructor
    public FloatingMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    // Check if menu is displayed
    public boolean isMenuDisplayed() {
        return driver.findElement(menu).isDisplayed();
    }

    // Scroll to bottom
    public void scrollToBottom() {
        long pageHeight = (Long) ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("return document.body.scrollHeight");
        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, arguments[0]);", pageHeight);
    }

    // Click Home link
    public void clickHome() {
        driver.findElement(homeLink).click();
    }

    // Click News link
    public void clickNews() {
        driver.findElement(newsLink).click();
    }

    // Click Contact link
    public void clickContact() {
        driver.findElement(contactLink).click();
    }

    // Click About link
    public void clickAbout() {
        driver.findElement(aboutLink).click();
    }

    // Get current page URL
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
