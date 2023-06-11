package tests;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ResultsPage;
import pages.TopMenuPage;

import java.util.Collections;
import java.util.List;

public class SortingResultsTest extends BaseTests{
    private TopMenuPage topMenuPage;
    private ResultsPage resultsPage;

    @BeforeClass
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);

        topMenuPage = new TopMenuPage(driver);
        resultsPage = new ResultsPage(driver);
    }

    @Test(testName = "5.1", priority = 1)
    public void canSortItemsByPriceLowestFirst(){
        topMenuPage.clickOnDressesButton();

        List<Float> pricesBefore = resultsPage.getPrices();
        Collections.sort(pricesBefore);

        resultsPage.selectSortBy("price:asc");

        List<Float> pricesAfter = resultsPage.getPrices();

        Assertions.assertThat(pricesBefore).isEqualTo(pricesAfter);
    }
    @Test(testName = "5.2", priority = 2)
    public void canSortItemsByPriceHighestFirst(){
        topMenuPage.clickOnDressesButton();

        List<Float> pricesBefore = resultsPage.getPrices();
        Collections.sort(pricesBefore);
        Collections.reverse(pricesBefore);

        resultsPage.selectSortBy("price:desc");

        List<Float> pricesAfter = resultsPage.getPrices();

        Assertions.assertThat(pricesBefore).isEqualTo(pricesAfter);
    }
}
