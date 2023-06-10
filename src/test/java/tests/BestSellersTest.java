package tests;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BestSellersPage;
import utils.PageTitlesUtils;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class BestSellersTest extends BaseTests {

    private BestSellersPage bestSellersPage;

    @BeforeClass
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
