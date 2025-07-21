package herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddRemoveElementsPage {
    private WebDriver driver;

    public AddRemoveElementsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By addButton = By.xpath("//button[text()='Add Element']");
    private By deleteButton = By.className("added-manually");

    public void open() {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
    }

    public void clickAddElement() {
        driver.findElement(addButton).click();
    }

    public boolean isDeleteButtonDisplayed() {
        return driver.findElement(deleteButton).isDisplayed();
    }

    public void clickDeleteButton() {
        driver.findElement(deleteButton).click();
    }
}
