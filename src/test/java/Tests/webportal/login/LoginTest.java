package Tests.webportal.login;

import DriversFactory.WebDriverFactory;
import Pages.LoginPage;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static utils.PropertyReader.getProperty;

public class LoginTest {
    // Variable to hold the WebDriver instance that will be used across all the test methods in this class
    WebDriver driver;

    @Test
    @Description("verify that user is redirected to home page after providing valid credentials")
    @Tag("ValidLogin")
    @Owner("Shehab")
    @Severity(SeverityLevel.CRITICAL)
    @Link("confluence link")
    @TmsLink("Link to Test Case in Test Management System")
    @Issue("Link to related issue in Issue Tracking System (user story, bug, etc.)")
    public void ValidLoginTC(){
        Allure.getLifecycle().updateTest(testResult -> testResult.setName("Valid Login"));
        new LoginPage(driver)
                .login(getProperty("validUsername"), getProperty("validPassword"))
                .IsLoggedIn("https://www.saucedemo.com/inventory.html");
    }

    //Behavior-based Hierarchy
    @Epic("Web portal")
    @Feature("Login Feature")
    @Story("invalid Test Cases")
    @Test //failed test case
    public void InvalidLoginTC() {
        new LoginPage(driver)
                .login(getProperty("invalidUsername"), getProperty("invalidPassword"))
                .IsLoggedIn("https://www.saucedemo.com/inventory.html");
    }

    @BeforeMethod
    public void setup(){
        driver = WebDriverFactory.initDriver();
        driver.get(getProperty("baseUrl"));
    }

    @AfterMethod
    public void teardown(){
        WebDriverFactory.quitDriver();
    }
}
