package dinhthe.testcases;

import dinhthe.common.BaseTest;
import dinhthe.constants.ConstantGlobal;
import dinhthe.pages.LoginPage;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {
    LoginPage loginPage = new LoginPage();

    @Test(priority = 1, description = "TC_001: Test UI login page")
    public void testUILoginPage() {
        loginPage.UILoginPage();
    }

    @Test(priority = 2, description = "TC_002: Test login with correct account")
    public void testLoginSuccess() {
        loginPage.logIn(ConstantGlobal.USERNAME, ConstantGlobal.PASSWORD);
    }

    @Test(priority = 3, description = "TC_003: Test login with incorrect username and incorrect password")
    public void testLoginWithInvalidUsernameAndPassword() {
        loginPage.loginWithInvalidUsernameAndPassword("123", "123");
    }

    @Test(priority = 4, description = "TC_004: Test login with incorrect username and correct password")
    public void testLoginWithUsernameInValid() {
        loginPage.loginWithUsernameInValid("123", ConstantGlobal.PASSWORD);
    }

    @Test(priority = 5, description = "TC_005: Test login with correct username and incorrect password")
    public void testLoginWithPasswordInValid() {
        loginPage.loginWithPasswordInValid(ConstantGlobal.USERNAME, "123");
    }


    @Test(priority = 6, description = "TC_006: Test login with SQL injection using username and password")
    public void testLoginWithSQLInjection() {
        loginPage.loginWithSQLInjection("OR 1=1", "OR 1=1");
    }

    @Test(priority = 7, description = "TC_007: Test click linkable Forgot Password")
    public void testClickForgotPasword() {
        loginPage.clickLinkableForgotPassword();
    }
}

