package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddProductPage;
import pages.HomePage;
import utilities.Driver;

public class AddProductTests {


    WebDriver driver;
    AddProductPage addProductPage ;
    Faker faker;
    HomePage homePage;



    @BeforeMethod
    public void beforeMethod(){
        this.driver = Driver.getDriver();
        this.homePage = new HomePage();
        this.addProductPage = new AddProductPage();
        this.faker = new Faker();
    }

    @AfterMethod
    public void afterMethod(){
        Driver.closeBrowser();
    }






   @Test
    public void cashwiseSignIn(){
        driver.get("https://cashwise.us/main");
        homePage.Login("ajgerasydykova2@gmail.com", "Kaspersky1230");
        addProductPage.expenses.click();
        addProductPage.products.click();
        addProductPage.addProdButton.click();
        addProductPage.nameInput.sendKeys(faker.name().name());
        addProductPage.priceInput.sendKeys(faker.number().digits(4));
        addProductPage.serviceInp.click();
        addProductPage.productOption.click();
        addProductPage.category.click();
        addProductPage.selectCategory.click();
        addProductPage.description.sendKeys("Tech");
        addProductPage.dateOfPay.sendKeys("07/08/2024");
        addProductPage.remindBefore.sendKeys(faker.number().digit());
        addProductPage.repeat.click();
        addProductPage.saveButton.click();
        System.out.println(driver.getCurrentUrl());
        String actual = driver.getCurrentUrl();
        String expected = "https://cashwise.us/dashboard/costs/expenses?isCreate=false";
        Assert.assertFalse(actual.equals(expected));


    }

    @Test
    public void VerifyAddProductIsNegative(){
        driver.get("https://cashwise.us/main");
        homePage.Login("ajgerasydykova2@gmail.com", "Kaspersky1230");
        addProductPage.expenses.click();
        addProductPage.products.click();
        addProductPage.addProdButton.click();
        addProductPage.nameInput.sendKeys("");
        addProductPage.priceInput.sendKeys(faker.number().digits(4));
        addProductPage.serviceInp.click();
        addProductPage.productOption.click();
        addProductPage.category.click();
        addProductPage.selectCategory.click();
        addProductPage.description.sendKeys("Tech");
        addProductPage.dateOfPay.sendKeys("07/08/2024");
        addProductPage.remindBefore.sendKeys(faker.number().digit());
        addProductPage.repeat.click();
        addProductPage.saveButton.click();
        String expected = "Product title cannot be empty\n";
        String actual = driver.findElement(By.className("css-7ndbs7")).getText();
        Assert.assertTrue(expected.contains(actual));
    }















}
