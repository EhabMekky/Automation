package base;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import strategy.DriverStrategy;
import util.FrameworkProperties;
import util.Utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@Listeners(listeners.AllureTestListener.class)
public class BaseTest {

    protected static WebDriver driver;

    @BeforeMethod
    @Step("Setup: Initialize browser and navigate to base URL")
    public void setup()
    {
        driver = DriverStrategy.initDriver();
        driver.get(FrameworkProperties.getBaseUrl());

        Allure.addAttachment("Browser", DriverStrategy.BrowserType.EDGE.toString());
        Allure.addAttachment("Base URL", FrameworkProperties.getBaseUrl());
    }

    @AfterMethod
    public void captureScreenshotOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            try {
                System.out.println("Test Failed! Taking screenshot...");

                // Take screenshot for legacy storage
                Utils.takeScreenShot();

                // Attach screenshot to Allure
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                Allure.addAttachment("Failure Screenshot", "image/png",
                        new ByteArrayInputStream(screenshot), "png");

                System.out.println("Screenshot captured successfully for failed test: " + result.getName());
            } catch (IOException e) {
                System.out.println("Failed to capture screenshot: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}