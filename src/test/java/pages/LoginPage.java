package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    private final AlertBoxPage alertBoxPage;
    public LoginPage(WebDriver driver) {
        super(driver);
        alertBoxPage = new AlertBoxPage(driver);
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

    public void setEmailCreateInput(String emailCreate){
        emailCreateAccountInput.sendKeys(emailCreate);
    }
    public void clickOnSubmitCreateButton(){
        submitCreateButton.click();
    }
    public void setEmailToLoginInput(String email){
        emailToLoginInput.sendKeys(email);
    }
    public void setPasswordToLoginInput(String password){
        passwordToLoginInput.sendKeys(password);
    }
    public void clickOnSubmitLogin(){
        submitLoginButton.click();
    }
    public boolean isCreateAccountErrorDisplayed(){
        return alertBoxPage.isDisplayed(createAccountError);
    }
    public boolean isLoginErrorDisplayed(){
        return alertBoxPage.isDisplayed(loginError);
    }
}
