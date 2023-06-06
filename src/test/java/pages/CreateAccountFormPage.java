package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateAccountFormPage extends BasePage {
    public CreateAccountFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "account-creation_form")
    WebElement accountCreationForm;

    @FindBy(id = "id_gender2")
    WebElement genderFemale;
    @FindBy(id = "id_gender1")
    WebElement genderMale;
    @FindBy(id = "customer_firstname")
    WebElement firstNameInput;
    @FindBy(id = "customer_lastname")
    WebElement lastNameInput;
    @FindBy(id = "passwd")
    WebElement passwordInput;
    @FindBy(id = "submitAccount")
    WebElement submitAccountButton;
    @FindBy(className = "alert-success")
    WebElement alertSuccess;
    @FindBy(className = "alert-danger")
    WebElement alertError;

    public boolean isAccountCreationFormDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(accountCreationForm));
        boolean isDisplayAccountCreation = false;
        try {
            isDisplayAccountCreation = accountCreationForm.isDisplayed();
        } catch (NoSuchElementException exception) {}
        return isDisplayAccountCreation;
    }

    public void clickOnGenderFemale(){
        genderFemale.click();
    }

    public void clickOnGenderMale(){
        genderMale.click();
    }
    public void setFirstNameInput(String firstName){
        firstNameInput.sendKeys(firstName);
    }
    public void setLastNameInput(String lastName){
        lastNameInput.sendKeys(lastName);
    }
    public void setPasswordInput(String password){
        passwordInput.sendKeys(password);
    }
    public void clickOnSubmitAccountButton(){
        submitAccountButton.click();
    }
    public boolean isAlertSuccessDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(alertSuccess));
        boolean isDisplaySuccess = false;
        try {
            isDisplaySuccess = alertSuccess.isDisplayed();
        } catch (NoSuchElementException exception) {}
        return isDisplaySuccess;
    }

    public boolean isAlertErrorDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(alertError));
        boolean isDisplayError = false;
        try {
            isDisplayError = alertError.isDisplayed();
        } catch (NoSuchElementException exception) {}
        return isDisplayError;
    }
}
