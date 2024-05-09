package dinhthe.testcases;

import dinhthe.Models.Supplier;
import dinhthe.common.BaseTest;
import dinhthe.constants.ConstantGlobal;
import dinhthe.pages.AddSupplierPage;
import dinhthe.pages.LoginPage;
import org.testng.annotations.Test;

public class AddSupplierTest extends BaseTest {
    LoginPage loginPage = new LoginPage();
    AddSupplierPage addSupplierPage = new AddSupplierPage();


    @Test(priority = 1, description = "TC_008: Test open page add new supplier")
    public void testOpenAddSupplier() {
        loginPage.loginNormal(ConstantGlobal.USERNAME, ConstantGlobal.PASSWORD);
        addSupplierPage.openAddSupplier();
    }

    @Test(priority = 2, description = "TC_009: Test add new candidate successfully")
    public void testAddSupplierNormal() {
        loginPage.loginNormal(ConstantGlobal.USERNAME, ConstantGlobal.PASSWORD);
        addSupplierPage.openAddSupplier();
        Supplier supplier = new Supplier("Lê văn thủy", "0355349272", "dtthe201@gmail.com", "20/01/2002", "024300206868", "17/12/2021");
        addSupplierPage.addSupplierSuccessfully(supplier);
    }

    @Test(priority = 3, description = "TC_010: Test add new supplier when entering the required field [Full name]")
    public void testAddSupplierWithOnlyName() {
        loginPage.loginNormal(ConstantGlobal.USERNAME, ConstantGlobal.PASSWORD);
        addSupplierPage.openAddSupplier();
        Supplier supplier = new Supplier("Lê văn thủy", null, null, null, null, null);
        addSupplierPage.addSupplierWhenOnlyName(supplier);
    }

    @Test(priority = 4, description = "TC_011: Test add new supplier when entering the required field [Supplier code]")
    public void testAddSupplierWithOnlyCode() {
        loginPage.loginNormal(ConstantGlobal.USERNAME, ConstantGlobal.PASSWORD);
        addSupplierPage.openAddSupplier();
        addSupplierPage.addSupplierWhenOnlySupplierCode();
    }

    @Test(priority = 5, description = "TC_012: Test add new supplier when entering the required field [Supplier type]")
    public void testAddSupplierWithOnlySupplierType() {
        loginPage.loginNormal(ConstantGlobal.USERNAME, ConstantGlobal.PASSWORD);
        addSupplierPage.openAddSupplier();
        addSupplierPage.addSupplierWhenOnlySupplierType();
    }

    @Test(priority = 6, description = "TC_013: Test add new supplier without entering required field")
    public void testAddSupplierWithoutRequireFields() {
        loginPage.loginNormal(ConstantGlobal.USERNAME, ConstantGlobal.PASSWORD);
        addSupplierPage.openAddSupplier();
        addSupplierPage.addSupplierWithoutEnterRequiredField();
    }

    @Test(priority = 7, description = "TC_014: Test add new supplier when entering incorrect phone number format")
    public void testAddSupplierWithInvalidPhoneNumber() {
        loginPage.loginNormal(ConstantGlobal.USERNAME, ConstantGlobal.PASSWORD);
        addSupplierPage.openAddSupplier();
        Supplier supplier = new Supplier("Lê Văn Thủy", "1234abcd!@#$", "dtthe201@gmail.com", "20/01/2002", "024300206868", "17/12/2021");
        addSupplierPage.addSupplierWhenInvalidPhone(supplier);
    }

    @Test(priority = 8, description = "TC_015: Test add new supplier when entering incorrect email format")
    public void testAddSupplierWithInvalidEmail() {
        loginPage.loginNormal(ConstantGlobal.USERNAME, ConstantGlobal.PASSWORD);
        addSupplierPage.openAddSupplier();
        Supplier supplier = new Supplier("Lê Văn Thủy", "0355349377", "dtthe", "20/01/2002", "0243002068686", "17/12/2021");
        addSupplierPage.addSupplierWhenInvalidEmail(supplier);
    }

    @Test(priority = 9, description = "TC_016: Test add new supplier when entering incorrect Date format")
    public void testAddSupplierWithInvalidDate() {
        loginPage.loginNormal(ConstantGlobal.USERNAME, ConstantGlobal.PASSWORD);
        addSupplierPage.openAddSupplier();
        Supplier supplier = new Supplier("Lê Văn Thủy", "0355349373", "dtthe", "20012002", "024300206868", "17/12/2021");
        addSupplierPage.addSupplierWhenInvalidDate(supplier);
    }

    @Test(priority = 10, description = "TC_017: Test add new supplier when entering incorrect Id Date format")
    public void testAddSupplierWithInvalidIdDate() {
        loginPage.loginNormal(ConstantGlobal.USERNAME, ConstantGlobal.PASSWORD);
        addSupplierPage.openAddSupplier();
        Supplier supplier = new Supplier("Lê Văn Thủy", "0355349373", "dtthe", "20/01/2002", "024300206868", "17122021");
        addSupplierPage.addSupplierWhenInvalidIdDate(supplier);
    }

    @Test(priority = 11, description = "TC_018: Test cancel adding new supplier")
    public void testCancelAddSupplier() {
        loginPage.loginNormal(ConstantGlobal.USERNAME, ConstantGlobal.PASSWORD);
        addSupplierPage.openAddSupplier();
        addSupplierPage.cancelAddSupplier();
    }
}

