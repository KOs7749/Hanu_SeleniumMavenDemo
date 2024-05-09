package dinhthe.pages;

import dinhthe.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SupplierPage extends CommonPage {

    //Open Supplier Page
    protected By purchaseProposalScreen = By.xpath("//div[@id='header-title' and contains(div, 'Đề xuất vật tư')]");
    protected By iconSupplier = By.xpath("//i[@class='sidemenu-item-icon icon-shipped']");
    protected By headerListTitle = By.xpath("//span[contains(text(),'Danh sách nhà cung cấp')]");
    protected By boxSearch = By.xpath("//form[@class='form-ajax ajax-form-done']");
    protected By inputSearchName = By.xpath("//input[@placeholder='Tìm kiếm']");
    protected By searchResultLocator = By.xpath("//tr[contains(@class, 'table-row-body')]/td[@col='name']");
    protected By rowLocator = By.xpath("//tr[contains(@class, 'table-row-body')][1]");
    private By firstCheckbox = By.xpath("(//input[@type='checkbox'])[2]"); // assuming first checkbox
    private By deleteButton = By.xpath("//a[@title='Xóa']"); // delete button
    private By confirmDeleteButton = By.xpath("//div[@class='dialog-btns dialog-confirm-btns']//div[text()='Đồng ý']"); // confirm delete button
    private By cancelButton = By.xpath("//div[@class='dialog-btns dialog-confirm-btns']//div[text()='Hủy bỏ']"); // cancel delete button
    private By tableRow = By.xpath("//tr[contains(@class, 'table-row-body')]");
    private By tableRowChecked = By.xpath("//tr[contains(@class, 'table-row-body checked')]");
    private By checkboxLocator = By.xpath("//input[@name='ID[]']");
    protected By headerDetailSupplier = By.xpath("//a[normalize-space()='Thông tin chung']");


    public void openListSupplier() {
        WebUI.clickElement(menu);
        WebUI.clickElement(menuPurchaseSupply);
        WebUI.clickElement(iconSupplier);
    }

    public void verifyOpenListDupplier() {
        boolean checkMenu = WebUI.checkElementExist(headerListTitle);
        Assert.assertTrue(checkMenu, "The system is unable to open the screen for creating a new supplier");
    }

    public void selectFirstCheckbox() {
        WebUI.sleep(5);
        WebUI.clickElement(firstCheckbox);
        //Check if the checkbox is checked or not
    }

    public void deleteOneSupplier() {
        WebUI.clickElement(deleteButton);
        WebUI.waitForElementVisible(confirmDeleteButton);
        WebUI.clickElement(confirmDeleteButton);
        WebUI.sleep(5);
    }

    public void deleteMultipleSuppliers() {
        WebUI.sleep(3);
        List<WebElement> checkboxes = WebUI.getWebElements(checkboxLocator);
        for (int i = 0; i < 2; i++) {
            checkboxes.get(i).click();
        }
        WebUI.clickElement(deleteButton);
        WebUI.clickElement(confirmDeleteButton);
        WebUI.sleep(5);
    }

    public void verifySupplierDeleted() {
        // Kiểm tra xem phần tử 'table-row-body checked' đã biến mất hoàn toàn sau khi xóa
        boolean isSupplierDeleted = WebUI.checkElementNotExist(tableRowChecked);
        Assert.assertTrue(isSupplierDeleted, "Supplier is still present in the list after deletion.");
    }

    public void cancelDeleteOperation() {
        WebUI.clickElement(deleteButton);
        WebUI.waitForElementVisible(confirmDeleteButton);
        WebUI.clickElement(cancelButton);
        boolean isPresent = WebUI.checkElementExist(tableRow);
        Assert.assertTrue(isPresent, "Supplier is still present in the list");
    }
}



