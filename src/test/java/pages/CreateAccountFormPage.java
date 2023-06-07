package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateAccountFormPage extends BasePage {
    private final AlertBoxPage alertBoxPage;
    public CreateAccountFormPage(WebDriver driver) {
        super(driver);
        alertBoxPage = new AlertBoxPage(driver);
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
        return alertBoxPage.isDisplayed(accountCreationForm);
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
        return alertBoxPage.isDisplayed(alertSuccess);
    }
    public boolean isAlertErrorDisplayed() {
        return alertBoxPage.isDisplayed(alertError);
    }
}
