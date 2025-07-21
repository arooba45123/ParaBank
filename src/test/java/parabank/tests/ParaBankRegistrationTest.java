package parabank.tests;

import common.utils.ExcelUtils;
import org.junit.jupiter.api.Test;
import parabank.pages.ParaBankRegistrationPage;
import techlistic.base.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParaBankRegistrationTest extends BaseTest {

    @Test
    public void testParabankRegistrationWithExcelData() {
        String excelPath = "src/test/resources/TestData.xlsx";
        String sheetName = "ParaBank_RegistrationForm";

        int rowCount = ExcelUtils.getRowCount(excelPath, sheetName);

        for (int i = 1; i <= rowCount; i++) {
            String firstName = ExcelUtils.getCellData(excelPath, sheetName, i, 0);
            String lastName = ExcelUtils.getCellData(excelPath, sheetName, i, 1);
            String address = ExcelUtils.getCellData(excelPath, sheetName, i, 2);
            String city = ExcelUtils.getCellData(excelPath, sheetName, i, 3);
            String state = ExcelUtils.getCellData(excelPath, sheetName, i, 4);
            String zip = ExcelUtils.getCellData(excelPath, sheetName, i, 5);
            String phone = ExcelUtils.getCellData(excelPath, sheetName, i, 6);
            String ssn = ExcelUtils.getCellData(excelPath, sheetName, i, 7);
            String username = ExcelUtils.getCellData(excelPath, sheetName, i, 8);
            String password = ExcelUtils.getCellData(excelPath, sheetName, i, 9);
            String confirmPassword = ExcelUtils.getCellData(excelPath, sheetName, i, 10);
            String expectedResult = ExcelUtils.getCellData(excelPath, sheetName, i, 11);

            driver.get("https://parabank.parasoft.com/parabank/register.htm");
            ParaBankRegistrationPage registrationPage = new ParaBankRegistrationPage(driver);

            registrationPage.fillRegistrationForm(firstName, lastName, address, city, state, zip,
                    phone, ssn, username, password, confirmPassword);
            registrationPage.clickRegister();

            String actualResult = registrationPage.getSuccessMessage();

            ExcelUtils.setCellData(excelPath, sheetName, i, 12, actualResult); // Actual Result
            if (actualResult.contains(expectedResult)) {
                ExcelUtils.setCellData(excelPath, sheetName, i, 13, "PASS");
            } else {
                ExcelUtils.setCellData(excelPath, sheetName, i, 13, "FAIL");
            }

            assertEquals(expectedResult.trim(), actualResult.trim(), "Row " + i + " failed.");

        }
    }
}

