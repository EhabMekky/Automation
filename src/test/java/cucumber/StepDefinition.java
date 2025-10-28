package cucumber;

import com.fasterxml.jackson.databind.JsonNode;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import pages.BitheapShopPage;
import pages.HomePage;
import pages.LoginPage;
import strategy.DriverStrategy;
import util.FrameworkProperties;

public class StepDefinition {

    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private static JsonNode loginData;
    private static String username;
    private static String password;

    @Before
    public void setUp() {
        driver = DriverStrategy.initDriver();
        homePage = new HomePage();
        loginPage = new LoginPage();
        loginData = util.TestDataLoader.loadLoginData();
        if (loginData == null || loginData.get("validUser") == null) {
            throw new RuntimeException("Login data not found. Check your JSON file structure.");
        }
        username = loginData.get("validUser").get("username").asText();
        password = loginData.get("validUser").get("password").asText();
    }

    @Given("^I go to the website")
    public void i_go_to_the_website() {
        driver = DriverStrategy.getDriver();
        driver.get(FrameworkProperties.getBaseUrl());
    }

    @When("^I click on the Sign in button")
    public void i_click_on_the_sign_in_button() {
        homePage.acceptAllCookies()
                .clickLogin();
    }

    @And("^I specify my credentials")
    public void i_specify_my_credentials() {
        loginPage.enterUsername(username)
                 .enterPassword(password)
                 .clickSignIn();
    }

    @Then("^I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        homePage.isWelcomeHeadingDisplayed();
    }

    @After
    public void tearDown() {
        DriverStrategy.quitDriver();
    }
}
