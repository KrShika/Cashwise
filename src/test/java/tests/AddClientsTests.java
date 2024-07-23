package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddClientsPage;
import pages.HomePage;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.time.Duration;

public class AddClientsTests {



    WebDriver driver;
    HomePage homePage;
    AddClientsPage addClientsCashwise;
    Faker faker;

    @BeforeMethod
    public void beforeMethod(){
        this.driver = Driver.getDriver();
        this.homePage = new HomePage();
        this.addClientsCashwise = new AddClientsPage();
        this.faker = new Faker();
    }

    @AfterMethod
    public void afterMethod(){
        Driver.closeBrowser();
    }


    @Test
    public void testAddClients() {
        driver.get("https://cashwise.us/main");
        homePage.Login("Admin@gmail.com","admin1234");
        addClientsCashwise.sales.click();
        addClientsCashwise.buttonAddClient.click();
        SeleniumUtils.waitForSeconds(4);
        addClientsCashwise.clientsTagsInput.click();
        SeleniumUtils.waitForSeconds(4);
        addClientsCashwise.selecttesttag.click();
        addClientsCashwise.companyInput.sendKeys(faker.name().fullName());
        addClientsCashwise.fullNameInput.sendKeys(faker.name().name());
        addClientsCashwise.emailInput.sendKeys(faker.name().username()+"@gmail.com");
        addClientsCashwise.phoneNumberInput.sendKeys(faker.phoneNumber().phoneNumber());
        addClientsCashwise.addressInput.sendKeys(faker.address().fullAddress());
        addClientsCashwise.saveButton.click();
        String actual = driver.getCurrentUrl();
        String expected = "https://cashwise.us/dashboard/sales/clients/active?isCreate=false";
        Assert.assertFalse(actual.equals(expected));


    }


    @Test
    public void verifyAddClientNegative(){
        driver.get("https://cashwise.us/main");
        homePage.Login("Admin@gmail.com","admin1234");
        addClientsCashwise.sales.click();
        addClientsCashwise.buttonAddClient.click();
        addClientsCashwise.clientsTagsInput.click();
        addClientsCashwise.selecttesttag.click();
        addClientsCashwise.companyInput.sendKeys(faker.name().fullName());
        addClientsCashwise.fullNameInput.sendKeys(faker.name().name());
        addClientsCashwise.emailInput.sendKeys(faker.name().username());
        addClientsCashwise.phoneNumberInput.sendKeys(faker.phoneNumber().phoneNumber());
        addClientsCashwise.addressInput.sendKeys(faker.address().fullAddress());
        addClientsCashwise.saveButton.click();
        String expected = "Please enter a valid email address";
        String actual = driver.findElement(By.xpath("//p[text()=\"Please enter a valid email address\"]")).getText();
        Assert.assertEquals(actual,expected);

    }
}
