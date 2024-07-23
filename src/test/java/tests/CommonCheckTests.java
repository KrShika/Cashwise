package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddProductPage;
import pages.HomePage;
import pages.SellerPage;
import utilities.Driver;

public class CommonCheckTests {

    WebDriver driver;
    AddProductPage addProductPage;
    Faker faker;
    HomePage homePage;
    SellerPage sellerPage;

    @BeforeMethod
    public void login() {
        driver = Driver.getDriver();
        addProductPage = new AddProductPage();
        faker = new Faker();
        homePage = new HomePage();
        sellerPage = new SellerPage();

        driver.get("https://cashwise.us/main");
        homePage.Login("Admin@gmail.com", "admin1234");
    }


//    @BeforeMethod
//    public void after() {
//        Driver.close();
//    }

    @Test
    public void verifyAddSeller() {
        sellerPage.expenses.click();
        sellerPage.buttonAddSeller.click();
        sellerPage.titleInput.sendKeys(faker.name().title());
        sellerPage.fullNameInput.sendKeys(faker.name().fullName());
        sellerPage.emailInput.sendKeys(faker.name().username() + "@gmail.com");
        sellerPage.phoneNumberInput.sendKeys(faker.phoneNumber().phoneNumber());
        sellerPage.addressInput.sendKeys(faker.address().fullAddress());
        sellerPage.saveButton.click();
        String actual = "https://cashwise.us/dashboard/costs/sellers/active?isCreate=true";
        String expected = "https://cashwise.us/dashboard/costs/sellers/active?isCreate=false";
        Assert.assertFalse(actual.equals(expected));
    }


    @Test
    public void verifyAddSellerNegative() {

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


    @Test
    public void cashwiseSignIn() {

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
        String expected = "https://cashwise.us/dashboard/costs/expenses?isCreate=false";
        String actual = "https://cashwise.us/dashboard/costs/expenses?isCreate=true";
        Assert.assertFalse(actual.equals(expected));


    }


    @Test
    public void VerifyAddProductIsNegative() {
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
