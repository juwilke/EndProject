package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyAccountPage extends BasePage {

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "info-account")
    WebElement infoAccount;

    public boolean isInfoAccountDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(infoAccount));
        boolean isDisplayInfoAccount = false;
        try {
            isDisplayInfoAccount = infoAccount.isDisplayed();
        } catch (NoSuchElementException exception) {
        }
        return isDisplayInfoAccount;
    }
}
