package Pages;

import Bots.ActionsBot;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
    // Variables
    private final WebDriver driver;
    private final ActionsBot actionsBot;

    // locators
    private final By userName = By.id("user-name");
    private final By passWord = By.id("password");
    private final By loginButton = By.id("login-button");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.actionsBot= new ActionsBot(driver);
    }

    // Actions
    @Step("Login to web portal with username: {username} and password: {password}")
    public LoginPage login (String username, String password) {

        actionsBot.type(userName,username);
        actionsBot.type(passWord,password);
        actionsBot.click(loginButton);
        return this;
    }

    // Validations
    @Step("Verify that user is logged in and redirected to the expected URL: {expectedUrl}")
    public HomePage IsLoggedIn(String expectedUrl) {
        Assert.assertEquals(driver.getCurrentUrl() , expectedUrl);
        return new HomePage(driver);
    }
}


