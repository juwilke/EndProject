package tests;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CreateAccountFormPage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.TopMenuPage;

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

    @Test
    public void canCreateNewAccount() {
        topMenuPage.clickOnLoginLink();
        loginPage.setEmailCreateInput("test2@example.com");
        loginPage.clickOnSubmitCreateButton();
        Assertions.assertThat(createAccountFormPage.isAccountCreationFormDisplayed()).isTrue();
    }

    @Test(priority = 6)
    public void shouldNotAllowCreateAccountWithInvalidEmail() {
        topMenuPage.clickOnLoginLink();
        loginPage.setEmailCreateInput("teest@example");
        loginPage.clickOnSubmitCreateButton();
        Assertions.assertThat(loginPage.isCreateAccountErrorDisplayed()).isTrue();
    }

    @Test(priority = 5)
    public void shouldNotAllowLoginWithInvalidEmail() {
        topMenuPage.clickOnLoginLink();
        loginPage.setEmailToLoginInput("teest@example");
        loginPage.setPasswordToLoginInput("nBTevsfdcsWs");
        loginPage.clickOnSubmitLogin();
        Assertions.assertThat(loginPage.isLoginErrorDisplayed()).isTrue();
    }
    @Test(priority = 2)
    public void shouldNotAllowLoginWithoutPassword(){
        topMenuPage.clickOnLoginLink();
        loginPage.setEmailToLoginInput("teest@example.pl");
        loginPage.clickOnSubmitLogin();
        Assertions.assertThat(loginPage.isLoginErrorDisplayed()).isTrue();
    }
    @Test(priority = 3)
    public void shouldNotAllowLoginWithIncorrectPassword() {
        topMenuPage.clickOnLoginLink();
        loginPage.setEmailToLoginInput("lizzekeen@example.com");
        loginPage.setPasswordToLoginInput("vefrd");
        loginPage.clickOnSubmitLogin();
        Assertions.assertThat(loginPage.isLoginErrorDisplayed()).isTrue();
    }
    @Test(priority = 4)
    public void canLoginWithCorrectLoginAndPassword(){
        topMenuPage.clickOnLoginLink();
        loginPage.setEmailToLoginInput("lizzekeen@example.com");
        loginPage.setPasswordToLoginInput("NhYvAI0O4CkOuGn");
        loginPage.clickOnSubmitLogin();
        Assertions.assertThat(myAccountPage.isInfoAccountDisplayed()).isTrue();
        myAccountPage.clickOnLogout();
    }
}