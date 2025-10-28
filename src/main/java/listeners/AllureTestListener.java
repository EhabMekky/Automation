package listeners;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import strategy.DriverStrategy;

/**
 * Allure TestNG Listener for automatic screenshot attachment on test failure
 */
public class AllureTestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Starting test: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed: " + result.getName());

        // Capture and attach screenshot on failure
        try {
            if (DriverStrategy.getDriver() != null) {
                saveScreenshot(result.getName());
            }
        } catch (Exception e) {
            System.err.println("Failed to capture screenshot: " + e.getMessage());
        }

        // Attach exception details
        if (result.getThrowable() != null) {
            saveTextLog("Exception Details", result.getThrowable().toString());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test skipped: " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Not implemented
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test suite started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test suite finished: " + context.getName());
    }

    /**
     * Attach screenshot to Allure report
     */
    @Attachment(value = "Screenshot: {0}", type = "image/png")
    public byte[] saveScreenshot(String screenshotName) {
        try {
            return ((TakesScreenshot) DriverStrategy.getDriver()).getScreenshotAs(OutputType.BYTES);
        } catch (Exception e) {
            System.err.println("Error taking screenshot: " + e.getMessage());
            return new byte[0];
        }
    }

    /**
     * Attach text log to Allure report
     */
    @Attachment(value = "{0}", type = "text/plain")
    public String saveTextLog(String message, String content) {
        return content;
    }
}