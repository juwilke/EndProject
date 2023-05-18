import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class ContactUsPageTest {

    private static WebDriver driver;


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
    public void shouldNotAllowToSendEmptyForm() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  // globalny wait dla wszystkich elementów

        driver.get("http://automationpractice.pl/index.php");

        WebElement contactUsButton = driver.findElement(By.cssSelector("#contact-link"));
        contactUsButton.click();

        WebElement submitContactFormButton = driver.findElement(By.cssSelector("#submitMessage"));
        submitContactFormButton.click();

        WebElement alertMassage = driver.findElement(By.className("alert-danger"));
    }
}
