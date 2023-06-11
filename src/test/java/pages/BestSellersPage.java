package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BasePage;

import java.util.List;
import java.util.stream.Collectors;

public class BestSellersPage extends BasePage {

    public BestSellersPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".blockbestsellers")
    WebElement bestSellersButton;

    @FindBy(css = ".blockbestsellers .product-name")
    List<WebElement> productNames;

    public List<String> getProductNames() {
        return productNames.stream()
                .map(el -> el.getText().trim())
                .collect(Collectors.toList());
    }

    public void clickOnBestSellersButton() {
        bestSellersButton.click();
    }
}