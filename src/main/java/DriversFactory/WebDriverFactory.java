package DriversFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;
import utils.PropertyReader;

import static utils.PropertyReader.getProperty;

public class WebDriverFactory {

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    private static WebDriver getDriver(){

        String browser = PropertyReader.getProperty("browserType");
        Browser browserEnum = Browser.valueOf(browser.toUpperCase());

        AbstractDriver abstractDriver = browserEnum.getDriverFactory();
        return abstractDriver.createDriver();

    }

    public static WebDriver initDriver() {
        WebDriver driver = ThreadGuard.protect(getDriver());
        driverThreadLocal.set(driver);
        return driverThreadLocal.get();
    }

    public static WebDriver get() {
        return driverThreadLocal.get();
    }

    public static void quitDriver() {
        driverThreadLocal.get().quit();
    }

}