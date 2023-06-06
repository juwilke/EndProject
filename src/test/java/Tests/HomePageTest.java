package Tests;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.BestSellersPage;
import utils.PageTitlesUtils;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class HomePageTest extends BaseTests {

    private BestSellersPage bestSellersPage;
    @BeforeTest
    public void setupTest() {
        driver = new ChromeDriver();

    driver.get(BASE_URL);
    System.out.println(driver.getTitle());
    assertEquals(driver.getTitle(), PageTitlesUtils.HOME_PAGE_TITLE);

    bestSellersPage = new BestSellersPage(driver);
    }

    @Test
    public void shouldSeeBestSellersItem() {

        bestSellersPage.clickOnBestSellersButton();

        List<String> productNames = bestSellersPage.getProductNames();
        System.out.println(productNames);

        Assertions.assertThat(productNames).isNotEmpty();
    }
}
