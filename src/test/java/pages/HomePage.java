package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePage {
    WebDriver driver;

    public HomePage(){
        this.driver= Driver.getDriver();
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//button[text()=\"Sign in\"]")
    public WebElement signInButton;

    @FindBy(id = "email_input_text")
    public WebElement usernameInput;

    @FindBy(id = "password_input_text")
    public WebElement passwordInput;

    @FindBy(xpath = "//form//button[text()=\"Sign in\"]")
    public WebElement signInBtnInForm;



    public void Login(String username, String password){
        signInButton.click();
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        signInBtnInForm.click();

    }




}
