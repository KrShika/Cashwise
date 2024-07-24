package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddProductPage;
import pages.HomePage;
import pages.InvoicePage;
import utilities.Driver;

public class InvoiceFilterTests {
    WebDriver driver;
    InvoicePage invoicePage ;
    Faker faker;
    HomePage homePage;



    @BeforeMethod
    public void beforeMethod(){
        this.driver = Driver.getDriver();
        this.homePage = new HomePage();
        this.invoicePage = new InvoicePage();
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
        invoicePage.sales.click();
        invoicePage.invoiceBtn.click();

        invoicePage.statusInput.click();

        invoicePage.PaidStatusDrpDwn.click();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertEquals(invoicePage.InvoiceList.size(),1);
        invoicePage.statusInput.click();
        invoicePage.allStatusesDrpDwn.click();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertEquals(invoicePage.InvoiceList.size(),2);

    }



}
