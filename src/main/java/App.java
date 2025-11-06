import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.Objects;

public class App {
   static WebDriver driver = new ChromeDriver();

    public static void main(String[] args) throws Exception {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.wikipedia.org/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Implicit wait for 10 seconds
        driver.manage().window().maximize();
//        System.out.println(driver.getTitle());
//
//
//        //Locators
//        //id
//        long start = System.currentTimeMillis();
//        driver.findElement(By.id("js-link-box-en"));
//        long end = System.currentTimeMillis();
//        System.out.println("Time taken by id: " + (end - start) + " ms");
//
//        //xpath
//        start = System.currentTimeMillis();
//        driver.findElement(By.xpath("//*[@id=\"js-link-box-es\"]"));
//        end = System.currentTimeMillis();
//        System.out.println("Time taken by xpath: " + (end - start) + " ms");
//        //cssSelector
//        start = System.currentTimeMillis();
//        driver.findElement(By.cssSelector("#js-link-box-zh"));
//        end = System.currentTimeMillis();
//        System.out.println("Time taken by cssSelector: " + (end - start) + " ms");
//
//
//        WebElement titleOfWebPage = driver.findElement(By.cssSelector("#www-wikipedia-org > main > div.central-textlogo > h1 > span"));
//        String title = titleOfWebPage.getText();
//        System.out.println(title);
//        String expectedTitle = "Wikipedia";
//        if (title.equals(expectedTitle)) {
//            System.out.println("Title is correct");
//        } else {
//            System.out.println("Title is incorrect");
//            driver.close();
//            throw new Exception();
//        }

        //Strong is not clickable in selenium, because it is not an interactive element
//        driver.findElement(By.id("js-link-box-en")).click();
//
//        String expectedTitle = "Welcome to Wikipedia";
//        WebElement titleOfWebPage = driver.findElement(By.id("Welcome_to_Wikipedia"));
//
//        if(titleOfWebPage.getText().equals(expectedTitle))
//            System.out.println("Title is correct");
//        else {
//            System.out.println("Title is incorrect");
//            driver.close();
//            throw new Exception();
//        }

        // sendKeys and submit
        WebElement searchInput =  driver.findElement(By.id("searchInput"));
        String searchText = "Selenium (software)";

        searchInput.sendKeys(searchText);

        WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit']"));
        searchButton.click();

        if(Objects.requireNonNull(driver.getTitle()).contains(searchText))
            System.out.println("Title is correct");
        else {
            System.out.println("Title is incorrect");
            driver.close();
        }

        //Table validation
     /*    WebElement headingInTable = getTable(8);
         String expected = headingInTable.getText();
         String actual = "Selenium Server";

         if(expected.contains(actual))
         {
                System.out.println("Heading is correct");
            }
            else {
                System.out.println("Heading is incorrect");
                driver.close();
         }

*/
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Implicit wait for 10 seconds

        Thread.sleep(1000); // not good => use implicit and explicit waits
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // explicit wait
        wait.until(ExpectedConditions.visibilityOf(getTable(8))); // wait until the element is visible for 10 seconds

        //Fluent wait => more customizable explicit wait
        Wait<WebDriver> FluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10)) // total time to wait
                .pollingEvery(Duration.ofSeconds(1)) // check every 1 second
                .ignoring(Exception.class); // ignore all exceptions

        FluentWait.until(driver -> driver.findElement(By.id("Element-Id")).isDisplayed());


        // Javascript e
        // executor => Engine inside selenium that can execute javascript code
        // Scrolling, clicking, getting values from DOM
        // Not recommended to use it, but sometimes it is necessary
        driver.get("https://www.amazon.in/");
        WebElement element = driver.findElement(By.xpath("//span[text()='See more']"));
        // scroll to the element
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();


        driver.close();
    }

    static WebElement getTable(int rowNumber)
    {
        return driver.findElement(By.xpath("//table//tr["+rowNumber+"]/td"));
    }
}
