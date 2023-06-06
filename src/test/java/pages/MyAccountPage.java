package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyAccountPage {
    private final WebDriverWait wait;

    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
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
