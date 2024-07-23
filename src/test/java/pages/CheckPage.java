package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CheckPage {


    WebDriver driver;


    public CheckPage(){
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//li[text()=\"Expenses\"]")
    public WebElement expensesButton;

    @FindBy(linkText = "Check")
    public WebElement checkButton;

    @FindBy(xpath = "//button[text()=\"Add check\"]")
    public WebElement addCheck;

    @FindBy(id = "invoice_title_input_text")
    public WebElement titleField;

    @FindBy(xpath = "//div[@class=\" css-ackcql\"]")
    public WebElement sellerField;

    @FindBy(xpath = "//h3[text()=\"Direct Group Director\"]")
    public WebElement firstSelect;

    @FindBy(id = "To_input_text")
    public WebElement toInputField;

    @FindBy(xpath = "//button[text()=\"Add\"]")
    public WebElement addButton;

    @FindBy(xpath = "//p[text()=\"obin Jast\"]")
    public WebElement selectFromAddInput;

    @FindBy(xpath = "//button[text()=\"Save\"]")
    public WebElement saveButton;











}
