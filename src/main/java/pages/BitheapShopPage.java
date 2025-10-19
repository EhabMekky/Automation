package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import strategy.DriverStrategy;

/**
 * Page Object Model for Bitheap Shop Page
 * URL: https://bitheap.tech/shop/
 * Generated from DOM analysis after login
 */
public class BitheapShopPage {

    // Constructor
    public BitheapShopPage() {
        PageFactory.initElements(DriverStrategy.getDriver(), this);
    }

    // ========== SHOP PAGE ELEMENTS ==========

    @FindBy(name = "orderby")
    private WebElement selectShopOrder;

    @FindBy(name = "paged")
    private WebElement inputPagedField;

    @FindBy(className = "products")
    private WebElement productsContainer;

    // ========== PRODUCT ELEMENTS ==========

    // Product 1: Chatbot Development Ebook (On Sale)
    @FindBy(xpath = "//*[@id=\"main\"]/ul[1]/li[1]/a[1]")
    private WebElement productChatbotDevelopmentLink;

    @FindBy(xpath = "//*[@id=\"main\"]/ul[1]/li[1]/a[2]")
    private WebElement btnAddToCartChatbot;

    // Product 2: Code Gamers Development
    @FindBy(xpath = "//*[@id=\"main\"]/ul[1]/li[2]/a[1]")
    private WebElement productCodeGamersLink;

    @FindBy(xpath = "//*[@id=\"main\"]/ul[1]/li[2]/a[2]")
    private WebElement btnGetBookCodeGamers;

    // Product 3: Data Science from Scratch
    @FindBy(xpath = "//*[@id=\"main\"]/ul[1]/li[3]/a[1]")
    private WebElement productDataScienceLink;

    @FindBy(xpath = "//*[@id=\"main\"]/ul[1]/li[3]/a[2]")
    private WebElement btnBuyProductDataScience;

    // Product 4: Designing Data-Intensive Applications
    @FindBy(xpath = "//*[@id=\"main\"]/ul[1]/li[4]/a[1]")
    private WebElement productDesigningDataIntensiveLink;

    @FindBy(xpath = "//*[@id=\"main\"]/ul[1]/li[4]/a[2]")
    private WebElement btnBuyProductDesigningData;

    // Product 5: Designing Machine Learning Systems
    @FindBy(xpath = "//*[@id=\"main\"]/ul[1]/li[5]/a[1]")
    private WebElement productDesigningMLSystemsLink;

    @FindBy(xpath = "//*[@id=\"main\"]/ul[1]/li[5]/a[2]")
    private WebElement btnBuyProductMLSystems;

    // Product 6: Effective Java 3rd Edition
    @FindBy(xpath = "//*[@id=\"main\"]/ul[1]/li[6]/a[1]")
    private WebElement productEffectiveJavaLink;

    @FindBy(xpath = "//*[@id=\"main\"]/ul[1]/li[6]/a[2]")
    private WebElement btnBuyProductEffectiveJava;

    // Product 7: Fundamentals of Data Engineering
    @FindBy(xpath = "//*[@id=\"main\"]/ul[1]/li[7]/a[1]")
    private WebElement productFundamentalsDataEngLink;

    @FindBy(xpath = "//*[@id=\"main\"]/ul[1]/li[7]/a[2]")
    private WebElement btnBuyProductDataEng;

    // Product 8: Hacking System Design Interview
    @FindBy(xpath = "//*[@id=\"main\"]/ul[1]/li[8]/a[1]")
    private WebElement productHackingSystemDesignLink;

    @FindBy(xpath = "//*[@id=\"main\"]/ul[1]/li[8]/a[2]")
    private WebElement btnBuyProductSystemDesign;

    // Product 9: Hands-On Machine Learning
    @FindBy(xpath = "//*[@id=\"main\"]/ul[1]/li[9]/a[1]")
    private WebElement productHandsOnMLLink;

    @FindBy(xpath = "//*[@id=\"main\"]/ul[1]/li[9]/a[2]")
    private WebElement btnBuyProductHandsOnML;

    // Product 10: Hands-On Software Engineering with Golang
    @FindBy(xpath = "//*[@id=\"main\"]/ul[1]/li[10]/a[1]")
    private WebElement productHandsOnGolangLink;

    @FindBy(xpath = "//*[@id=\"main\"]/ul[1]/li[10]/a[2]")
    private WebElement btnGetBookGolang;

    // Product 11: Introduction to Python (On Sale)
    @FindBy(xpath = "//*[@id=\"main\"]/ul[1]/li[11]/a[1]")
    private WebElement productIntroPythonLink;

    @FindBy(xpath = "//*[@id=\"main\"]/ul[1]/li[11]/a[2]")
    private WebElement btnAddToCartPython;

    // Product 12: Machine Learning Design Patterns
    @FindBy(xpath = "//*[@id=\"main\"]/ul[1]/li[12]/a[1]")
    private WebElement productMLDesignPatternsLink;

    @FindBy(xpath = "//*[@id=\"main\"]/ul[1]/li[12]/a[2]")
    private WebElement btnBuyProductMLPatterns;

    // Product 13: Machine Learning with PyTorch
    @FindBy(xpath = "//*[@id=\"main\"]/ul[1]/li[13]/a[1]")
    private WebElement productMLPyTorchLink;

    @FindBy(xpath = "//*[@id=\"main\"]/ul[1]/li[13]/a[2]")
    private WebElement btnBuyProductPyTorch;

    // Product 14: Mathematics for Machine Learning
    @FindBy(xpath = "//*[@id=\"main\"]/ul[1]/li[14]/a[1]")
    private WebElement productMathematicsMLLink;

    @FindBy(xpath = "//*[@id=\"main\"]/ul[1]/li[14]/a[2]")
    private WebElement btnBuyProductMathML;

    // Product 15: Natural Language Processing with Transformers
    @FindBy(xpath = "//*[@id=\"main\"]/ul[1]/li[15]/a[1]")
    private WebElement productNLPTransformersLink;

    @FindBy(xpath = "//*[@id=\"main\"]/ul[1]/li[15]/a[2]")
    private WebElement btnBuyProductNLP;

    // Product 16: Programming Rust
    @FindBy(xpath = "//*[@id=\"main\"]/ul[1]/li[16]/a[1]")
    private WebElement productProgrammingRustLink;

    @FindBy(xpath = "//*[@id=\"main\"]/ul[1]/li[16]/a[2]")
    private WebElement btnBuyProductRust;

    // ========== PAGINATION ELEMENTS ==========

    @FindBy(xpath = "//*[@id=\"main\"]/nav[1]/ul[1]/li[2]/a[1]")
    private WebElement linkPage2;

    @FindBy(xpath = "//*[@id=\"main\"]/nav[1]/ul[1]/li[3]/a[1]")
    private WebElement linkPage3;

    @FindBy(xpath = "//*[@id=\"main\"]/nav[1]/ul[1]/li[4]/a[1]")
    private WebElement linkPage4;

    @FindBy(className = "next")
    private WebElement linkNextPage;

    @FindBy(className = "page-numbers")
    private WebElement paginationContainer;

    // ========== DYNAMIC LOCATORS (By methods) ==========

    /**
     * Get product link by index (1-16)
     */
    public WebElement getProductLink(int index) {
        return productsContainer.findElements(By.tagName("li")).get(index - 1).findElement(By.tagName("a"));
    }

    /**
     * Get product buy/add button by index (1-16)
     */
    public WebElement getProductButton(int index) {
        return productsContainer.findElements(By.tagName("li")).get(index - 1).findElements(By.tagName("a")).get(1);
    }

    /**
     * Get pagination link by page number
     */
    public WebElement getPaginationLink(int pageNumber) {
        return paginationContainer.findElement(By.linkText(String.valueOf(pageNumber)));
    }

    // ========== PAGE ACTIONS ==========

    public BitheapShopPage addChatbotEbookToCart() {
        btnAddToCartChatbot.click();
        return this;
    }

    public BitheapShopPage addPythonEbookToCart() {
        btnAddToCartPython.click();
        return this;
    }

    public BitheapShopPage selectSortOrder(String orderType) {
        selectShopOrder.sendKeys(orderType);
        return this;
    }

    public BitheapShopPage goToPage(int pageNumber) {
        getPaginationLink(pageNumber).click();
        return this;
    }

    public BitheapShopPage goToNextPage() {
        linkNextPage.click();
        return this;
    }

    public BitheapShopPage clickProduct(int index) {
        getProductLink(index).click();
        return this;
    }

    public BitheapShopPage addProductToCart(int index) {
        getProductButton(index).click();
        return this;
    }

    // ========== VERIFICATION METHODS ==========

    public boolean isProductDisplayed(int index) {
        try {
            return getProductLink(index).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public int getTotalProducts() {
        return productsContainer.findElements(By.tagName("li")).size();
    }
}