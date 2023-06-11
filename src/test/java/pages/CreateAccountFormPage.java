package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BasePage;

public class CreateAccountFormPage extends BasePage {
    public CreateAccountFormPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "account-creation_form")
    WebElement accountCreationForm;
    @FindBy(id = "id_gender2")
    WebElement genderFemale;
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
        return super.isDisplayed(accountCreationForm);
    }
    public void clickOnGenderFemale(){
        genderFemale.click();
    }

    public void inputRandomFirstName() {
        String firstName = faker.name().firstName();
        firstNameInput.sendKeys(firstName);
    }

    public void inputRandomLastName() {
        String lastName = faker.name().lastName();
        lastNameInput.sendKeys(lastName);
    }

    public void inputRandomPassword() {
        String password = faker.internet().password();
        passwordInput.sendKeys(password);
    }
    public void clickOnSubmitAccountButton(){
        submitAccountButton.click();
    }
    public boolean isAlertSuccessDisplayed(){
        return super.isDisplayed(alertSuccess);
    }
    public boolean isAlertErrorDisplayed() {
        return super.isDisplayed(alertError);
    }
    public String redBoxText() {
        return isTextInAlertBox(alertError);
    }
    public String greenBoxText() {
        return isTextInAlertBox(alertSuccess);
    }
}
