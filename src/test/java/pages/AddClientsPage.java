package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AddClientsPage {


    WebDriver driver;

    public AddClientsPage() {
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li[text()=\"Sales\"]")
    public WebElement sales;

    @FindBy(xpath = "//button[text()=\"Add client\"]")
    public WebElement buttonAddClient;

    @FindBy(xpath = "(//div[@class = \" css-1d8n9bt\"])[2]")
    public WebElement clientsTagsInput;


    @FindBy(xpath = "//div[text()=\"Testtag\"]")
    public WebElement selecttesttag;

    @FindBy(id = "company_name_input_text")
    public WebElement companyInput;

    @FindBy(id = "client_name_input_text")
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


