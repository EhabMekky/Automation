package scripts;

import base.BaseTest;
import com.fasterxml.jackson.databind.JsonNode;
import io.qameta.allure.*;
import org.testng.annotations.*;
import pages.BitheapShopPage;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import strategy.DriverStrategy;

@Epic("E-Commerce Testing")
@Feature("End-to-End Shopping Flow")
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
    @Step("Initialize page objects and load test data")
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

        Allure.parameter("Username", username); // Log username parameter to verify correct data is used
    }


    @Test
    @Story("Complete Shopping Journey")
    @Description("Test covers the complete e-commerce flow: Login -> Browse -> Add to Cart -> Checkout")
    @Severity(SeverityLevel.CRITICAL)
    public void endToEndFlow() {
        acceptCookiesAndVerifyHomePage();
        loginToApplication();
        navigateToShopAndAddProduct();
        verifyCartAndProceedToCheckout();
    }

    @Step("Accept cookies and verify home page is displayed")
    private void acceptCookiesAndVerifyHomePage() {
        homePage.waitCookieWindowPresent()
                .acceptAllCookies()
                .getPageTitle()
                .isWelcomeHeadingDisplayed()
                .clickLogin();
    }

    @Step("Login with username: {username}")
    private void loginToApplication() {
        loginPage.enterUsername(username)
                .enterPassword(password)
                .togglePasswordVisibility()
                .checkRememberMe()
                .clickSignIn();
    }

    @Step("Navigate to shop and add Chatbot Ebook to cart")
    private void navigateToShopAndAddProduct() {
        homePage.clickShopNav();
        shopPage.addChatbotEbookToCart();
    }

    @Step("Verify cart count and proceed to checkout")
    private void verifyCartAndProceedToCheckout() {
        initialCount = cartPage.getCartItemCount();
        Allure.addAttachment("Initial Cart Count", String.valueOf(initialCount));

        cartPage.assertCartCount(initialCount)
                .clickCartIcon()
                .assertCartCountIncreased(initialCount)
                .clickProceedToCheckout();
    }

    @AfterClass
    @Step("Cleanup: Close browser and quit driver")
    public static void tearDown()
    {
        DriverStrategy.quitDriver();
    }
}