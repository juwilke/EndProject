package utils;

import com.github.javafaker.Faker;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriverWait wait;
    protected WebDriver driver;
    protected Faker faker;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        this.driver = driver;
        faker = new Faker();
    }
    public boolean isDisplayed(WebElement alertBox) {
        wait.until(ExpectedConditions.visibilityOf(alertBox));
        boolean isDisplayAlert = false;
        try {
            isDisplayAlert = alertBox.isDisplayed();
        } catch (NoSuchElementException exception) {}
        return isDisplayAlert;
    }
    public String isTextInAlertBox(WebElement box) {
        return box.getText();
    }
}
