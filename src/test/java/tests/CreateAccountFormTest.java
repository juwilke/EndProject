package tests;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CreateAccountFormPage;
import pages.LoginPage;
import pages.TopMenuPage;

public class CreateAccountFormTest extends BaseTests {

    private LoginPage loginPage;
    private CreateAccountFormPage createAccountFormPage;
    private TopMenuPage topMenuPage;

    @BeforeClass
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);

        createAccountFormPage = new CreateAccountFormPage(driver);
        topMenuPage = new TopMenuPage(driver);
        loginPage = new LoginPage(driver);
    }

    @Test(testName = "TC 2.3", priority = 1)
    public void shouldNotAllowToCreateAccountWithEmailOnly(){
        topMenuPage.clickOnLoginLink();
        loginPage.setEmailCreateInput("john@example.com");
        loginPage.clickOnSubmitCreateButton();
        Assertions.assertThat(createAccountFormPage.isAccountCreationFormDisplayed()).isTrue();
        createAccountFormPage.clickOnSubmitAccountButton();
        Assertions.assertThat(createAccountFormPage.isAlertErrorDisplayed()).isTrue();
    }
    @Test(testName = "TC 2.7", priority = 5)
    public void canCreateNewAccount(){
        topMenuPage.clickOnLoginLink();
        loginPage.setEmailCreateInput("ljizzean@example.com");
        loginPage.clickOnSubmitCreateButton();
        Assertions.assertThat(createAccountFormPage.isAccountCreationFormDisplayed()).isTrue();
        createAccountFormPage.clickOnGenderFemale();
        createAccountFormPage.setFirstNameInput("Lizak");
        createAccountFormPage.setLastNameInput("Kan");
        createAccountFormPage.setPasswordInput("NhYvAI0O4CkOuGn");
        createAccountFormPage.clickOnSubmitAccountButton();
        Assertions.assertThat(createAccountFormPage.isAlertSuccessDisplayed()).isTrue();
    }
    @Test(testName = "TC 2.4", priority = 2)
    public void shouldNotAllowToCreateAccountWithoutFirstName(){
        topMenuPage.clickOnLoginLink();
        loginPage.setEmailCreateInput("jobb@example.com");
        loginPage.clickOnSubmitCreateButton();
        Assertions.assertThat(createAccountFormPage.isAccountCreationFormDisplayed()).isTrue();
        createAccountFormPage.setLastNameInput("jobb");
        createAccountFormPage.setPasswordInput("NhYvAI0O4CkOuGn");
        createAccountFormPage.clickOnSubmitAccountButton();
        Assertions.assertThat(createAccountFormPage.isAlertErrorDisplayed()).isTrue();
    }
    @Test(testName = "TC 2.5", priority = 3)
    public void shouldNotAllowToCreateAccountWithoutLastName(){
        topMenuPage.clickOnLoginLink();
        loginPage.setEmailCreateInput("jbob@example.com");
        loginPage.clickOnSubmitCreateButton();
        Assertions.assertThat(createAccountFormPage.isAccountCreationFormDisplayed()).isTrue();
        createAccountFormPage.setFirstNameInput("jbob");
        createAccountFormPage.setPasswordInput("NhYvAI0O4CkOuGn");
        createAccountFormPage.clickOnSubmitAccountButton();
        Assertions.assertThat(createAccountFormPage.isAlertErrorDisplayed()).isTrue();
    }
    @Test(testName = "TC 2.6", priority = 4)
    public void shouldNotAllowToCreateAccountWithoutPassword(){
        topMenuPage.clickOnLoginLink();
        loginPage.setEmailCreateInput("bjob@example.com");
        loginPage.clickOnSubmitCreateButton();
        Assertions.assertThat(createAccountFormPage.isAccountCreationFormDisplayed()).isTrue();
        createAccountFormPage.setFirstNameInput("bjob");
        createAccountFormPage.setLastNameInput("bjob");
        createAccountFormPage.clickOnSubmitAccountButton();
        Assertions.assertThat(createAccountFormPage.isAlertErrorDisplayed()).isTrue();
    }
}
