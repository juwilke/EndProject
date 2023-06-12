package tests;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CreateAccountFormPage;
import pages.LoginPage;
import pages.TopMenuPage;
import utils.PageTitlesUtils;

public class CreateAccountFormTest extends BaseTests {

    private CreateAccountFormPage createAccountFormPage;
    private TopMenuPage topMenuPage;

    @BeforeClass
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);

        createAccountFormPage = new CreateAccountFormPage(driver);
        topMenuPage = new TopMenuPage(driver);
    }

    @Test(testName = "TC 2.3", priority = 1)
    public void shouldNotAllowToCreateAccountWithEmailOnly(){
        LoginPage loginPage = topMenuPage.clickOnLoginLink();
        loginPage.inputRandomEmailCreate();
        loginPage.clickOnSubmitCreateButton();
        Assertions.assertThat(createAccountFormPage.isAccountCreationFormDisplayed()).isTrue();
        createAccountFormPage.clickOnSubmitAccountButton();
        Assertions.assertThat(createAccountFormPage.isAlertErrorDisplayed()).isTrue();
        Assertions.assertThat(createAccountFormPage.redBoxText()).contains(PageTitlesUtils.ERROR_TEXT_FOR_EMPTY_CREATE_ACCOUNT);
    }
    @Test(testName = "TC 2.4", priority = 2)
    public void shouldNotAllowToCreateAccountWithoutFirstName(){
        LoginPage loginPage = topMenuPage.clickOnLoginLink();
        loginPage.inputRandomEmailCreate();
        loginPage.clickOnSubmitCreateButton();
        Assertions.assertThat(createAccountFormPage.isAccountCreationFormDisplayed()).isTrue();
        createAccountFormPage.inputRandomLastName();
        createAccountFormPage.inputRandomPassword();
        createAccountFormPage.clickOnSubmitAccountButton();
        Assertions.assertThat(createAccountFormPage.isAlertErrorDisplayed()).isTrue();
        Assertions.assertThat(createAccountFormPage.redBoxText()).contains(PageTitlesUtils.ERROR_TEXT_FOR_EMPTY_FIRST_NAME_CREATE_ACCOUNT);
    }
    @Test(testName = "TC 2.5", priority = 3)
    public void shouldNotAllowToCreateAccountWithoutLastName(){
        LoginPage loginPage = topMenuPage.clickOnLoginLink();
        loginPage.inputRandomEmailCreate();
        loginPage.clickOnSubmitCreateButton();
        Assertions.assertThat(createAccountFormPage.isAccountCreationFormDisplayed()).isTrue();
        createAccountFormPage.inputRandomFirstName();
        createAccountFormPage.inputRandomPassword();
        createAccountFormPage.clickOnSubmitAccountButton();
        Assertions.assertThat(createAccountFormPage.isAlertErrorDisplayed()).isTrue();
        Assertions.assertThat(createAccountFormPage.redBoxText()).contains(PageTitlesUtils.ERROR_TEXT_FOR_EMPTY_LAST_NAME_CREATE_ACCOUNT);
    }
    @Test(testName = "TC 2.6", priority = 4)
    public void shouldNotAllowToCreateAccountWithoutPassword(){
        LoginPage loginPage = topMenuPage.clickOnLoginLink();
        loginPage.inputRandomEmailCreate();
        loginPage.clickOnSubmitCreateButton();
        Assertions.assertThat(createAccountFormPage.isAccountCreationFormDisplayed()).isTrue();
        createAccountFormPage.inputRandomFirstName();
        createAccountFormPage.inputRandomLastName();
        createAccountFormPage.clickOnSubmitAccountButton();
        Assertions.assertThat(createAccountFormPage.isAlertErrorDisplayed()).isTrue();
        Assertions.assertThat(createAccountFormPage.redBoxText()).contains(PageTitlesUtils.ERROR_TEXT_FOR_EMPTY_PASSWORD_CREATE_ACCOUNT);
    }
    @Test(testName = "TC 2.7", priority = 5)
    public void canCreateNewAccount(){
        LoginPage loginPage = topMenuPage.clickOnLoginLink();
        loginPage.inputRandomEmailCreate();
        loginPage.clickOnSubmitCreateButton();
        Assertions.assertThat(createAccountFormPage.isAccountCreationFormDisplayed()).isTrue();
        createAccountFormPage.clickOnGenderFemale();
        createAccountFormPage.inputRandomFirstName();
        createAccountFormPage.inputRandomLastName();
        createAccountFormPage.inputRandomPassword();
        createAccountFormPage.clickOnSubmitAccountButton();
        Assertions.assertThat(createAccountFormPage.isAlertSuccessDisplayed()).isTrue();
        Assertions.assertThat(createAccountFormPage.greenBoxText()).contains(PageTitlesUtils.SUCCESS_MESSAGE_FOR_CREATE_ACCOUNT);
    }
}
