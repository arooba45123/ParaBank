package orangehrm.tests;

import org.junit.jupiter.api.Test;

import common.utils.ExcelUtils;
import orangehrm.pages.OrangeHRMLoginPage;
import techlistic.base.BaseTest;

public class OrangeHRMLoginTest extends BaseTest {

    @Test
    public void testOrangeHRMLoginWithExcelData() {
        String excelPath = "src/test/resources/TestData.xlsx";
        String sheetName = "OrangeHRM_LoginForm";

        int rowCount = ExcelUtils.getRowCount(excelPath, sheetName);

        StringBuilder failures = new StringBuilder();

        for (int i = 1; i <= rowCount; i++) {
            System.out.println("Running test for Row: " + i);

            // Read from Excel
            String username = ExcelUtils.getCellData(excelPath, sheetName, i, 0);
            String password = ExcelUtils.getCellData(excelPath, sheetName, i, 1);
            String expectedResult = ExcelUtils.getCellData(excelPath, sheetName, i, 2);

            // Navigate fresh for each row
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            OrangeHRMLoginPage loginPage = new OrangeHRMLoginPage(driver);

            // Fill login form & submit
            loginPage.enterUsername(username);
            loginPage.enterPassword(password);
            loginPage.clickLogin();

            // Get actual result
            String actualResult = loginPage.getLoginResult();

            System.out.println("Expected: [" + expectedResult + "], Actual: [" + actualResult + "]");

            // Write results back
            ExcelUtils.setCellData(excelPath, sheetName, i, 3, actualResult);  // Actual Result column
            if (actualResult.trim().equalsIgnoreCase(expectedResult.trim())) {
                ExcelUtils.setCellData(excelPath, sheetName, i, 4, "PASS");
            } else {
                ExcelUtils.setCellData(excelPath, sheetName, i, 4, "FAIL");
                failures.append("Row ").append(i)
                        .append(" failed: Expected [").append(expectedResult)
                        .append("] but got [").append(actualResult).append("]\n");
            }

            // Logout if login was successful to reset session
            loginPage.logoutIfLoggedIn();
        }

        // At the end: fail the test if there are any failures
        if (failures.length() > 0) {
            throw new AssertionError(failures.toString());
        }
    }
}

 
