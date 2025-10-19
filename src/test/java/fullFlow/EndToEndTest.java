package fullFlow;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BitheapShopPage;
import pages.HomePage;
import pages.LoginPage;
import strategy.DriverStrategy;
import util.FrameworkProperties;

import java.time.Duration;

public class EndToEndTest {
    private static WebDriver driver;
    private static HomePage homePage;
    private static LoginPage loginPage;
    private static BitheapShopPage shopPage;

    @BeforeClass
    public static void setUp()
    {
        driver = DriverStrategy.initDriver();
        driver.get(FrameworkProperties.getBaseUrl());
        homePage = new HomePage();
        loginPage = new LoginPage();
        shopPage = new BitheapShopPage();
    }


    @Test
    public void endToEndFlow()
    {
        homePage.waitCookieWindowPresent()
                .acceptAllCookies()
                .getPageTitle()
                .isWelcomeHeadingDisplayed()
                .clickLogin();

        loginPage.enterUsername("test@alpha.com")
        .enterPassword("Test@1234")
        .togglePasswordVisibility()
        .checkRememberMe()
        .clickSignIn();

        homePage.clickShopNav();

        shopPage.addChatbotEbookToCart();
    }

    @AfterClass
    public static void tearDown()
    {
        DriverStrategy.quitDriver();
    }
}
