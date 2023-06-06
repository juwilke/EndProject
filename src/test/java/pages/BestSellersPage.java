package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class BestSellersPage {


    public BestSellersPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
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