package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriverWait wait;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
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
        wait.until(ExpectedConditions.visibilityOf(createAccountError));
        boolean isDisplayCreateAccountError = false;
        try {
            isDisplayCreateAccountError = createAccountError.isDisplayed();
        } catch (NoSuchElementException exception) {}
        return isDisplayCreateAccountError;
    }
    public boolean isLoginErrorDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(loginError));
        boolean isDisplayLoginError = false;
        try {
            isDisplayLoginError = loginError.isDisplayed();
        } catch (NoSuchElementException exception) {}
        return isDisplayLoginError;
    }
}
