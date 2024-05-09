package dinhthe.pages;

import dinhthe.Models.Supplier;
import dinhthe.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

public class AddSupplierPage extends SupplierPage {
    // Variables to locate elements on the webpage
    protected By iconSuggestMaterial = By.xpath("//a[@title='Tạo mới']");
    protected By submenuSupplier = By.xpath("//div[@class='list list-menu pop-box pop-box-mousemove pop-box-mousedown']//div[@class='title'][contains(text(),'Nhà cung cấp')]");
    protected By headerAddTitle = By.xpath("//div[@id='header-title']/div[text()='Tạo mới nhà cung cấp']");
    protected By clearSupplierType = By.xpath("/html/body/div[1]/div[2]/div[2]/form/div[2]/div[1]/div[3]/div[1]/div/div[1]/div/div[2]/div/div/i[2]");
    protected By inputSupplierCode = By.xpath("//input[@name='code']");
    protected By textboxName = By.xpath("//div[@placeholder='order.supplier.field.customer.pl']//div[@class='form-control pop-done pop-control pop-control-click pop-connect xfocus-done xfocus']");
    protected By inputName = By.xpath("//input[@name='name']");
    protected By textboxField = By.xpath("(//div[@class='form-control xfocus-done xfocus form-input-select'])[2]");
    protected By textboxTitle = By.xpath("(//div[@class='form-control xfocus-done xfocus form-input-select'])[3]");
    protected By textboxDOB = By.xpath("(//div[@class='form-control xfocus-done xfocus pop-done pop-control pop-control-click pop-connect'])[1]");
    protected By inputDOB = By.xpath("(//input[@name='birthday'])");
    protected By textboxPhone = By.xpath("(//div[@_n='inputs'])[8]");
    protected By inputPhone = By.xpath("//input[@name='phones']");
    protected By textboxEmail = By.xpath("//div[@class='form-section']//div[@class='form-group form-input label-large outlined normal form-group-control col-sm-8']//div[@class='form-control pop-done pop-control pop-control-click pop-connect xfocus-done xfocus']");
    protected By inputEmail = By.xpath("//input[@name='emails']");
    protected By textboxID = By.xpath("(//div[@_n='inputs'])[10]");
    protected By inputID = By.xpath("//input[@name='private_code']");
    protected By textboxIdDate = By.xpath("(//div[@class='form-control xfocus-done xfocus pop-done pop-control pop-control-click pop-connect'])[2]");
    protected By inputIdDate = By.xpath("//input[@name='private_date']");
    protected By goodGroups = By.xpath("(//div[@class='form-control xfocus-done xfocus form-input-select'])[6]");
    protected By inputGoodGroups = By.xpath("//div[@placeholder='Nhập hàng hóa cung cấp']");
    protected By buttonUpdate = By.xpath("//button[contains(text(),'Cập nhật')]");
    protected By buttonCancel = By.xpath("//div[contains(text(),'Hủy bỏ')]");
    protected By alertMessage = By.xpath("//div[@class='dialog-message']");

    // Method to check and display error message
    private void checkAlertMessageDisplayed(String expectedMessage) {
        boolean checkAlertError = WebUI.checkElementExist(alertMessage);
        Assert.assertTrue(checkAlertError, "Fail. Error message not display.");
        WebUI.verifyEquals(WebUI.getElementText(alertMessage), expectedMessage);
    }

    // Method to select and set text in an input field
    public void selectAndSetText(By textbox, By input, String text) {
        WebUI.clickElement(textbox);
        WebUI.setText(input, text);
    }

    // Method to select an item from dropdown
    public void selectDropdown(By textbox) {
        WebUI.clickElement(textbox);
        WebUI.getWebElement(textbox).sendKeys(Keys.ARROW_DOWN, Keys.RETURN);
        WebUI.sleep(1);
    }

    // Method to open the page for adding a new supplier
    public void openAddSupplier() {
        //Step to open page add new supplier
        WebUI.clickElement(menu);
        WebUI.clickElement(menuPurchaseSupply);
        WebUI.waitForPageLoaded();
        WebUI.clickElement(iconSuggestMaterial);
        WebUI.clickElement(submenuSupplier);
        WebUI.waitForPageLoaded();
        //Check display right page add new supplier
        boolean checkMenu = WebUI.checkElementExist(headerAddTitle);
        Assert.assertTrue(checkMenu, "The system is unable to open the screen for creating a new supplier");
    }

    // Method to add a supplier in normal flow
    public void addSupplierNormal(Supplier supplier) {
        //Step to input information form
        selectAndSetText(textboxName, inputName, supplier.getName());
        selectDropdown(textboxField);
        selectAndSetText(textboxDOB, inputDOB, supplier.getDOB());
        selectDropdown(textboxTitle);
        selectAndSetText(textboxPhone, inputPhone, supplier.getPhone());
        selectAndSetText(textboxEmail, inputEmail, supplier.getEmail());
        selectAndSetText(textboxID, inputID, supplier.getId());
        selectAndSetText(textboxIdDate, inputIdDate, supplier.getIdDate());
        WebUI.clickElement(goodGroups);
        WebUI.setText(inputGoodGroups, "SP012");
        WebUI.sleep(2);
        WebUI.getWebElement(inputGoodGroups).sendKeys(Keys.ARROW_DOWN, Keys.RETURN);
        WebUI.clickElement(buttonUpdate);
        WebUI.waitForPageLoaded();
    }

    // Method to add a supplier successfully
    public void addSupplierSuccessfully(Supplier supplier) {
        // Add a supplier successfully and verify open screen supplier detail after success
        addSupplierNormal(supplier);
        boolean checkMenu = WebUI.checkElementExist(headerDetailSupplier);
        Assert.assertTrue(checkMenu, "The system is unable to open the screen for creating a new supplier");
    }

    // Method to add a supplier when only required field name is provided
    public void addSupplierWhenOnlyName(Supplier supplier) {
        // Add a supplier when only name is provided and check error message
        WebUI.clickElement(clearSupplierType);
        WebUI.getWebElement(inputSupplierCode).clear();
        selectAndSetText(textboxName, inputName, supplier.getName());
        WebUI.clickElement(buttonUpdate);
        WebUI.waitForPageLoaded();
        checkAlertMessageDisplayed("Loại nhà cung cấp chưa nhập\nMã nhà cung cấp chưa nhập");
    }

    // Method to add a supplier when only required field code is provided
    public void addSupplierWhenOnlySupplierCode() {
        // Add a supplier when only supplier code is provided and check error message
        WebUI.clickElement(clearSupplierType);
        WebUI.clickElement(buttonUpdate);
        WebUI.waitForPageLoaded();
        checkAlertMessageDisplayed("Loại nhà cung cấp chưa nhập\nTên khách hàng bắt buộc phải nhập");
    }

    // Method to add a supplier when only required field type is provided
    public void addSupplierWhenOnlySupplierType() {
        // Add a supplier when only supplier type is provided and check error message
        WebUI.getWebElement(inputSupplierCode).clear();
        WebUI.sleep(1);
        WebUI.clickElement(buttonUpdate);
        WebUI.waitForPageLoaded();
        checkAlertMessageDisplayed("Mã nhà cung cấp chưa nhập\nTên khách hàng bắt buộc phải nhập");
    }

    // Method to add a supplier without entering required fields
    public void addSupplierWithoutEnterRequiredField() {
        // Add a supplier without entering required fields and check error message
        WebUI.clickElement(clearSupplierType);
        WebUI.getWebElement(inputSupplierCode).clear();
        WebUI.clickElement(buttonUpdate);
        WebUI.waitForPageLoaded();
        checkAlertMessageDisplayed("Mã nhà cung cấp chưa nhập\nTên khách hàng bắt buộc phải nhập\nLoại nhà cung cấp chưa nhập");
    }

    // Method to add a supplier when phone number is invalid
    public void addSupplierWhenInvalidPhone(Supplier supplier) {
        addSupplierNormal(supplier);
        //Check error message
        WebUI.verifyEquals(WebUI.getElementText(alertMessage), "Điện thoại định dạng không đúng");
    }

    // Method to add a supplier when  email is invalid
    public void addSupplierWhenInvalidEmail(Supplier supplier) {
        addSupplierNormal(supplier);
        //Check error message
        checkAlertMessageDisplayed("Email định dạng không đúng");
    }

    // Method to add a supplier when Date of Birth is invalid
    public void addSupplierWhenInvalidDate(Supplier supplier) {
        addSupplierNormal(supplier);
        //Check error message
        checkAlertMessageDisplayed("Ngày sinh không hợp lệ (" + supplier.getDOB() + ")");
    }

    // Method to add a supplier when ID's date is invalid
    public void addSupplierWhenInvalidIdDate(Supplier supplier) {
        addSupplierNormal(supplier);
        //Check error message
        checkAlertMessageDisplayed("Ngày cấp không hợp lệ (" + supplier.getIdDate() + ")");
    }

    // Method to cancel adding a supplier
    public void cancelAddSupplier() {
        WebUI.clickElement(buttonCancel);
        boolean checkMenu = WebUI.checkElementExist(purchaseProposalScreen);
        Assert.assertTrue(checkMenu, "The system is unable to open the purchase proposal screen");
    }
}
