package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SellerPage {


    WebDriver driver;

    public SellerPage(){
        this.driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }




    @FindBy(xpath = "//li[text()=\"Expenses\"]")
    public WebElement expenses;


    @FindBy(xpath = "//button[text()=\"Add seller\"]")
    public WebElement buttonAddSeller;


    @FindBy(id = "company_name_input_text")
    public WebElement titleInput;


    @FindBy(id = "seller_name_input_text")
    public WebElement fullNameInput;

    @FindBy(id = "email_input_text")
    public WebElement emailInput;

    @FindBy(id = "phone_number_input_text")
    public WebElement phoneNumberInput;

    @FindBy(id = "address_input_text")
    public WebElement addressInput;

    @FindBy(xpath = "//button[text()=\"Save\"]")
    public WebElement saveButton;


    @FindBy(xpath = "//button[text()=\"Cancel\"]")
    public WebElement cancelButton;






}
