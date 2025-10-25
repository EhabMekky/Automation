package base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import strategy.DriverStrategy;
import util.FrameworkProperties;
import util.Utils;

import java.io.IOException;

public class BaseTest {

    protected static WebDriver driver;

    @BeforeMethod
    public void setup()
    {
        driver = DriverStrategy.initDriver(DriverStrategy.BrowserType.EDGE, false);
        driver.get(FrameworkProperties.getBaseUrl());
    }

    @AfterMethod
    public void captureScreenshotOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            try {
                System.out.println("Test Failed! Taking screenshot...");
                Utils.takeScreenShot();
                System.out.println("Screenshot captured successfully for failed test: " + result.getName());
            } catch (IOException e) {
                System.out.println("Failed to capture screenshot: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
