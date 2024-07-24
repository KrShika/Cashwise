package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;


public class SignUpPage {
    WebDriver driver;
    public SignUpPage() {
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver, this);

    }
    @FindBy(xpath = "//button[@class='MuiButton-root MuiButton-outlined MuiButton-outlinedPrimary MuiButton-sizeMedium MuiButton-outlinedSizeMedium MuiButtonBase-root css-k6k41x']")
    public WebElement signUpButton;

    @FindBy(id = "email_input_text")
    public WebElement emailInput;

    @FindBy(id = "password_input_text")
    public WebElement passwordInput;

    @FindBy(id="repeat_password_input_text")
    public WebElement repeatPassword;


    @FindBy(xpath = "//button[@form='register-form-1']")
    public WebElement continueButton;

    @FindBy(id = "first_name_input_text")
    public WebElement firstName;

    @FindBy(id="last_name_input_text")
    public WebElement surnameInput;

    @FindBy(id = "company_name_input_text")
    public WebElement businessName;

    @FindBy(xpath = "//div[@id='mui-component-select-business_area_id']")
    public WebElement businessArea;

    @FindBy (id="address_input_text")
    public WebElement addressInput;

    @FindBy(id="mui-component-select-currency")
    public WebElement currencyInput;

    @FindBy(xpath = "//div[text()='KGS (C)']")
    public WebElement currencySelect;



    @FindBy(xpath = "//input[@name=\"business_area_id\"]")
    public  WebElement dropDown;

//    @FindBy(xpath = "//input[@name=\\\"business_area_id\\\"]\"")
//    public WebElement dropdown;



    @FindBy(xpath = "//button[@form='register-form-2']")
    public WebElement signUpButton2;

    public void testSignUp1(String email, String password, String reppassword,
                            String name, String surname, String busName,
                            String busArea, String address, String currency ){
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        repeatPassword.sendKeys(reppassword);
        continueButton.click();
        firstName.sendKeys(name);
        surnameInput.sendKeys(surname);
        businessName.sendKeys(busName);

        addressInput.sendKeys(address);
        currencyInput.sendKeys(currency);
        continueButton.click();
    }

}

