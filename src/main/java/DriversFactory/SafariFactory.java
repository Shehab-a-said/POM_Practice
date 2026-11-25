package DriversFactory;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class SafariFactory extends AbstractDriver {
    @Override
    public WebDriver createDriver() {
        return new SafariDriver(getOptions());
    }

    private SafariOptions getOptions() {
        SafariOptions options = new SafariOptions();
        options.get("--start-maximized");
        options.get("--incognito");
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        options.setAcceptInsecureCerts(true);
        return options;
    }
}
