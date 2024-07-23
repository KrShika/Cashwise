package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AddProductPage {

    WebDriver driver;

    public AddProductPage() {


        this.driver = Driver.getDriver();
        PageFactory.initElements(driver, this);

    }




        //MainPage

        @FindBy(xpath = "//button[text()='Sign in']")
        public WebElement signInButton1;

        @FindBy(id = "email_input_text")
        public WebElement usernameInp;

        @FindBy(name = "password")
        public WebElement passwordInp;


        @FindBy(xpath = "//button[@type=\"submit\" and text()='Sign in']")
        public WebElement submitButton;


//2(Infographics page)

        @FindBy(linkText = "Infographics")
        public WebElement infoGraphics;

        @FindBy(xpath = "//aside[@id=\"sidebar\"]//li[text()=\"Expenses\"]")
        public WebElement expenses;

        @FindBy(xpath = "//a[@href=\"/dashboard/costs/expenses\"]")
        public WebElement products;


        //3 (Expenses Page)

        @FindBy(xpath = "//button[text()='Add product and services']")
        public WebElement addProdButton;

        //--

        @FindBy(id = "product_title_input_text")
        public WebElement nameInput;

        @FindBy(id = "product_price_input_text")
        public WebElement priceInput;

        @FindBy(id = "mui-component-select-service_type_id")
        public WebElement serviceInp;

        @FindBy(xpath = "//li[contains(text(), \"Product\")]")
        public WebElement productOption;

        @FindBy(id = "mui-component-select-category_id")
        public WebElement category;

        @FindBy(xpath = "//li[contains(text(), \"IT\")]")
        public WebElement selectCategory;

        @FindBy(name = "product_description")
        public WebElement description;

        @FindBy(id = "undefined_input_text")
        public WebElement dateOfPay;

        @FindBy(id = "remind_before_day_input_text")
        public WebElement remindBefore;

        @FindBy(xpath = "//input[@value=\"REPEAT_EVERY_MONTH\"]")
        public WebElement repeat;

        @FindBy(xpath = "//button[@type=\"submit\"]")
        public WebElement saveButton;

        @FindBy(xpath = "//button[contains(text(), \"Cancel\")]")
        public WebElement cancelButton;


    }
