package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BasePage;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email_create")
    WebElement emailCreateAccountInput;
    @FindBy(id = "SubmitCreate")
    WebElement submitCreateButton;
    @FindBy(id = "email")
    WebElement emailToLoginInput;
    @FindBy(id = "passwd")
    WebElement passwordToLoginInput;
    @FindBy(id = "SubmitLogin")
    WebElement submitLoginButton;
    @FindBy(id = "create_account_error")
    WebElement createAccountError;
    @FindBy(className = "alert-danger")
    WebElement loginError;

    public void setEmailCreateInput(String emailCreate) {
        emailCreateAccountInput.sendKeys(emailCreate);
    }

    public void clickOnSubmitCreateButton() {
        submitCreateButton.click();
    }

    public void inputRandomEmailCreate() {
        String email = faker.internet().emailAddress();
        emailCreateAccountInput.sendKeys(email);
    }
    public void inputRandomEmailToLogin(){
        String email = faker.internet().emailAddress();
        emailToLoginInput.sendKeys(email);
    }

    public void setEmailToLoginInput(String email) {
        emailToLoginInput.sendKeys(email);
    }
    public void setPasswordToLoginInput(String password) {
        passwordToLoginInput.sendKeys(password);
    }
    public void inputRandomPassword() {
        String password = faker.internet().password();
        passwordToLoginInput.sendKeys(password);
    }

    public void clickOnSubmitLogin() {
        submitLoginButton.click();
    }

    public boolean isCreateAccountErrorDisplayed() {
        return super.isDisplayed(createAccountError);
    }

    public boolean isLoginErrorDisplayed() {
        return super.isDisplayed(loginError);
    }
    public String redBoxText() {
        return isTextInAlertBox(loginError);
    }

}
