package dinhthe.testcases;

import dinhthe.common.BaseTest;
import dinhthe.constants.ConstantGlobal;
import dinhthe.pages.AddSupplierDebt;
import dinhthe.pages.LoginPage;
import org.testng.annotations.Test;

public class AddDebtTest extends BaseTest {
    LoginPage loginPage = new LoginPage();
    AddSupplierDebt addDebtPage = new AddSupplierDebt();

    @Test(priority = 1, description = "TC_019: Test navigate the supplier details screen")
    public void testNavigateSupplierDetail() {
        loginPage.loginNormal(ConstantGlobal.USERNAME, ConstantGlobal.PASSWORD);
        addDebtPage.openPageSupplierDetail();
    }

    @Test(priority = 2, description = "TC_020: Test opens a pop up to add new debt to the supplier")
    public void testOpenPopupDebt() {
        loginPage.loginNormal(ConstantGlobal.USERNAME, ConstantGlobal.PASSWORD);
        addDebtPage.openPageSupplierDetail();
        addDebtPage.addOpenPopupDebt();
    }

    @Test(priority = 3, description = "TC_021: Test adding new debt to the supplier successfully")
    public void testAddDebtSuccessfully() {
        loginPage.loginNormal(ConstantGlobal.USERNAME, ConstantGlobal.PASSWORD);
        addDebtPage.openPageSupplierDetail();
        addDebtPage.addOpenPopupDebt();
        addDebtPage.addDebtSuccess("12/12/2023", "1000000", "Chưa thanh toán");
    }

    @Test(priority = 4, description = "TC_022: Test add new debt to supplier when only entering the required field [Date]")
    public void testAddDebtWithDate() {
        loginPage.loginNormal(ConstantGlobal.USERNAME, ConstantGlobal.PASSWORD);
        addDebtPage.openPageSupplierDetail();
        addDebtPage.addOpenPopupDebt();
        addDebtPage.addDebtWhenOnlyDate("12/12/2023");
    }

    @Test(priority = 5, description = "TC_023: Test add new debt to supplier when only entering the required field [Money]")
    public void testAddDebtWithMoney() {
        loginPage.loginNormal(ConstantGlobal.USERNAME, ConstantGlobal.PASSWORD);
        addDebtPage.openPageSupplierDetail();
        addDebtPage.addOpenPopupDebt();
        addDebtPage.addDebtWhenOnlyMoney("1000000");
    }

    @Test(priority = 6, description = "TC_024: Test add new debt to supplier when only entering the required field [Reason]")
    public void testAddDebtWithReason() {
        loginPage.loginNormal(ConstantGlobal.USERNAME, ConstantGlobal.PASSWORD);
        addDebtPage.openPageSupplierDetail();
        addDebtPage.addOpenPopupDebt();
        addDebtPage.addDebtWhenOnlyReason("Chưa thanh toán");
    }

    @Test(priority = 7, description = "TC_025: Test add new debt to supplier without entering any required fields")
    public void testAddDebtWithoutRequiredField() {
        loginPage.loginNormal(ConstantGlobal.USERNAME, ConstantGlobal.PASSWORD);
        addDebtPage.openPageSupplierDetail();
        addDebtPage.addOpenPopupDebt();
        addDebtPage.addDebtWithoutRequiredField();
    }

    @Test(priority = 8, description = "TC_026: Test add new debt to supplier when entering incorrect date format")
    public void testAddDebtWithInvalidDate() {
        loginPage.loginNormal(ConstantGlobal.USERNAME, ConstantGlobal.PASSWORD);
        addDebtPage.openPageSupplierDetail();
        addDebtPage.addOpenPopupDebt();
        addDebtPage.addDebtWithInvalidDate("12122023", "1000000", "Chưa thanh toán");
    }

    @Test(priority = 9, description = "TC_027: Test add new debt to supplier when entering > 300 character at [Reason] field")
    public void testAddDebtWithReasonMaxCharacter() {
        loginPage.loginNormal(ConstantGlobal.USERNAME, ConstantGlobal.PASSWORD);
        addDebtPage.openPageSupplierDetail();
        addDebtPage.addOpenPopupDebt();
        addDebtPage.addDebtWithMaxlengthReason("12/12/2023", "1000000", "Lorem ipsum dolor sit amet, elit. Quisque malesuada blandit. In non viverra arcu. Suspendisse non urna sem. Fusce consequat dapibus tellus, et rhoncus est efficitur nec. In ut egestas sem, a condimentum augue. Fusce pharetra purus nec felis mollis venenatis porttitor. consectetur adipiscing ultrices112");
    }

    @Test(priority = 10, description = "TC_028: Test add new debt to supplier when entering > 300 character at [Reason] field")
    public void testCancelAddDebt() {
        loginPage.loginNormal(ConstantGlobal.USERNAME, ConstantGlobal.PASSWORD);
        addDebtPage.openPageSupplierDetail();
        addDebtPage.addOpenPopupDebt();
        addDebtPage.cancelAddDebt();
    }
}
