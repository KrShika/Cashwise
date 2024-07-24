package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CheckPage;
import pages.HomePage;
import utilities.Driver;
import utilities.SeleniumUtils;

public class CheckTests {


    WebDriver driver;
    HomePage homePage;
    CheckPage checkPage;
    Faker faker;

    @BeforeMethod
    public void beforeMethod(){
        this.driver = Driver.getDriver();
        this.homePage = new HomePage();
        this.checkPage = new CheckPage();
        this.faker = new Faker();
    }

    @AfterMethod
    public void afterMethod(){
        Driver.closeBrowser();
    }


    @Test
    public void verifyAddCheck(){
        driver.get("https://cashwise.us/main");
        homePage.Login("Admin@gmail.com", "admin1234");
        checkPage.expensesButton.click();
        checkPage.checkButton.click();
        checkPage.addCheck.click();
        checkPage.titleField.sendKeys(faker.name().title());
        checkPage.sellerField.click();
        SeleniumUtils.waitForSeconds(3);
        checkPage.firstSelect.click();
        checkPage.toInputField.sendKeys(faker.number().digits(8));
        checkPage.addButton.click();
        checkPage.selectFromAddInput.click();
        checkPage.saveButton.click();
        String actual = driver.findElement(By.xpath("//div/table/tbody/tr/td[1]")).getText();
        String expected = "obin Jast";
        Assert.assertTrue(actual.contains(expected));
    }


    @Test
    public void verifyAddCheckNegative(){
        driver.get("https://cashwise.us/main");
        homePage.Login("Admin@gmail.com", "admin1234");
        checkPage.expensesButton.click();
        checkPage.checkButton.click();
        checkPage.addCheck.click();
        checkPage.titleField.sendKeys(faker.name().title());
        checkPage.sellerField.click();
        SeleniumUtils.waitForSeconds(3);
        checkPage.firstSelect.click();
        checkPage.addButton.click();
        checkPage.selectFromAddInput.click();
        checkPage.saveButton.click();
        String expected = driver.findElement(By.id("To_input_text")).getText();
        Assert.assertTrue(expected.isBlank());
    }








}
