package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import utils.PageTitlesUtils;

import static org.testng.AssertJUnit.assertEquals;

public class BaseTests {

    protected static final String BASE_URL = "http://automationpractice.pl/index.php";
    protected static WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeTest
    public void setupTest() {
        driver = new ChromeDriver();

        driver.get(BASE_URL);
        System.out.println(driver.getTitle());
        assertEquals(driver.getTitle(), PageTitlesUtils.HOME_PAGE_TITLE);
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
