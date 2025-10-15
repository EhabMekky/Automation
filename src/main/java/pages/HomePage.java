package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import strategy.DriverStrategy;

import java.time.Duration;

/**
 * Page Object Model for bitheap.tech Home Page
 */
public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Header Navigation Elements
    @FindBy(xpath = "//a[contains(@href, 'bitheap.tech') and .//img[@alt='bitheap']]")
    private WebElement logoLink;

    @FindBy(xpath = "//a[contains(@href, '/cart/')]")
    private WebElement cartLink;

    @FindBy(xpath = "//a[text()='Home' and contains(@href, 'bitheap.tech')]")
    private WebElement homeNavLink;

    @FindBy(xpath = "//a[text()='Shop']")
    private WebElement shopNavLink;

    @FindBy(xpath = "//a[text()='Blog']")
    private WebElement blogNavLink;

    @FindBy(xpath = "//a[text()='Contact us']")
    private WebElement contactUsNavLink;

    @FindBy(xpath = "//li[@id='menu-item-2330']")
    private WebElement loginNavItem;

    @FindBy(xpath = "//li[.//text()='Register']")
    private WebElement registerNavItem;

    // Hero Section
    @FindBy(xpath = "//h2[text()='Welcome to bitheap']")
    private WebElement welcomeHeading;

    @FindBy(xpath = "//a[contains(@href, 'services')]")
    private WebElement ourServicesButton;

    // Our Expertise Section
    @FindBy(xpath = "//h2[text()='Our expertise']")
    private WebElement expertiseHeading;

    // Online Courses Shop Section
    @FindBy(xpath = "//h2[text()='Online courses shop']")
    private WebElement onlineCoursesHeading;

    @FindBy(xpath = "//a[contains(@href, '/shop/') and .//text()='To Shop']")
    private WebElement toShopButton;

    // Blog Section
    @FindBy(xpath = "//h2[text()='Sharing our knowledge']")
    private WebElement sharingKnowledgeHeading;

    @FindBy(xpath = "//a[contains(@href, 'blog') and .//text()='To Blog']")
    private WebElement toBlogButton;

    // Portfolio Section
    @FindBy(xpath = "//h2[text()='Portfolio']")
    private WebElement portfolioHeading;

    @FindBy(xpath = "//h3[text()='HeadSnap.io']")
    private WebElement headsnapProject;

    @FindBy(xpath = "//a[contains(@href, 'headsnap.io')]")
    private WebElement headsnapLink;

    @FindBy(xpath = "//h3[text()='Claims Detective']")
    private WebElement claimsDetectiveProject;

    @FindBy(xpath = "//a[contains(@href, 'claims-detective.com')]")
    private WebElement claimsDetectiveLink;

    @FindBy(xpath = "//h3[text()='YouTube Channel']")
    private WebElement youtubeChannelProject;

    @FindBy(xpath = "//a[contains(@href, 'youtube.com/@bitheap-tech')]")
    private WebElement youtubeChannelLink;

    // Testimonials Section
    @FindBy(xpath = "//h2[text()='Testimonials']")
    private WebElement testimonialsHeading;

    @FindBy(xpath = "//p[text()='Jonas Eugster']")
    private WebElement jonasTestimonial;

    @FindBy(xpath = "//p[text()='Alex Wilmot']")
    private WebElement alexTestimonial;

    // Newsletter Subscription
    @FindBy(xpath = "//h2[text()='Subscribe']")
    private WebElement subscribeHeading;

    @FindBy(xpath = "//input[contains(@placeholder, 'e-mail')]")
    private WebElement emailInputField;

    @FindBy(xpath = "//button[.//text()='Subscribe']")
    private WebElement subscribeButton;

    // Footer Elements
    @FindBy(xpath = "//footer//a[text()='Home']")
    private WebElement footerHomeLink;

    @FindBy(xpath = "//footer//a[text()='Shop']")
    private WebElement footerShopLink;

    @FindBy(xpath = "//footer//a[text()='Blog']")
    private WebElement footerBlogLink;

    @FindBy(xpath = "//footer//a[text()='Contact us']")
    private WebElement footerContactLink;

    @FindBy(xpath = "//a[contains(@href, 'sitemap.xml')]")
    private WebElement sitemapLink;

    @FindBy(xpath = "//a[contains(@href, 'facebook.com/bitheap.tech')]")
    private WebElement facebookLink;

    @FindBy(xpath = "//a[contains(@href, 'twitter.com/Bitheap_tech')]")
    private WebElement twitterLink;

    @FindBy(xpath = "//a[contains(@href, 'instagram.com/bitheap.tech')]")
    private WebElement instagramLink;

    @FindBy(xpath = "//a[contains(@href, 'youtube.com/channel')]")
    private WebElement youtubeLink;

    // Currency Notification
    @FindBy(xpath = "//a[text()='Dismiss']")
    private WebElement dismissCurrencyNotification;

    // Constructor
    public HomePage() {
        PageFactory.initElements(DriverStrategy.getDriver(), this);
    }

    // Navigation Actions
    public void clickLogo() {
        logoLink.click();
    }

    public void clickCart() {
        cartLink.click();
    }

    public void clickShopNav() {
        shopNavLink.click();
    }

    public void clickBlogNav() {
        blogNavLink.click();
    }

    public void clickContactUsNav() {
        contactUsNavLink.click();
    }

    public void clickLogin() {
        loginNavItem.click();
    }

    public void clickRegister() {
        registerNavItem.click();
    }

    // Section Actions
    public void clickOurServicesButton() {
        ourServicesButton.click();
    }

    public void clickToShopButton() {
        toShopButton.click();
    }

    public void clickToBlogButton() {
        toBlogButton.click();
    }

    // Portfolio Actions
    public void clickHeadsnapProject() {
        headsnapLink.click();
    }

    public void clickClaimsDetectiveProject() {
        claimsDetectiveLink.click();
    }

    public void clickYouTubeChannelProject() {
        youtubeChannelLink.click();
    }

    // Newsletter Subscription
    public void enterEmail(String email) {
        emailInputField.clear();
        emailInputField.sendKeys(email);
    }

    public void clickSubscribe() {
        subscribeButton.click();
    }

    public void subscribeToNewsletter(String email) {
        enterEmail(email);
        clickSubscribe();
    }

    // Social Media Actions
    public void clickFacebook() {
        facebookLink.click();
    }

    public void clickTwitter() {
        twitterLink.click();
    }

    public void clickInstagram() {
        instagramLink.click();
    }

    public void clickYouTube() {
        youtubeLink.click();
    }

    // Utility Methods
    public void dismissCurrencyNotification() {
        if (dismissCurrencyNotification.isDisplayed()) {
            dismissCurrencyNotification.click();
        }
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    // Verification Methods
    public boolean isWelcomeHeadingDisplayed() {
        return welcomeHeading.isDisplayed();
    }

    public boolean isExpertiseHeadingDisplayed() {
        return expertiseHeading.isDisplayed();
    }

    public boolean isOnlineCoursesHeadingDisplayed() {
        return onlineCoursesHeading.isDisplayed();
    }

    public boolean isPortfolioHeadingDisplayed() {
        return portfolioHeading.isDisplayed();
    }

    public boolean isTestimonialsHeadingDisplayed() {
        return testimonialsHeading.isDisplayed();
    }

    public boolean isSubscribeHeadingDisplayed() {
        return subscribeHeading.isDisplayed();
    }

    public String getWelcomeHeadingText() {
        return welcomeHeading.getText();
    }
}