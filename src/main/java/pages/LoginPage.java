package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import strategy.DriverStrategy;

import java.time.Duration;


public class LoginPage {

    private WebDriverWait wait;

    // Login Modal Container
    @FindBy(xpath = "//div[contains(@class, 'woocommerce-account')]")
    private WebElement loginModal;

    // Tab Navigation
    @FindBy(xpath = "//li[text()='Sign Up']")
    private WebElement signUpTab;

    // Login Form Fields
    @FindBy(xpath = "//input[@placeholder='Username / Email' or contains(@name, 'username')]")
    private WebElement usernameEmailField;

    @FindBy(xpath = "//input[@placeholder='Password' or @type='password']")
    private WebElement passwordField;

    // Password Visibility Toggle
    @FindBy(xpath = "//div[contains(@class, 'password')]//div[contains(@class, 'toggle') or @role='button']")
    private WebElement passwordVisibilityToggle;

    // Remember Me Checkbox
    @FindBy(xpath = "//span[contains(text(),'Remember')]")
    private WebElement rememberMeCheckbox;

    @FindBy(xpath = "//label[contains(., 'Remember me')]")
    private WebElement rememberMeLabel;

    // Forgot Password Link
    @FindBy(xpath = "//a[contains(text(), 'Forgot Password')]")
    private WebElement forgotPasswordLink;

    // Sign In Button
    @FindBy(xpath = "//button[text()='Sign in']")
    private WebElement signInButton;

    // Close Modal Button (X button)
    @FindBy(xpath = "//div[contains(@class, 'modal')]//button[contains(@class, 'close')] | //div[@role='button' and contains(@class, 'close')]")
    private WebElement closeModalButton;

    // Error Messages
    @FindBy(xpath = "//div[contains(@class, 'error')] | //span[contains(@class, 'error')] | //*[contains(@class, 'woocommerce-error')]")
    private WebElement errorMessage;

    // Constructor
    public LoginPage() {
        PageFactory.initElements(DriverStrategy.getDriver(), this);
        this.wait = new WebDriverWait(DriverStrategy.getDriver(), Duration.ofSeconds(3));
    }

    // Wait for login modal to be visible
    public LoginPage waitForLoginModalToAppear() {
        wait.until(ExpectedConditions.visibilityOf(usernameEmailField));
        return this;
    }

    public LoginPage clickSignUpTab() {
        signUpTab.click();
        return this;
    }

    // Form Field Actions
    public LoginPage enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameEmailField));
        usernameEmailField.clear();
        usernameEmailField.sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage togglePasswordVisibility() {
        passwordVisibilityToggle.click();
        return this;
    }

    public LoginPage checkRememberMe() {
        if (!rememberMeCheckbox.isSelected()) {
            rememberMeCheckbox.click();
        }
        return this;
    }

    public LoginPage uncheckRememberMe() {
        if (rememberMeCheckbox.isSelected()) {
            rememberMeCheckbox.click();
        }
        return this;
    }

    public LoginPage clickRememberMeLabel() {
        rememberMeLabel.click();
        return this;
    }

    // Navigation Actions
    public LoginPage clickForgotPassword() {
        forgotPasswordLink.click();
        return this;
    }

    public LoginPage clickSignIn() {
        signInButton.click();
        return this;
    }

    public LoginPage closeModal() {
        closeModalButton.click();
        return this;
    }

    // Combined Login Action
    public LoginPage login(String username, String password) {
        waitForLoginModalToAppear();
        enterUsername(username);
        enterPassword(password);
        clickSignIn();
        return this;
    }

    public LoginPage loginWithRememberMe(String username, String password) {
        waitForLoginModalToAppear();
        enterUsername(username);
        enterPassword(password);
        checkRememberMe();
        clickSignIn();
        return this;
    }

    // Verification Methods
    public LoginPage isLoginModalDisplayed() {
        try {
            usernameEmailField.isDisplayed();
            passwordField.isDisplayed();
        } catch (Exception e) {
            // Exception handled
        }
        return this;
    }

    public LoginPage isUsernameFieldDisplayed() {
        usernameEmailField.isDisplayed();
        return this;
    }

    public LoginPage isPasswordFieldDisplayed() {
        passwordField.isDisplayed();
        return this;
    }

    public LoginPage isSignInButtonDisplayed() {
        signInButton.isDisplayed();
        return this;
    }

    public LoginPage isRememberMeCheckboxSelected() {
        rememberMeCheckbox.isSelected();
        return this;
    }

    public LoginPage isForgotPasswordLinkDisplayed() {
        forgotPasswordLink.isDisplayed();
        return this;
    }

    public LoginPage isErrorMessageDisplayed() {
        try {
            errorMessage.isDisplayed();
        } catch (Exception e) {
            // Exception handled
        }
        return this;
    }

    public LoginPage getErrorMessageText() {
        if (errorMessage.isDisplayed()) {
            errorMessage.getText();
        }
        return this;
    }


    public LoginPage isSignUpTabVisible() {
        signUpTab.isDisplayed();
        return this;
    }

    // Clear Form
    public LoginPage clearLoginForm() {
        usernameEmailField.clear();
        passwordField.clear();
        if (rememberMeCheckbox.isSelected()) {
            uncheckRememberMe();
        }
        return this;
    }

    // Get Field Values
    public LoginPage getUsernameFieldValue() {
        usernameEmailField.getAttribute("value");
        return this;
    }

    public LoginPage getPasswordFieldValue() {
        passwordField.getAttribute("value");
        return this;
    }

    public LoginPage getUsernameFieldPlaceholder() {
        usernameEmailField.getAttribute("placeholder");
        return this;
    }

    public LoginPage getPasswordFieldPlaceholder() {
        passwordField.getAttribute("placeholder");
        return this;
    }
}