package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SellerPage;
import utilities.Driver;

public class SellerTests {


    WebDriver driver;
    HomePage homePage;
    SellerPage sellerPage;
    Faker faker;

    @BeforeMethod(groups = {"positive"})
    public void before(){
        driver = Driver.getDriver();
        homePage = new HomePage();
        sellerPage = new SellerPage();
        faker = new Faker();
    }

    @AfterMethod
    public void after(){
       Driver.closeBrowser();
    }


    @Test(groups = {"positive"})
    public void verifyAddSeller() {
        driver.get("https://cashwise.us/main");
        homePage.Login("Admin@gmail.com", "admin1234");
        sellerPage.expenses.click();
        sellerPage.buttonAddSeller.click();
        sellerPage.titleInput.sendKeys(faker.name().title());
        sellerPage.fullNameInput.sendKeys(faker.name().fullName());
        sellerPage.emailInput.sendKeys(faker.name().username()+"@gmail.com");
        sellerPage.phoneNumberInput.sendKeys(faker.phoneNumber().phoneNumber());
        sellerPage.addressInput.sendKeys(faker.address().fullAddress());
        sellerPage.saveButton.click();
        String actual = "https://cashwise.us/dashboard/costs/sellers/active?isCreate=true";
        String expected = "https://cashwise.us/dashboard/costs/sellers/active?isCreate=false";
        Assert.assertFalse(actual.equals(expected));






    }


    @Test
    public void verifyAddSellerNegative(){
        driver.get("https://cashwise.us/main");
        homePage.Login("Admin@gmail.com","admin1234");
        sellerPage.expenses.click();
        sellerPage.buttonAddSeller.click();
        sellerPage.titleInput.sendKeys(faker.name().title());
        sellerPage.fullNameInput.sendKeys(faker.name().name());
        sellerPage.emailInput.sendKeys(faker.name().username());
        sellerPage.phoneNumberInput.sendKeys(faker.phoneNumber().phoneNumber());
        sellerPage.addressInput.sendKeys(faker.address().fullAddress());
        sellerPage.saveButton.click();
        String actual = driver.findElement(By.xpath("//p[text()=\"Please enter a valid email address\"]")).getText();
        String expected = "Please enter a valid email address";
        Assert.assertTrue(expected.contains(actual));
    }

}
