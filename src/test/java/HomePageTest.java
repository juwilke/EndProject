import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.time.Duration;
import java.util.List;

public class HomePageTest {

    private static WebDriver driver;
    private static WebElement element;
    protected static WebDriverWait wait;
    protected static Faker faker;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        faker = new Faker();
    }

    @BeforeTest
    public void setupTest() {
        driver = new ChromeDriver();
    }

    @AfterTest
    public void teardwon() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void shouldReturnCorrectPageTitle() {
        driver.get("http://automationpractice.pl/index.php");
        System.out.println(driver.getTitle());
        AssertJUnit.assertEquals(driver.getTitle(), "My Store");
    }

    @Test
    public void shouldSeeBestSellersItem() {
        driver.get("http://automationpractice.pl/index.php");
        WebElement bestSellerButton = driver.findElement(By.cssSelector(".blockbestsellers"));
        bestSellerButton.click();
        List<WebElement> productNames = driver.findElements(By.cssSelector(".blockbestsellers .product-name"));

        for (WebElement productName : productNames) {
            System.out.println(productName.getText());
        }

        boolean isAnyProductHasNameEmpty = productNames.stream().anyMatch(el -> el.getText().isEmpty());
        AssertJUnit.assertFalse(isAnyProductHasNameEmpty);
    }
}
