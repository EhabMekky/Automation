package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import strategy.DriverStrategy;

public class CartPage {

    //Constructor
    public CartPage() {
        PageFactory.initElements(DriverStrategy.getDriver(), this);
    }

    //Locators
    @FindBy(css = "body > nav > div.wb4wp-wrapper > div.wb4wp-right > div > a")
    private WebElement cartIcon;

    @FindBy(xpath = "//div[1]/div[3]/div/a/span")
    private WebElement cartCount;

    @FindBy(className = "checkout-button")
    private WebElement proceedToCheckoutButton;

    public CartPage clickCartIcon() {
        cartIcon.click();
        return this;
    }

    public CartPage clickProceedToCheckout() {
        proceedToCheckoutButton.click();
        return this;
    }

    public int getCartItemCount() {
        String countText = cartCount.getText().trim();

        if (countText.isEmpty()) {
            return 0;
        }

        String numericValue = countText.replaceAll("[^0-9]", "");
        return numericValue.isEmpty() ? 0 : Integer.parseInt(numericValue);
    }

    public CartPage assertCartCountIncreased(int previousCount) {
        int currentCount = getCartItemCount();
        Assert.assertTrue(currentCount > previousCount,
                "Cart count did not increase. Expected: >" + previousCount + ", Actual: " + currentCount);
        return this;
    }

    public CartPage assertCartCount(int expectedCount) {
        int actualCount = getCartItemCount();
        Assert.assertEquals(actualCount, expectedCount,
                "Cart count mismatch");
        return this;
    }
}