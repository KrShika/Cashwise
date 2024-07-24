package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class InvoicePage {
    WebDriver driver;
    public InvoicePage(){
        this.driver= Driver.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//aside[@id=\"sidebar\"]//li[text()=\"Sales\"]")
    public WebElement sales;
    @FindBy(xpath = "//a[text()='Invoice']")
    public WebElement invoiceBtn;

    @FindBy(xpath = "//tbody/tr")
    public List<WebElement> InvoiceList;

    @FindBy(xpath = "//label[text()='Status']/..")
    public WebElement statusInput;

    @FindBy(xpath = "//li[text()='All statuses']")
    public WebElement allStatusesDrpDwn;

    @FindBy(xpath = "//li[text()='Paid']")
    public WebElement PaidStatusDrpDwn;




}
