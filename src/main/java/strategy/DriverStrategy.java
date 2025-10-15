package strategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import util.FrameworkProperties;

import java.time.Duration;

public class DriverStrategy {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverStrategy() {}

    /**
     * Initialize driver using properties from framework.properties
     */
    public static WebDriver initDriver() {
        String browser = FrameworkProperties.getBrowser();
        boolean headless = FrameworkProperties.isHeadless();

        return initDriver(BrowserType.valueOf(browser), headless);
    }

    /**
     * Initialize driver with specific parameters
     */
    public static WebDriver initDriver(BrowserType browserType, boolean headless) {
        if (driver.get() != null) {
            System.out.println("Driver already initialized for thread: " + Thread.currentThread().getId());
            return driver.get();
        }

        WebDriver webDriver = switch (browserType) {
            case CHROME -> createChromeDriver(headless);
            case FIREFOX -> createFirefoxDriver(headless);
            case EDGE -> createEdgeDriver(headless);
        };

        driver.set(webDriver);

        // Configure timeouts from properties
        webDriver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(FrameworkProperties.getImplicitWait()));
        webDriver.manage().timeouts()
                .pageLoadTimeout(Duration.ofSeconds(FrameworkProperties.getPageLoadTimeout()));
        webDriver.manage().timeouts()
                .scriptTimeout(Duration.ofSeconds(FrameworkProperties.getScriptTimeout()));

        if (!headless) {
            webDriver.manage().window().maximize();
        }

        System.out.println("Driver initialized: " + browserType + " (headless=" + headless + ")");
        return webDriver;
    }

    /**
     * Gets the current thread's driver instance
     */
    public static WebDriver getDriver() {
        if (driver.get() == null) {
            throw new IllegalStateException("Driver not initialized. Call initDriver() first.");
        }
        return driver.get();
    }

    /**
     * Quits driver and cleans up ThreadLocal
     */
    public static void quitDriver() {
        if (driver.get() != null) {
            try {
                driver.get().quit();
                System.out.println("Driver quit successfully for thread: " + Thread.currentThread().getId());
            } catch (Exception e) {
                System.err.println("Error quitting driver: " + e.getMessage());
            } finally {
                driver.remove();
            }
        }
    }

    private static WebDriver createChromeDriver(boolean headless) {
        ChromeOptions options = new ChromeOptions();

        if (headless) {
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--no-sandbox");
        } else {
            options.addArguments("--start-maximized");
        }

        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--remote-allow-origins=*");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        return new ChromeDriver(options);
    }

    private static WebDriver createFirefoxDriver(boolean headless) {
        FirefoxOptions options = new FirefoxOptions();

        if (headless) {
            options.addArguments("--headless");
            options.addArguments("--width=1920");
            options.addArguments("--height=1080");
        }

        options.addPreference("dom.webdriver.enabled", false);
        options.addPreference("useAutomationExtension", false);

        return new FirefoxDriver(options);
    }

    private static WebDriver createEdgeDriver(boolean headless) {
        EdgeOptions options = new EdgeOptions();

        if (headless) {
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--no-sandbox");
        } else {
            options.addArguments("--start-maximized");
        }

        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--remote-allow-origins=*");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        return new EdgeDriver(options);
    }

    public enum BrowserType {
        CHROME,
        FIREFOX,
        EDGE
    }
}