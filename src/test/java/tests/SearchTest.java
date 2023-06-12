package tests;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ResultsPage;
import pages.TopMenuPage;

public class SearchTest extends BaseTests {

    private TopMenuPage topMenuPage;

    @BeforeClass
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);

        topMenuPage = new TopMenuPage(driver);
    }

    @Test(testName = "TC 4.1", priority = 1)
    public void shouldNotAllowSearchWithEmptyField() {
        ResultsPage resultsPage = topMenuPage.clickOnSubmitSearchButton();
        Assertions.assertThat(resultsPage.isAlertWaringDisplay()).isTrue();
    }

    @Test(testName = "TC 4.2", priority = 2)
    public void shouldSeeSearchResults() {
        topMenuPage.setSearchInput("blouse");
        ResultsPage resultsPage = topMenuPage.clickOnSubmitSearchButton();

        Assertions.assertThat(resultsPage.getNumberOfMatchingItems()).contains("Showing 1 - 1 of 1 item");
    }

}
