package utils;
import com.google.common.collect.ImmutableMap;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.file.Path;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;
import static java.nio.file.Files.newInputStream;

public class AllureUtils {

    // clears the old Allure results directory before running the tests .
    public static void ClearAllureResults() {

        try
        {
            FileUtils.deleteQuietly(new File("test-output/allure-results"));
        }
        catch (Exception e)
        {
            System.out.println("Failed to clear Allure results: " + e.getMessage());
        }
    }

    public static void AttacheScreenShotToAllure (String ScreenshotName , String ScreenshotPath) {
        try
        {
            Allure.attachment(ScreenshotName, newInputStream(Path.of(ScreenshotPath)));
        }
        catch (Exception e)
        {
            System.out.println("Failed to attach screenshot to Allure report: " + e.getMessage());
        }
    }

    public static void setAllureEnvironment() {
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("OS", PropertyReader.getProperty("os.name"))
                        .put("JDK Version", PropertyReader.getProperty("java.runtime.version"))
                        .put("URL", "https://www.saucedemo.com/")
                        .build(),
                PropertyReader.getProperty("user.dir")
                        + File.separator + "test-output/allure-results" + File.separator
        );
    }
}