package dinhthe.pages;

import dinhthe.constants.ConstantGlobal;
import dinhthe.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage extends CommonPage {
    private By inputUsername = By.xpath("//input[@id='username']");
    private By inputPassword = By.xpath("//input[@id='userpwd']");
    private By buttonSignin = By.xpath("//button[@type='submit']");
    private By linkForgotPassword = By.xpath("//a[contains(text(),'Quên mật khẩu?')]");
    private By alertMessage = By.xpath("//div[@class='form-error-text']");
    private By recoverPassword = By.xpath("//div[@class='form-title'][contains(text(),'Lấy lại mật khẩu')]");

    public void loginNormal(String username, String password) {
        WebUI.openURL(ConstantGlobal.URL);
        WebUI.setText(inputUsername, username);
        WebUI.setText(inputPassword, password);
        WebUI.clickElement(buttonSignin);
        WebUI.waitForPageLoaded();
    }

    public DashboardPage logIn(String username, String password) {
        loginNormal(username, password);
        boolean checkMenu = WebUI.checkElementExist(headerUser);
        Assert.assertTrue(checkMenu, "Login failed. Can not navigate to Dashboard page.");
        return new DashboardPage();
    }

    public void loginWithUsernameInValid(String username, String password) {
        loginNormal(username, password);
        boolean checkAlertError = WebUI.checkElementExist(alertMessage);
        Assert.assertTrue(checkAlertError, "Fail. Error message not display.");
        WebUI.verifyEquals(WebUI.getElementText(alertMessage), "Tài khoản hoặc mật khẩu không đúng");
    }

    public void loginWithPasswordInValid(String username, String password) {
        loginNormal(username, password);
        boolean checkAlertError = WebUI.checkElementExist(alertMessage);
        Assert.assertTrue(checkAlertError, "Fail. Error message not display.");
        WebUI.verifyEquals(WebUI.getElementText(alertMessage), "Tài khoản hoặc mật khẩu không đúng");
    }

    public void loginWithInvalidUsernameAndPassword(String username, String password) {
        loginNormal(username, password);
        boolean checkAlertError = WebUI.checkElementExist(alertMessage);
        Assert.assertTrue(checkAlertError, "Fail. Error message not display.");
        WebUI.verifyEquals(WebUI.getElementText(alertMessage), "Tài khoản hoặc mật khẩu không đúng");
    }

    public void loginWithSQLInjection(String username, String password) {
        loginNormal(username, password);
        boolean checkAlertError = WebUI.checkElementExist(alertMessage);
        Assert.assertTrue(checkAlertError, "Fail. Error message not display.");
        WebUI.verifyEquals(WebUI.getElementText(alertMessage), "Tài khoản hoặc mật khẩu không đúng");
    }

    public void clickLinkableForgotPassword() {
        WebUI.openURL(ConstantGlobal.URL);
        WebUI.clickElement(linkForgotPassword);
        boolean checkMenu = WebUI.checkElementExist(recoverPassword);
        Assert.assertTrue(checkMenu, "Password recover page not found");
    }

    public void UILoginPage() {
        WebUI.openURL(ConstantGlobal.URL);
        // Kiểm tra tồn tại các phần tử trên trang đăng nhập
        Assert.assertTrue(WebUI.checkElementExist(inputUsername), "Input username field is not found.");
        Assert.assertTrue(WebUI.checkElementExist(inputPassword), "Input password field is not found.");
        Assert.assertTrue(WebUI.checkElementExist(buttonSignin), "Sign in button is not found.");
        Assert.assertTrue(WebUI.checkElementExist(linkForgotPassword), "Forgot password link is not found.");

        // Kiểm tra văn bản và thuộc tính của các phần tử
        Assert.assertEquals(WebUI.getElementText(By.xpath("//div[@class='form-title']")), "Đăng nhập", "Title is incorrect");
        Assert.assertEquals(WebUI.getElementText(By.xpath("//label[contains(text(),'Tên đăng nhập*')]")), "Tên đăng nhập*", "Username field label is incorrect.");
        Assert.assertEquals(WebUI.getElementText(By.xpath("//label[contains(text(),'Mật khẩu*')]")), "Mật khẩu*", "Password field label is incorrect.");

        // Kiểm tra trạng thái mặc định của checkbox
        WebElement rememberMeCheckbox = WebUI.getWebElement(By.xpath("//label[text()='Giữ tôi luôn đăng nhập']/preceding::input[@type='checkbox']"));
        Assert.assertTrue(rememberMeCheckbox.isSelected(), "Remember me checkbox is not checked.");

        // Kiểm tra các liên kết tải ứng dụng trên điện thoại
        Assert.assertTrue(WebUI.checkElementExist(By.xpath("//div[contains(text(),'Cài đặt ứng dụng trên điện thoại')]/following::div/a[@href='https://play.google.com/store/apps/details?id=vn.oneoffice.oneoffice']")), "Android app link is not found.");
        Assert.assertTrue(WebUI.checkElementExist(By.xpath("//div[contains(text(),'Cài đặt ứng dụng trên điện thoại')]/following::div/a[@href='https://itunes.apple.com/us/app/1office/id1272801903?l=vi&ls=1&mt=8']")), "iOS app link is not found.");
    }
}

