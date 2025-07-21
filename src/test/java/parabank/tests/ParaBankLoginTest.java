package parabank.tests;

import common.utils.ExcelUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import parabank.pages.ParaBankLoginPage;
import techlistic.base.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParaBankLoginTest extends BaseTest {

    @Test
    public void testParaBankLoginWithExcelData() {
        String excelPath = "src/test/resources/TestData.xlsx";
        String sheetName = "ParaBank_LoginForm";

        int rowCount = ExcelUtils.getRowCount(excelPath, sheetName);

        for (int i = 1; i <= rowCount; i++) {
            String username = ExcelUtils.getCellData(excelPath, sheetName, i, 0);
            String password = ExcelUtils.getCellData(excelPath, sheetName, i, 1);
            String expectedResult = ExcelUtils.getCellData(excelPath, sheetName, i, 2);

            driver.get("https://parabank.parasoft.com/parabank/index.htm");
            ParaBankLoginPage loginPage = new ParaBankLoginPage(driver);

            loginPage.enterUsername(username);
            loginPage.enterPassword(password);
            loginPage.clickLogin();

            String actualResult;

            if (loginPage.isLoggedIn()) {
                actualResult = "Login Success";
                // Optional: Logout to reset state for next row
                driver.findElement(By.linkText("Log Out")).click();
            } else {
                actualResult = loginPage.getErrorMessage();
            }

            ExcelUtils.setCellData(excelPath, sheetName, i, 3, actualResult); // Actual Result
            String status = actualResult.trim().equalsIgnoreCase(expectedResult.trim()) ? "PASS" : "FAIL";
            ExcelUtils.setCellData(excelPath, sheetName, i, 4, status);

            assertEquals(expectedResult.trim(), actualResult.trim(), "Row " + i + " failed.");
        }
    }
}
