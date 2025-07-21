package herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SortableDataTablesPage {

    private WebDriver driver;

    public SortableDataTablesPage(WebDriver driver) {
        this.driver = driver;
    }

    // Click a header in given table by column name
    public void clickHeader(int tableNumber, String headerName) {
        String headerXpath = String.format("//table[%d]//th[.='%s']", tableNumber, headerName);
        driver.findElement(By.xpath(headerXpath)).click();
    }

    // Get all values of a column by column index (1-based) from specified table
    public List<String> getColumnValues(int tableNumber, int colIndex) {
        String cellXpath = String.format("//table[%d]//tbody//tr//td[%d]", tableNumber, colIndex);
        List<WebElement> cells = driver.findElements(By.xpath(cellXpath));

        List<String> values = new ArrayList<>();
        for (WebElement cell : cells) {
            values.add(cell.getText().trim());
        }
        return values;
    }

    // Get column index of a column by its header name
    public int getColumnIndex(int tableNumber, String headerName) {
        String headersXpath = String.format("//table[%d]//th", tableNumber);
        List<WebElement> headers = driver.findElements(By.xpath(headersXpath));
        for (int i = 0; i < headers.size(); i++) {
            if (headers.get(i).getText().trim().equalsIgnoreCase(headerName)) {
                return i + 1; // columns are 1-based
            }
        }
        throw new RuntimeException("Header not found: " + headerName);
    }
}
