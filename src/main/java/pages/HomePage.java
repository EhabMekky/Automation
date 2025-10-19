package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

    @FindBy(xpath = "//*[@id='menu-bluehost-website-builder']/li[2]/a")
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


    // Cookies Locators
    @FindBy(css = ".cky-consent-container.cky-box-bottom-left")
    private WebElement cookiesNotification;

    @FindBy(css = ".cky-btn.cky-btn-customize")
    private WebElement customizeCookiesButton;

    @FindBy(xpath = "//div[2]/button[3]")
    private WebElement rejectAllCookiesButton;

    @FindBy(xpath = "//div[2]//button[@aria-label='Accept All']")
    private WebElement acceptAllCookiesButton;


    // Constructor
    public HomePage() {
        PageFactory.initElements(DriverStrategy.getDriver(), this);
        wait = new WebDriverWait(DriverStrategy.getDriver(), Duration.ofSeconds(3));
    }

    // Navigation Actions
    public HomePage clickLogo() {
        logoLink.click();
        return this;
    }

    public HomePage clickCart() {
        cartLink.click();
        return this;
    }

    public HomePage clickShopNav() {

        //close the overlay
        wait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.className("xoo-el-main")
        ));

        wait.until(d -> shopNavLink.isDisplayed());

        shopNavLink.click();
        return this;
    }

    public HomePage clickBlogNav() {
        blogNavLink.click();
        return this;
    }

    public HomePage clickContactUsNav() {
        contactUsNavLink.click();
        return this;
    }

    public HomePage clickLogin() {
        loginNavItem.click();
        return this;
    }

    public HomePage clickRegister() {
        registerNavItem.click();
        return this;
    }

    // Section Actions
    public HomePage clickOurServicesButton() {
        ourServicesButton.click();
        return this;
    }

    public HomePage clickToShopButton() {
        toShopButton.click();
        return this;
    }

    public HomePage clickToBlogButton() {
        toBlogButton.click();
        return this;
    }

    // Portfolio Actions
    public HomePage clickHeadsnapProject() {
        headsnapLink.click();
        return this;
    }

    public HomePage clickClaimsDetectiveProject() {
        claimsDetectiveLink.click();
        return this;
    }

    public HomePage clickYouTubeChannelProject() {
        youtubeChannelLink.click();
        return this;
    }

    // Newsletter Subscription
    public HomePage enterEmail(String email) {
        emailInputField.clear();
        emailInputField.sendKeys(email);
        return this;
    }

    public HomePage clickSubscribe() {
        subscribeButton.click();
        return this;
    }

    public HomePage subscribeToNewsletter(String email) {
        enterEmail(email);
        clickSubscribe();
        return this;
    }

    // Social Media Actions
    public HomePage clickFacebook() {
        facebookLink.click();
        return this;
    }

    public HomePage clickTwitter() {
        twitterLink.click();
        return this;
    }

    public HomePage clickInstagram() {
        instagramLink.click();
        return this;
    }

    public HomePage clickYouTube() {
        youtubeLink.click();
        return this;
    }

    // Utility Methods
    public HomePage dismissCurrencyNotification() {
        if (dismissCurrencyNotification.isDisplayed()) {
            dismissCurrencyNotification.click();
        }
        return this;
    }

    public HomePage getPageTitle() {
        driver.getTitle();
        return this;
    }

    public HomePage getCurrentUrl() {
        driver.getCurrentUrl();
        return this;
    }

    // Verification Methods
    public HomePage isWelcomeHeadingDisplayed() {
        welcomeHeading.isDisplayed();
        return this;
    }

    public HomePage isExpertiseHeadingDisplayed() {
        expertiseHeading.isDisplayed();
        return this;
    }

    public HomePage isOnlineCoursesHeadingDisplayed() {
        onlineCoursesHeading.isDisplayed();
        return this;
    }

    public HomePage isPortfolioHeadingDisplayed() {
        portfolioHeading.isDisplayed();
        return this;
    }

    public HomePage isTestimonialsHeadingDisplayed() {
        testimonialsHeading.isDisplayed();
        return this;
    }

    public HomePage isSubscribeHeadingDisplayed() {
        subscribeHeading.isDisplayed();
        return this;
    }

    public HomePage getWelcomeHeadingText() {
        welcomeHeading.getText();
        return this;
    }

    //Cookies Acceptance

    public HomePage waitCookieWindowPresent() {
        wait.until(driver -> cookiesNotification.isDisplayed());
        return this;
    }

    public HomePage acceptAllCookies() {
        acceptAllCookiesButton.click();
        return this;
    }

}