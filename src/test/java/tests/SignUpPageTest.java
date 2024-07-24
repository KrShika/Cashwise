package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.SignUpPage;
import utilities.Driver;

public class SignUpPageTest {
    SignUpPage signUpPage = new SignUpPage();
    @Test
    public void testSignUp2() throws InterruptedException {
        WebDriver driver = Driver.getDriver();
        Driver.getDriver().get("https://cashwise.us/main");
        Thread.sleep(2000);
        signUpPage.signUpButton.click();


        //signUpPage.dropdown.click();
       // signUpPage.selectCategory.click();
        //signUpPage.dropdown.click();

//        WebElement element = driver.findElement(By.xpath("//input[@name=\"business_area_id\"]"));
//        Select select = new Select(element);


        signUpPage.testSignUp1("xxxx@gmail.com", "123456", "123456", "Ivan", "Rakitic", "actor", "" "as", "kg");
//        signUpPage.selectCategory.click();
//        signUpPage.currencyInput.click();
//        signUpPage.currencySelect.click();
        signUpPage.businessArea.click();


    }
}

