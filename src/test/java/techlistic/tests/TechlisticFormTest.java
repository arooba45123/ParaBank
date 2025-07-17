package techlistic.tests;

import org.junit.jupiter.api.Test;
import techlistic.base.BaseTest;
import techlistic.pages.TechlisticFormPage;
import ultimateqa.utils.ExcelUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TechlisticFormTest extends BaseTest {

    @Test
    public void testTechlisticFormWithExcelData() {
        String excelPath = "src/test/resources/TestData.xlsx";
        String sheetName = "TechlisticForm";

        int rowCount = ExcelUtils.getRowCount(excelPath, sheetName);

        for (int i = 1; i <= rowCount; i++) {
            // Read from Excel
            String firstName = ExcelUtils.getCellData(excelPath, sheetName, i, 0);
            String lastName = ExcelUtils.getCellData(excelPath, sheetName, i, 1);
            String gender = ExcelUtils.getCellData(excelPath, sheetName, i, 2);
            String experience = ExcelUtils.getCellData(excelPath, sheetName, i, 3);
            String date = ExcelUtils.getCellData(excelPath, sheetName, i, 4);
            String profession = ExcelUtils.getCellData(excelPath, sheetName, i, 5);
            String tool = ExcelUtils.getCellData(excelPath, sheetName, i, 6);
            String continent = ExcelUtils.getCellData(excelPath, sheetName, i, 7);
            String command = ExcelUtils.getCellData(excelPath, sheetName, i, 8);
            String filePath = ExcelUtils.getCellData(excelPath, sheetName, i, 9);
            String expectedResult = ExcelUtils.getCellData(excelPath, sheetName, i, 10);

            // Navigate fresh for each row
            driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
            TechlisticFormPage formPage = new TechlisticFormPage(driver);

            // Fill form
            formPage.fillForm(
                    firstName, lastName, gender, experience, date,
                    profession, tool, continent, command, filePath
            );
            formPage.clickSubmit();

            // Since site shows no confirmation, we assume "success" as defined
            String actualResult = "All fields filled, Submit button clicked";

            // Write results back
            ExcelUtils.setCellData(excelPath, sheetName, i, 11, actualResult);  // Actual Result column
            if (actualResult.equalsIgnoreCase(expectedResult)) {
                ExcelUtils.setCellData(excelPath, sheetName, i, 12, "PASS");
            } else {
                ExcelUtils.setCellData(excelPath, sheetName, i, 12, "FAIL");
            }

            // ✅ Assertion
            assertEquals(expectedResult, actualResult, "Row " + i + " failed: Expected vs Actual mismatch");
        }
    }
}

