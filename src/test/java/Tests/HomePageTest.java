package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.util.List;

public class HomePageTest extends BaseTests {

    private static WebElement element;
    protected static WebDriverWait wait;



    @Test
    public void shouldSeeBestSellersItem() {

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
