package fullFlow;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.BitheapShopPage;
import pages.CartPage;
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
    private static CartPage cartPage;

    @BeforeClass
    public static void setUp()
    {
        driver = DriverStrategy.initDriver(DriverStrategy.BrowserType.EDGE, false);
        driver.get(FrameworkProperties.getBaseUrl());
        homePage = new HomePage();
        loginPage = new LoginPage();
        shopPage = new BitheapShopPage();
        cartPage = new CartPage();
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

        // Get initial cart count
        int initialCount = cartPage.getCartItemCount();

        shopPage.addChatbotEbookToCart();

        cartPage.clickCartIcon();

// Validate cart count increased
        boolean isIncreased = cartPage.isCartCountIncreased(initialCount);
        Assert.assertTrue(isIncreased, "Cart count did not increase after adding product");

// Or verify specific count
        int newCount = cartPage.getCartItemCount();
        Assert.assertEquals(newCount, initialCount + 1, "Cart count should increase by 1");    }

    @AfterClass
    public static void tearDown()
    {
        DriverStrategy.quitDriver();
    }
}
