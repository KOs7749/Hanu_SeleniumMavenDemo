package dinhthe.pages;

import dinhthe.keywords.WebUI;
import org.openqa.selenium.By;

public class CommonPage {

    //Khai báo đối tượng cho Class chung
    public LoginPage loginPage;
    private SupplierPage supplierPage;

    //Object chung
    public By headerPage = By.xpath("//li[@class='nav-item active']/a");
    public By buttonDangXuat = By.xpath("//div[@class='page-header']//a[normalize-space()='Logout']");
    public By headerUser = By.xpath("//div[@id='header-users']");
    protected By menu = By.xpath("//a[@title='Phân hệ' and @class='header-link icon-thumbnails pop-done pop-control pop-control-click pop-connect']");
    protected By menuPurchaseSupply = By.xpath("//span[@class='app-menu-item-desc' and text()='Quản lý, giám sát quy trình mua hàng']");


    public LoginPage dangXuat() {
        WebUI.clickElement(buttonDangXuat);
        return new LoginPage();
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public SupplierPage getAppSupplierPage() {
        if (supplierPage == null) {
            supplierPage = new SupplierPage();
        }
        return supplierPage;
    }
}
