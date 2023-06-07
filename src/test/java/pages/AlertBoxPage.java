package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlertBoxPage extends BasePage{
    public AlertBoxPage(WebDriver driver){
        super(driver);
    }
    public boolean isDisplayed(WebElement alertBox) {
        wait.until(ExpectedConditions.visibilityOf(alertBox));
        boolean isDisplayAlert = false;
        try {
            isDisplayAlert = alertBox.isDisplayed();
        } catch (NoSuchElementException exception) {}
        return isDisplayAlert;
    }
}
