package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsFormPage extends BasePage{

    private final AlertBoxPage alertBoxPage;

    public ContactUsFormPage(WebDriver driver) {
        super(driver);
        alertBoxPage = new AlertBoxPage(driver);
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
        return alertBoxPage.isDisplayed(alertMessage);
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
        return alertBoxPage.isDisplayed(alertSuccess);
    }



}