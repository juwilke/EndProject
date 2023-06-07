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

    public boolean isInfoAccountDisplayed() {
        return super.isDisplayed(infoAccount);
    }
}
