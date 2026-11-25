package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class ScreenShotUtils {

    public static void takeScreenShot (WebDriver driver , String ScreenshotName) {
        try
        {
            File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            File dest = new File("test-output/screenshots/" + ScreenshotName + ".png");
            FileUtils.copyFile(src, dest);
            AllureUtils.AttacheScreenShotToAllure(ScreenshotName, dest.getPath());

        }
        catch (Exception e)
        {
            System.out.println("Failed to take screenshot: " + e.getMessage());
        }

    }
}
