import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest {

    private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
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
    public void shouldSeeBestSellersItems() {
        driver.get("http://automationpractice.pl/index.php");
        driver.findElement(By.cssSelector("#.blockbestsellers")).click();

//        List<WebElement> bestSellersItems = driver.findElements(By.cssSelector("#blockbestsellers .product-name"));
//        List<WebElement> bestSellersItemsByXpath = driver.findElements((By.xpath("//*[@id=\"blockbestsellers\"]//*[@class=\"product-name\"]")));
//
//        for (WebElement bestSellersItem : bestSellersItems) {
//            System.out.println(bestSellersItem.getText());
//        }

    }
}
