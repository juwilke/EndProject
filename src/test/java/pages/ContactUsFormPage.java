package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactUsFormPage {
    private final WebDriverWait wait;
    public ContactUsFormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @FindBy(id = "submitMessage")
    WebElement submitContactFormButton;
    @FindBy(className = "alert-danger")
    WebElement alertMessage;
    @FindBy(id = "email")
    WebElement emailInput;
    @FindBy(id = "id_order")
    WebElement idOrderInput;
    @FindBy(id = "message")
    WebElement messageInput;
    @FindBy(id = "id_contact")
    WebElement subjectChoose;
    @FindBy(className = "alert-success")
    WebElement alertSuccess;

    public void clickOnSubmitContactFormButton(){
        submitContactFormButton.click();
    }
    public boolean isAlertMessageDisplay(){
        wait.until(ExpectedConditions.visibilityOf(alertMessage));
        boolean isDisplay = false;
        try {
           isDisplay = alertMessage.isDisplayed();
        } catch (NoSuchElementException exception) {}
        return isDisplay;
    }

    public void setEmailInput(String email){
        emailInput.sendKeys(email);
    }

    public void setIdOrderInput(String order){
        idOrderInput.sendKeys(order);
    }

    public void setMessageInput(String message){
        messageInput.sendKeys(message);
    }

    public void setSubjectChoose(String subject){
        subjectChoose.sendKeys(subject);
    }

    public boolean isAlertSuccessDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(alertSuccess));
        boolean isDisplaySuccess = false;
        try {
            isDisplaySuccess = alertSuccess.isDisplayed();
        } catch (NoSuchElementException exception) {}
        return isDisplaySuccess;
    }



}