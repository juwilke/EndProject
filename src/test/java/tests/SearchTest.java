package tests;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ResultsPage;
import pages.TopMenuPage;

public class SearchTest extends BaseTests {

    private TopMenuPage topMenuPage;
    private ResultsPage resultsPage;

    @BeforeClass
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);

        topMenuPage = new TopMenuPage(driver);
        resultsPage = new ResultsPage(driver);
    }

    @Test(testName = "TC 4.1", priority = 1)
    public void shouldNotAllowSearchWithEmptyField(){
        topMenuPage.clickOnSubmitSearchButton();
        Assertions.assertThat(resultsPage.isAlertWaringDisplay()).isTrue();
    }
    @Test(testName = "TC 4.2", priority = 2)
    public void shouldSeeSearchResults(){
        topMenuPage.setSearchInput("blouse");
        topMenuPage.clickOnSubmitSearchButton();
        System.out.println(resultsPage.getFoundProductsInfo());
        Assertions.assertThat(resultsPage.getNumberOfMatchingItems()).contains("Showing 1 - 1 of 1 item");
    }

}
