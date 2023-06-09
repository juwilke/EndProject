package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {


    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "info-account")
    WebElement infoAccount;
    @FindBy(className = "logout")
    WebElement logout;

    public boolean isInfoAccountDisplayed() {
        return super.isDisplayed(infoAccount);
    }

    public void clickOnLogout() {
        logout.click();
    }
}
