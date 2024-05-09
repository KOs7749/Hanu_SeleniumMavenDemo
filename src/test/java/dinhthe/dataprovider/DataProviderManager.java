package dinhthe.dataprovider;

import dinhthe.helpers.ExcelHelpers;
import dinhthe.helpers.SystemHelpers;
import org.testng.annotations.DataProvider;

public class DataProviderManager {

    @DataProvider(name = "data_provider_login_from_excel", parallel = true)
    public Object[][] dataLoginFromExcel() {

        ExcelHelpers excelHelpers = new ExcelHelpers();

        Object[][] data = excelHelpers.getExcelData(SystemHelpers.getCurrentDir() + "src/test/resources/datatest/Login.xlsx", "Sheet1");

        return data;
    }

    @DataProvider(name = "data_provider_login_from_excel_by_row", parallel = true)
    public Object[][] dataLoginFromExcelByRow() {

        ExcelHelpers excelHelpers = new ExcelHelpers();

        Object[][] data = excelHelpers.getExcelDataHashTable(SystemHelpers.getCurrentDir() + "src/test/resources/datatest/Login.xlsx", "Sheet1", 1, 2);

        return data;
    }

}
