package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopMenuPage {
    public TopMenuPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Contact us")
    WebElement contactUsLink;

    @FindBy(className = "login")
    WebElement loginLink;

    public void clickOnContactUsLink(){
        contactUsLink.click();
    }

    public void clickOnLoginLink(){
        loginLink.click();
    }
}
