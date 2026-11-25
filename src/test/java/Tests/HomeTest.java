package Tests;

import DriversFactory.WebDriverFactory;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.JsonReader;
import utils.PropertyReader;

public class HomeTest {
   // Variable to hold the WebDriver instance that will be used across all the test methods in this class
    WebDriver driver;
    JsonReader jsonReader ;

    @Test
    public void addToCartTC(){
        new LoginPage(driver)
                .login(jsonReader.getJsonData("username"), jsonReader.getJsonData("password"))
                .IsLoggedIn("https://www.saucedemo.com/inventory.html")
                .addToCart()
                .validateCartIcon();
    }

    @BeforeMethod
    public void setup(){
        jsonReader = new JsonReader("login-data");
        driver = WebDriverFactory.initDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void teardown(){
        WebDriverFactory.quitDriver();
    }
}
