package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import strategy.DriverStrategy;

public class CartPage {

    //Constructor
    public CartPage()
    {
        PageFactory.initElements(DriverStrategy.getDriver(), this);
    }

    //Locators
    @FindBy(css= "body > nav > div.wb4wp-wrapper > div.wb4wp-right > div > a")
    private WebElement cartIcon;

    @FindBy(xpath= "//div[1]/div[3]/div/a/span")
    private WebElement cartCount; // You may need to adjust this to target the count element specifically

    public CartPage clickCartIcon()
    {
        cartIcon.click();
        return this;
    }

    /**
     * Gets the current cart item count from the cart icon
     * @return the number of items in the cart
     */
    public int getCartItemCount()
    {
        String countText = cartCount.getText().trim();

        // Handle empty cart (no number displayed)
        if (countText.isEmpty()) {
            return 0;
        }

        // Extract numeric value (handles formats like "3", "(3)", etc.)
        String numericValue = countText.replaceAll("[^0-9]", "");
        return numericValue.isEmpty() ? 0 : Integer.parseInt(numericValue);
    }

    /**
     * Validates that the cart count has increased
     * @param previousCount the cart count before adding item
     * @return true if count increased, false otherwise
     */
    public boolean isCartCountIncreased(int previousCount)
    {
        int currentCount = getCartItemCount();
        System.out.println(currentCount);
        return currentCount > previousCount;
    }
}