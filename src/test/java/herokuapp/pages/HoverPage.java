package herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HoverPage {
    private WebDriver driver;
    private Actions actions;

    public HoverPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    private String imageXpath = "(//div[@class='figure'])[%d]";
    private String userNameXpath = "(//div[@class='figcaption']/h5)[%d]";
    private String viewProfileXpath = "(//div[@class='figcaption']/a)[%d]";
    private By notFoundMessage = By.tagName("h1");

    public void open() {
        driver.get("https://the-internet.herokuapp.com/hovers");
    }

    public void hoverOverImage(int index) {
        WebElement image = driver.findElement(By.xpath(String.format(imageXpath, index)));
        actions.moveToElement(image).perform();
    }

    public String getUserName(int index) {
        WebElement userName = driver.findElement(By.xpath(String.format(userNameXpath, index)));
        return userName.getText();
    }

    public boolean isUserNameDisplayed(int index) {
        WebElement userName = driver.findElement(By.xpath(String.format(userNameXpath, index)));
        return userName.isDisplayed();
    }

    public void clickViewProfile(int index) {
        WebElement profileLink = driver.findElement(By.xpath(String.format(viewProfileXpath, index)));
        profileLink.click();
    }

    public String getNotFoundMessage() {
        return driver.findElement(notFoundMessage).getText();
    }

    public void goBack() {
        driver.navigate().back();
    }
}

