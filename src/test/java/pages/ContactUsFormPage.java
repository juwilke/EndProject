package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BasePage;

public class ContactUsFormPage extends BasePage {

    public ContactUsFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "submitMessage")
    WebElement submitContactFormButton;
    @FindBy(className = "alert-danger")
    WebElement alertMessage;
    @FindBy(id = "email")
    WebElement emailInput;
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
        return super.isDisplayed(alertMessage);
    }
    public void setEmailInput(String email){
        emailInput.sendKeys(email);
    }
    public void setMessageInput(String message){
        messageInput.sendKeys(message);
    }
    public void setSubjectChoose(String subject){
        subjectChoose.sendKeys(subject);
    }
    public String redBoxText() {
        return isTextInAlertBox(alertMessage);
    }
    public String greenBoxText() {
        return isTextInAlertBox(alertSuccess);
    }
    public boolean isAlertSuccessDisplayed(){
        return super.isDisplayed(alertSuccess);
    }



}