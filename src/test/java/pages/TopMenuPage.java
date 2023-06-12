package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BasePage;

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

    public ContactUsFormPage clickOnContactUsLink(){
        contactUsLink.click();
        return new ContactUsFormPage(driver);
    }

    public LoginPage clickOnLoginLink(){
        loginLink.click();
        return new LoginPage(driver);
    }

    public ResultsPage clickOnSubmitSearchButton(){
        submitSearchButton.click();
        return new ResultsPage(driver);
    }
    public void setSearchInput(String text) {
        searchInput.sendKeys(text);
    }

    public ResultsPage clickOnDressesButton(){
        dressesButton.click();
        return new ResultsPage(driver);
    }
}
