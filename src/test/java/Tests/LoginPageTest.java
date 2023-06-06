package Tests;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
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

    @BeforeTest
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

    @Test
    public void shouldNotAllowCreateAccountWithInvalidEmail() {
        topMenuPage.clickOnLoginLink();
        loginPage.setEmailCreateInput("teest@example");
        loginPage.clickOnSubmitCreateButton();
        Assertions.assertThat(loginPage.isCreateAccountErrorDisplayed()).isTrue();
    }

    @Test
    public void shouldNotAllowLoginWithInvalidEmail() {
        topMenuPage.clickOnLoginLink();
        loginPage.setEmailToLoginInput("teest@example");
        loginPage.setPasswordToLoginInput("nBTevsfdcsWs");
        loginPage.clickOnSubmitLogin();
        Assertions.assertThat(loginPage.isLoginErrorDisplayed()).isTrue();
    }
    @Test
    public void shouldNotAllowLoginWithoutPassword(){
        topMenuPage.clickOnLoginLink();
        loginPage.setEmailToLoginInput("teest@example.pl");
        loginPage.clickOnSubmitLogin();
        Assertions.assertThat(loginPage.isLoginErrorDisplayed()).isTrue();
    }
    @Test
    public void shouldNotAllowLoginWithIncorrectPassword() {
        topMenuPage.clickOnLoginLink();
        loginPage.setEmailToLoginInput("lizzekeen@example.com");
        loginPage.setPasswordToLoginInput("vefrd");
        loginPage.clickOnSubmitLogin();
        Assertions.assertThat(loginPage.isLoginErrorDisplayed()).isTrue();
    }
    @Test
    public void canLoginWithCorrectLoginAndPassword(){
        topMenuPage.clickOnLoginLink();
        loginPage.setEmailToLoginInput("lizzekeen@example.com");
        loginPage.setPasswordToLoginInput("NhYvAI0O4CkOuGn");
        loginPage.clickOnSubmitLogin();
        Assertions.assertThat(myAccountPage.isInfoAccountDisplayed()).isTrue();
    }
}