package herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NotificationMessagesPage {
    private WebDriver driver;

    private By clickHereLink = By.linkText("Click here");
    private By notificationMessage = By.id("flash");

    public NotificationMessagesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/notification_message_rendered");
    }

    public void clickHere() {
        driver.findElement(clickHereLink).click();
    }

    public String getNotificationMessage() {
        WebElement notification = driver.findElement(notificationMessage);
        return notification.getText().trim().replace("×", "").trim();
    }
}

