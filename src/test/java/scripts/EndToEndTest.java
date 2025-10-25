package scripts;

import base.BaseTest;
import com.fasterxml.jackson.databind.JsonNode;
import org.testng.annotations.*;
import pages.BitheapShopPage;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import strategy.DriverStrategy;

public class EndToEndTest extends BaseTest {
    private static HomePage homePage;
    private static LoginPage loginPage;
    private static BitheapShopPage shopPage;
    private static CartPage cartPage;
    int initialCount;
    private static JsonNode loginData;
    private static String username;
    private static String password;

    @BeforeMethod
    public void setUp()
    {
        homePage = new HomePage();
        loginPage = new LoginPage();
        shopPage = new BitheapShopPage();
        cartPage = new CartPage();
        loginData = util.TestDataLoader.loadLoginData();
        if (loginData == null || loginData.get("validUser") == null) {
            throw new RuntimeException("Login data not found. Check your JSON file structure.");
        }
        username = loginData.get("validUser").get("username").asText();
        password = loginData.get("validUser").get("password").asText();
    }


    @Test
    public void endToEndFlow() {
        homePage.waitCookieWindowPresent()
                .acceptAllCookies()
                .getPageTitle()
                .isWelcomeHeadingDisplayed()
                .clickLogin();


        loginPage.enterUsername(username)
                .enterPassword(password)
                .togglePasswordVisibility()
                .checkRememberMe()
                .clickSignIn();

        homePage.clickShopNav();

        shopPage.addChatbotEbookToCart();

        initialCount = cartPage.getCartItemCount();
        cartPage.assertCartCount(initialCount)
                .clickCartIcon()
                .assertCartCountIncreased(initialCount)
                .clickProceedToCheckout();
    }



    @AfterClass
    public static void tearDown()
    {
        DriverStrategy.quitDriver();
    }
}