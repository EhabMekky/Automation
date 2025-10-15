import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.LoginPage;
import strategy.DriverStrategy;
import util.FrameworkProperties;

import java.time.Duration;

public class EndToEndTest {
    private static WebDriver driver;
    private static WebDriverWait wait;
    private static HomePage homePage;
    private static LoginPage loginPage;

    @BeforeClass
    public static void setUp()
    {
        driver = DriverStrategy.initDriver();
        driver.get(FrameworkProperties.getBaseUrl());
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        homePage = new HomePage();
        loginPage = new LoginPage();
    }

    @Test
    public void endToEndFlow()
    {
        driver.get("https://bitheap.tech/");
        System.out.println(driver.getTitle());

        homePage.clickLogin();
        loginPage.enterUsername("test@alpha.com");
        loginPage.enterPassword("Test@1234");
        loginPage.togglePasswordVisibility();
        loginPage.checkRememberMe();
        loginPage.clickSignIn();
    }

    @AfterClass
    public static void tearDown()
    {
        DriverStrategy.quitDriver();
    }
}
