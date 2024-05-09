package dinhthe.testcases;

import dinhthe.common.BaseTest;
import dinhthe.constants.ConstantGlobal;
import dinhthe.pages.LoginPage;
import dinhthe.pages.SupplierPage;
import org.testng.annotations.Test;

public class SupplierListTest extends BaseTest {
    LoginPage loginPage = new LoginPage();
    SupplierPage removeSupplier = new SupplierPage();

    @Test(priority = 1, description = "TC_029: Navigate to list of suppliers screen")
    public void testOpenAddSupplier() {
        loginPage.loginNormal(ConstantGlobal.USERNAME, ConstantGlobal.PASSWORD);
        removeSupplier.openListSupplier();
        removeSupplier.verifyOpenListDupplier();
    }

    @Test(priority = 2, description = "TC_030: Test removes 1 supplier from the list")
    public void testDeleteOneSupplier() {
        loginPage.loginNormal(ConstantGlobal.USERNAME, ConstantGlobal.PASSWORD);
        removeSupplier.openListSupplier();
        removeSupplier.selectFirstCheckbox();
        removeSupplier.deleteOneSupplier();
        removeSupplier.verifySupplierDeleted();
    }

    @Test(priority = 3, description = "TC_031: Test removes many suppliers from the list")
    public void testDeleteMultipleSupplier() {
        loginPage.loginNormal(ConstantGlobal.USERNAME, ConstantGlobal.PASSWORD);
        removeSupplier.openListSupplier();
        removeSupplier.deleteMultipleSuppliers();
        removeSupplier.verifySupplierDeleted();
    }

    @Test(priority = 4, description = "TC_032: Test cancel removes the supplier from the list")
    public void testCancleDeleteSupplier() {
        loginPage.loginNormal(ConstantGlobal.USERNAME, ConstantGlobal.PASSWORD);
        removeSupplier.openListSupplier();
        removeSupplier.selectFirstCheckbox();
        removeSupplier.cancelDeleteOperation();
    }
}


