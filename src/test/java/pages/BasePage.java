package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriverWait wait;
    protected WebDriver webDriver;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriver = driver;
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
