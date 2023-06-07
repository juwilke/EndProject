package Tests;

import enums.ContactMassageSubject;
import model.ContactMassage;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.ContactUsFormPage;
import pages.TopMenuPage;

public class ContactUsPageTest extends BaseTests {

    private TopMenuPage topMenuPage;
    private ContactUsFormPage contactUsFormPage;

    @BeforeTest
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);

        topMenuPage = new TopMenuPage(driver);
        contactUsFormPage = new ContactUsFormPage(driver);
    }

    @Test
    public void shouldNotAllowToSendEmptyForm() {
        topMenuPage.clickOnContactUsLink();
        contactUsFormPage.clickOnSubmitContactFormButton();
        Assertions.assertThat(contactUsFormPage.isAlertMessageDisplay()).isTrue();
    }

    @Test
    public void shouldNotAllowToSandFormWithoutEmail() {
        ContactMassage contactMassage = new ContactMassage();
        topMenuPage.clickOnContactUsLink();
        contactMassage.setSubject(ContactMassageSubject.CUSTOMER_SERVICE);
        contactUsFormPage.setIdOrderInput("QWERTY #1234");
        contactUsFormPage.setMessageInput("QWERTY #1234 asdf");
        contactUsFormPage.clickOnSubmitContactFormButton();
        Assertions.assertThat(contactUsFormPage.isAlertMessageDisplay()).isTrue();

    }

    @Test
    public void shouldNotAllowToSandFormWithoutSubject() {
        topMenuPage.clickOnContactUsLink();
        contactUsFormPage.setEmailInput("test@example.com");
        contactUsFormPage.setIdOrderInput("QWERTY #1234");
        contactUsFormPage.setMessageInput("QWERTY #1234 asdf");
        contactUsFormPage.clickOnSubmitContactFormButton();
        Assertions.assertThat(contactUsFormPage.isAlertMessageDisplay()).isTrue();
    }


    @Test
    public void shouldNotAllowToSandFormWithoutMessage() {
        ContactMassage contactMassage = new ContactMassage();
        topMenuPage.clickOnContactUsLink();
        contactMassage.setSubject(ContactMassageSubject.WEBMASTER);
        contactUsFormPage.setIdOrderInput("QWERTY #1234");
        contactUsFormPage.setEmailInput("test@example.com");
        contactUsFormPage.clickOnSubmitContactFormButton();
        Assertions.assertThat(contactUsFormPage.isAlertMessageDisplay()).isTrue();
    }

    @Test
    public void canSendValidForm() {
        topMenuPage.clickOnContactUsLink();
        contactUsFormPage.setSubjectChoose("c");
        contactUsFormPage.setEmailInput("test11@example.com");
        contactUsFormPage.setIdOrderInput("QWERTY #1234");
        contactUsFormPage.setMessageInput("QWERTY #1234 asdf");
        contactUsFormPage.clickOnSubmitContactFormButton();
        Assertions.assertThat(contactUsFormPage.isAlertSuccessDisplayed()).isTrue();
    }
}
