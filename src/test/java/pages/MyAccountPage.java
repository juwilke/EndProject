package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
    private final AlertBoxPage alertBoxPage;

    public MyAccountPage(WebDriver driver) {
        super(driver);
        alertBoxPage = new AlertBoxPage(driver);
    }

    @FindBy(className = "info-account")
    WebElement infoAccount;

    public boolean isInfoAccountDisplayed() {
        return alertBoxPage.isDisplayed(infoAccount);
    }
}
