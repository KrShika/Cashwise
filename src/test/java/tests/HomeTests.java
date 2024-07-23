package tests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.Driver;

public class HomeTests {


    WebDriver driver = Driver.getDriver();

    HomePage homePage = new HomePage();

@Test
public void testLogin(){
        driver.get("https://cashwise.us/main");
        homePage.Login("Admin@gmail.com","admin1234");





}






}
