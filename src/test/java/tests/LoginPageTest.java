package tests;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CreateAccountFormPage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.TopMenuPage;
import utils.PageTitlesUtils;

public class LoginPageTest extends BaseTests {

    private TopMenuPage topMenuPage;
    private LoginPage loginPage;
    private CreateAccountFormPage createAccountFormPage;
    private MyAccountPage myAccountPage;

    @BeforeClass
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);

        topMenuPage = new TopMenuPage(driver);
        loginPage = new LoginPage(driver);
        createAccountFormPage = new CreateAccountFormPage(driver);
        myAccountPage = new MyAccountPage(driver);
    }



    @Test(testName = "TC 3.1", priority = 1)
    public void shouldNotAllowLoginWithoutPassword(){
        topMenuPage.clickOnLoginLink();
        loginPage.inputRandomEmailToLogin();
        loginPage.clickOnSubmitLogin();
        Assertions.assertThat(loginPage.isLoginErrorDisplayed()).isTrue();
        Assertions.assertThat(loginPage.redBoxText()).contains(PageTitlesUtils.ERROR_TEXT_FOR_EMPTY_PASSWORD_LOGIN);
    }
    @Test(testName = "TC 3.2", priority = 2)
    public void shouldNotAllowLoginWithIncorrectPassword() {
        topMenuPage.clickOnLoginLink();
        loginPage.setEmailToLoginInput("lizzekeen@example.com");
        loginPage.inputRandomPassword();
        loginPage.clickOnSubmitLogin();
        Assertions.assertThat(loginPage.isLoginErrorDisplayed()).isTrue();
        Assertions.assertThat(loginPage.redBoxText()).contains(PageTitlesUtils.ERROR_TEXT_FOR_INCORRECT_PASSWORD_LOGIN);
    }

    @Test(testName = "TC 3.3", priority = 3)
    public void shouldNotAllowLoginWithInvalidEmail() {
        topMenuPage.clickOnLoginLink();
        loginPage.setEmailToLoginInput("invalid@test");
        loginPage.inputRandomPassword();
        loginPage.clickOnSubmitLogin();
        Assertions.assertThat(loginPage.isLoginErrorDisplayed()).isTrue();
        Assertions.assertThat(loginPage.redBoxText()).contains(PageTitlesUtils.ERROR_TEXT_FOR_INCORRECT_EMAIL_LOGIN);
    }

    @Test(testName = "TC 3.4", priority = 4)
    public void canLoginWithCorrectData() {
        topMenuPage.clickOnLoginLink();
        loginPage.setEmailToLoginInput("lizzekeen@example.com");
        loginPage.setPasswordToLoginInput("NhYvAI0O4CkOuGn");
        loginPage.clickOnSubmitLogin();
        Assertions.assertThat(myAccountPage.isInfoAccountDisplayed()).isTrue();
        myAccountPage.clickOnLogout();
    }
    @Test(testName = "TC 2.1", priority = 5)
    public void shouldNotAllowCreateAccountWithInvalidEmail() {
        topMenuPage.clickOnLoginLink();
        loginPage.setEmailCreateInput("teest@example");
        loginPage.clickOnSubmitCreateButton();
        Assertions.assertThat(loginPage.isCreateAccountErrorDisplayed()).isTrue();
    }
    @Test(testName = "TC 2.2", priority = 6)
    public void canCreateNewAccount() {
        topMenuPage.clickOnLoginLink();
        loginPage.inputRandomEmailCreate();
        loginPage.clickOnSubmitCreateButton();
        Assertions.assertThat(createAccountFormPage.isAccountCreationFormDisplayed()).isTrue();
    }
}