package dinhthe.pages;

import dinhthe.keywords.WebUI;
import org.openqa.selenium.By;
import org.testng.Assert;

public class AddSupplierDebt extends AddSupplierPage {

    private By supplier = By.xpath("//tr[contains(@class,'table-row-body')][1]//td[@col='code' and @type='code']/a");
    private By iconDebt = By.xpath("//i[@class='icon-chart-area']");
    private By debt = By.xpath("//div[contains(text(),'Ghi nợ')]");
    private By debtPopup = By.xpath("//div[contains(@class, 'draggable-done') and not(contains(@class, 'hidden'))]//span[contains(text(),'Công nợ')]");
    private By textboxDate = By.xpath("//div[@class='form-control xfocus-done xfocus pop-done pop-control pop-control-click pop-connect']");
    private By inputDate = By.xpath("//input[@name='date']");
    private By textboxMoney = By.xpath("//div[@class='form-group form-input label-large outlined normal form-group-control col-4']//div[@class='form-control pop-done pop-control pop-control-click pop-connect xfocus-done xfocus']");
    private By inputMoney = By.xpath("//input[@name='money']");
    private By textboxReason = By.xpath("//div[@class='form-group form-input label-large outlined normal']//div[@class='form-control pop-done pop-control pop-control-click pop-connect xfocus-done xfocus']");
    private By inputReason = By.xpath("//input[@name='title']");
    private By rowDebt = By.xpath("//div[contains(@class, 'detail-section') and .//div[contains(text(), 'Công nợ')]]//tr[contains(@class,'table-row-body')]");
    private By buttonUpdate = By.xpath("//button[contains(text(),'Cập nhật')]");
    private By buttonCancel = By.xpath("//div[@class='btn btn-default']");
    private By alertMessage = By.xpath("//div[@class='dialog pop-bold pop-box pop-box-mousedown pop-box-touchstart pop-alert draggable-done']//div[@class='dialog-content']");

    private void checkAlertMessageDisplayed(String expectedMessage) {
        boolean checkAlertError = WebUI.checkElementExist(alertMessage);
        Assert.assertTrue(checkAlertError, "Fail. Error message not display.");
        WebUI.verifyEquals(WebUI.getElementText(alertMessage), expectedMessage);
    }

    public void openPageSupplierDetail() {
        openListSupplier();
        WebUI.sleep(5);
        WebUI.clickElement(supplier);
        WebUI.sleep(3);

    }

    public void addOpenPopupDebt() {
        WebUI.hoverElement(iconDebt);
        WebUI.getWebElements(debt);
        WebUI.clickElement(debt);
        boolean checkPopup = WebUI.checkElementExist(debtPopup);
        Assert.assertTrue(checkPopup, "The system is unable to open pop up supplier's debt");
    }


    public void addDebtNormal(String date, String money, String reason) {
        selectAndSetText(textboxDate, inputDate, date);
        selectAndSetText(textboxMoney, inputMoney, money);
        selectAndSetText(textboxReason, inputReason, reason);
        WebUI.clickElement(buttonUpdate);
        WebUI.waitForPageLoaded();
    }

    public void addDebtSuccess(String date, String money, String reason) {
        addDebtNormal(date, money, reason);
        boolean checkDebt = WebUI.checkElementExist(rowDebt);
        Assert.assertTrue(checkDebt, "Debt is null, add debt unsuccessful");
    }

    public void addDebtWhenOnlyDate(String date) {
        selectAndSetText(textboxDate, inputDate, date);
        WebUI.clickElement(textboxMoney);
        WebUI.clickElement(buttonUpdate);
        WebUI.waitForPageLoaded();
        checkAlertMessageDisplayed("+) Lý do chưa nhập\n+) Số tiền chưa nhập");
    }

    public void addDebtWhenOnlyMoney(String money) {
        selectAndSetText(textboxMoney, inputMoney, money);
        WebUI.clickElement(buttonUpdate);
        WebUI.waitForPageLoaded();
        checkAlertMessageDisplayed("+) Ngày chưa nhập\n+) Lý do chưa nhập");
    }

    public void addDebtWhenOnlyReason(String reason) {
        selectAndSetText(textboxReason, inputReason, reason);
        WebUI.clickElement(buttonUpdate);
        WebUI.waitForPageLoaded();
        checkAlertMessageDisplayed("+) Ngày chưa nhập\n+) Số tiền chưa nhập");
    }

    public void addDebtWithoutRequiredField() {
        WebUI.clickElement(buttonUpdate);
        WebUI.waitForPageLoaded();
        checkAlertMessageDisplayed("+) Ngày chưa nhập\n+) Lý do chưa nhập\n+) Số tiền chưa nhập");
    }

    public void addDebtWithInvalidDate(String date, String money, String reason) {
        addDebtNormal(date, money, reason);
        checkAlertMessageDisplayed("Ngày không hợp lệ (" + date + ")");
    }

    public void addDebtWithMaxlengthReason(String date, String money, String reason) {
        addDebtNormal(date, money, reason);
        checkAlertMessageDisplayed("Nhập không quá 300 ký tự");
    }

    public void cancelAddDebt() {
        WebUI.clickElement(buttonCancel);
        boolean checkClosePopUp = WebUI.checkElementExist(headerDetailSupplier);
        Assert.assertTrue(checkClosePopUp, "The system is unable to close pop up add supplier's debt");
    }
}
