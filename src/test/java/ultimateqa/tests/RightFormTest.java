package ultimateqa.tests;

import ultimateqa.base.BaseTest;
import ultimateqa.pages.RightFormPage;

import org.junit.jupiter.api.Test;

import common.utils.ExcelUtils;

public class RightFormTest extends BaseTest {

    @Test
    public void testRightSideFormWithExcelData() throws Exception {
        String excelPath = "src/test/resources/TestData.xlsx";
        String sheetName = "Sheet2";

        int rowCount = ExcelUtils.getRowCount(excelPath, sheetName);

        for (int i = 1; i <= rowCount; i++) {
            driver.get("https://ultimateqa.com/filling-out-forms/");

            RightFormPage formPage = new RightFormPage(driver);

            String name = ExcelUtils.getCellData(excelPath, sheetName, i, 0);
            String message = ExcelUtils.getCellData(excelPath, sheetName, i, 1);
            String expectedResult = ExcelUtils.getCellData(excelPath, sheetName, i, 2);

            formPage.enterName(name);
            formPage.enterMessage(message);

            String actualResult;

            if (formPage.isCaptchaPresent()) {
                actualResult = "CAPTCHA present";
            } else {
                formPage.clickSubmit();
                actualResult = formPage.getCaptchaErrorMessage();
            }

            ExcelUtils.setCellData(excelPath, sheetName, i, 3, actualResult);

            if (actualResult.equalsIgnoreCase(expectedResult)) {
                ExcelUtils.setCellData(excelPath, sheetName, i, 4, "PASS");
            } else {
                ExcelUtils.setCellData(excelPath, sheetName, i, 4, "FAIL");
            }
        }
    }
}
