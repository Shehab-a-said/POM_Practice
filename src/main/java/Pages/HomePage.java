package Pages;

import Bots.ActionsBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage {

    // Variables
    private final WebDriver driver;
    private final ActionsBot actionsBot;

    // Locators
    private final  By addToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    private final  By cartIcon = By.className("shopping_cart_badge");

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.actionsBot= new ActionsBot(driver);
    }

    // Actions
    public  HomePage  addToCart(){
        actionsBot.click(addToCartButton);
        return this;
    }

    // Validations
    public void validateCartIcon(){
        String cartIconText = actionsBot.getText(cartIcon);
        Assert.assertEquals(cartIconText , "1");
    }
}
