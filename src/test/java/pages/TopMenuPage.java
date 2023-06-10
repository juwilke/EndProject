package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopMenuPage extends BasePage {
    public TopMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Contact us")
    WebElement contactUsLink;
    @FindBy(className = "login")
    WebElement loginLink;
    @FindBy(css = "#search_query_top.search_query.form-control.ac_input")
    WebElement searchInput;
    @FindBy(name = "submit_search")
    WebElement submitSearchButton;
    @FindBy(css = "ul.sf-menu > li:nth-child(2) > a")
    WebElement dressesButton;

    public void clickOnContactUsLink(){
        contactUsLink.click();
    }

    public void clickOnLoginLink(){
        loginLink.click();
    }

    public void clickOnSubmitSearchButton(){
        submitSearchButton.click();
    }
    public void setSearchInput(String text) {
        searchInput.sendKeys(text);
    }

    public void clickOnDressesButton(){
        dressesButton.click();
    }
}
