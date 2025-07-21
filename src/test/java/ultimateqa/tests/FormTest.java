package ultimateqa.tests;

import ultimateqa.base.BaseTest;
import ultimateqa.pages.FormPage;

import org.junit.jupiter.api.Test;

import common.utils.ExcelUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FormTest extends BaseTest {

    @Test
    public void testLeftSideFormWithExcelData() throws Exception {
        String excelPath = "src/test/resources/TestData.xlsx";
        String sheetName = "Sheet1";

        int rowCount = ExcelUtils.getRowCount(excelPath, sheetName);

        for (int i = 1; i <= rowCount; i++) {  // skip header row
            String name = ExcelUtils.getCellData(excelPath, sheetName, i, 0);
            String message = ExcelUtils.getCellData(excelPath, sheetName, i, 1);
            String expectedResult = ExcelUtils.getCellData(excelPath, sheetName, i, 2);

            // Navigate for each iteration
            driver.get("https://ultimateqa.com/filling-out-forms/");
            FormPage formPage = new FormPage(driver);

            formPage.enterName(name);
            formPage.enterMessage(message);
            formPage.clickSubmit();

            String actualResult = formPage.getSuccessMessage();

            ExcelUtils.setCellData(excelPath, sheetName, i, 3, actualResult);

            if (actualResult.equalsIgnoreCase(expectedResult)) {
                ExcelUtils.setCellData(excelPath, sheetName, i, 4, "PASS");
            } else {
                ExcelUtils.setCellData(excelPath, sheetName, i, 4, "FAIL");
            }

            assertEquals(expectedResult, actualResult, "Mismatch at row: " + i);
        }
    }
}


