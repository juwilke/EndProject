package tests;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ContactUsFormPage;
import pages.TopMenuPage;
import utils.PageTitlesUtils;

public class ContactUsPageTest extends BaseTests {

    private TopMenuPage topMenuPage;


    @BeforeClass
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);

        topMenuPage = new TopMenuPage(driver);

    }

    @Test(testName = "TC 1.1", priority = 1)
    public void shouldNotAllowToSendEmptyForm() {
        ContactUsFormPage contactUsFormPage = topMenuPage.clickOnContactUsLink();
        contactUsFormPage.clickOnSubmitContactFormButton();
        Assertions.assertThat(contactUsFormPage.isAlertMessageDisplay()).isTrue();
        Assertions.assertThat(contactUsFormPage.redBoxText()).contains(PageTitlesUtils.ERROR_TEXT_FOR_EMPTY_CONTACT_US_FORM);
    }

    private void fillOutForm(ContactUsFormPage contactUsFormPage, String subjectValue, String email, String message) {
        contactUsFormPage.selectSubject(subjectValue);
        contactUsFormPage.setEmailInput(email);
        contactUsFormPage.setMessageInput(message);
        contactUsFormPage.clickOnSubmitContactFormButton();
    }

    @Test(testName = "TC 1.2", priority = 2)
    public void shouldNotAllowToSendFormWithoutEmail() {
        ContactUsFormPage contactUsFormPage = topMenuPage.clickOnContactUsLink();
        fillOutForm(contactUsFormPage,"1","", "QWERTY #1234");
        Assertions.assertThat(contactUsFormPage.isAlertMessageDisplay()).isTrue();
        Assertions.assertThat(contactUsFormPage.redBoxText()).contains(PageTitlesUtils.ERROR_TEXT_FOR_EMPTY_EMAIL_CONTACT_US_FORM);
    }

    @Test(testName = "TC 1.3", priority = 3)
    public void shouldNotAllowToSendFormWithoutSubject() {
        ContactUsFormPage contactUsFormPage = topMenuPage.clickOnContactUsLink();
        fillOutForm(contactUsFormPage,"0","test@example.com", "QWERTY");
        Assertions.assertThat(contactUsFormPage.isAlertMessageDisplay()).isTrue();
        Assertions.assertThat(contactUsFormPage.redBoxText()).contains(PageTitlesUtils.ERROR_TEXT_FOR_EMPTY_SUBJECT_CONTACT_US_FORM);
    }

    @Test(testName = "TC 1.4", priority = 4)
    public void shouldNotAllowToSendFormWithoutMessage() {
        ContactUsFormPage contactUsFormPage = topMenuPage.clickOnContactUsLink();
        fillOutForm(contactUsFormPage, "2","test@example.com", "");
        Assertions.assertThat(contactUsFormPage.isAlertMessageDisplay()).isTrue();
        Assertions.assertThat(contactUsFormPage.redBoxText()).contains(PageTitlesUtils.ERROR_TEXT_FOR_EMPTY_MESSAGE_CONTACT_US_FORM);
    }

    @Test(testName = "TC 1.5", priority = 5)
    public void canSendValidForm() {
        ContactUsFormPage contactUsFormPage = topMenuPage.clickOnContactUsLink();
        fillOutForm(contactUsFormPage,"2","test02@example.com", "QWERTY #1234");
        Assertions.assertThat(contactUsFormPage.isAlertSuccessDisplayed()).isTrue();
        Assertions.assertThat(contactUsFormPage.greenBoxText()).contains(PageTitlesUtils.SUCCESS_MESSAGE_FOR_SEND_CONTACT_US_FORM);
    }
}
