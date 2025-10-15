package pages;
import org.openqa.selenium.WebDriver;
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
    @FindBy(xpath = "//input[@type='checkbox' and contains(@id, 'remember')]")
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
    public void waitForLoginModalToAppear() {
        wait.until(ExpectedConditions.visibilityOf(usernameEmailField));
    }

    public void clickSignUpTab() {
        signUpTab.click();
    }

    // Form Field Actions
    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameEmailField));
        usernameEmailField.clear();
        usernameEmailField.sendKeys(username);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void togglePasswordVisibility() {
        passwordVisibilityToggle.click();
    }

    public void checkRememberMe() {
        if (!rememberMeCheckbox.isSelected()) {
            rememberMeCheckbox.click();
        }
    }

    public void uncheckRememberMe() {
        if (rememberMeCheckbox.isSelected()) {
            rememberMeCheckbox.click();
        }
    }

    public void clickRememberMeLabel() {
        rememberMeLabel.click();
    }

    // Navigation Actions
    public void clickForgotPassword() {
        forgotPasswordLink.click();
    }

    public void clickSignIn() {
        signInButton.click();
    }

    public void closeModal() {
        closeModalButton.click();
    }

    // Combined Login Action
    public void login(String username, String password) {
        waitForLoginModalToAppear();
        enterUsername(username);
        enterPassword(password);
        clickSignIn();
    }

    public void loginWithRememberMe(String username, String password) {
        waitForLoginModalToAppear();
        enterUsername(username);
        enterPassword(password);
        checkRememberMe();
        clickSignIn();
    }

    // Verification Methods
    public boolean isLoginModalDisplayed() {
        try {
            return usernameEmailField.isDisplayed() && passwordField.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isUsernameFieldDisplayed() {
        return usernameEmailField.isDisplayed();
    }

    public boolean isPasswordFieldDisplayed() {
        return passwordField.isDisplayed();
    }

    public boolean isSignInButtonDisplayed() {
        return signInButton.isDisplayed();
    }

    public boolean isRememberMeCheckboxSelected() {
        return rememberMeCheckbox.isSelected();
    }

    public boolean isForgotPasswordLinkDisplayed() {
        return forgotPasswordLink.isDisplayed();
    }

    public boolean isErrorMessageDisplayed() {
        try {
            return errorMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getErrorMessageText() {
        if (isErrorMessageDisplayed()) {
            return errorMessage.getText();
        }
        return "";
    }


    public boolean isSignUpTabVisible() {
        return signUpTab.isDisplayed();
    }

    // Clear Form
    public void clearLoginForm() {
        usernameEmailField.clear();
        passwordField.clear();
        if (rememberMeCheckbox.isSelected()) {
            uncheckRememberMe();
        }
    }

    // Get Field Values
    public String getUsernameFieldValue() {
        return usernameEmailField.getAttribute("value");
    }

    public String getPasswordFieldValue() {
        return passwordField.getAttribute("value");
    }

    public String getUsernameFieldPlaceholder() {
        return usernameEmailField.getAttribute("placeholder");
    }

    public String getPasswordFieldPlaceholder() {
        return passwordField.getAttribute("placeholder");
    }
}