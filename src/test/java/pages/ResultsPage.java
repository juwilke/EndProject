package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultsPage extends BasePage {
    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "product-count")
    WebElement numberOfMatchingItems;
    @FindBy(className = "product-container")
    List<WebElement> foundProducts;
    @FindBy(id = "center_column")
    WebElement alertWarning;

    public String getNumberOfMatchingItems() {
        wait.until(ExpectedConditions.visibilityOf(numberOfMatchingItems));
        return numberOfMatchingItems.getText();
    }
    public boolean isAlertWaringDisplay(){
        return super.isDisplayed(alertWarning);
    }

    public List<Map<String, String>> getFoundProductsInfo() {
        return foundProducts.stream()
                .map(el -> {
                    Map<String, String> productInfoMap = new HashMap<>();

                    productInfoMap.put("name", el.findElement(By.className("product-name")).getText().trim());
                    productInfoMap.put("price", el.findElement(By.cssSelector(".right-block .price.product-price"))
                            .getText()
                            .replaceAll("[^0-9.]", "")
                    );

                    return productInfoMap;
                })
                .collect(Collectors.toList());
    }
}
