package tests;

import enums.ContactMassageSubject;
import model.ContactMassage;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ContactUsFormPage;
import pages.TopMenuPage;

public class ContactUsPageTest extends BaseTests {

    private TopMenuPage topMenuPage;
    private ContactUsFormPage contactUsFormPage;

    @BeforeClass
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get(BASE_URL);

        topMenuPage = new TopMenuPage(driver);
        contactUsFormPage = new ContactUsFormPage(driver);
    }

    @Test(priority = 1)
    public void shouldNotAllowToSendEmptyForm() {
        topMenuPage.clickOnContactUsLink();
        contactUsFormPage.clickOnSubmitContactFormButton();
        Assertions.assertThat(contactUsFormPage.isAlertMessageDisplay()).isTrue();
    }

    private void fillOutForm(String email, String idOrder, String message) {
        contactUsFormPage.setEmailInput(email);
        contactUsFormPage.setIdOrderInput(idOrder);
        contactUsFormPage.setMessageInput(message);
        contactUsFormPage.clickOnSubmitContactFormButton();
    }

    @Test(priority = 2)
    public void shouldNotAllowToSandFormWithoutEmail() {
        ContactMassage contactMassage = new ContactMassage();
        topMenuPage.clickOnContactUsLink();
        contactMassage.setSubject(ContactMassageSubject.CUSTOMER_SERVICE);
        fillOutForm("", "QWERTY #12 34", "QWERTY #1234");
        Assertions.assertThat(contactUsFormPage.isAlertMessageDisplay()).isTrue();
    }


    @Test(priority = 3)
    public void shouldNotAllowToSandFormWithoutSubject() {
        topMenuPage.clickOnContactUsLink();
        fillOutForm("test@example.com", "QWERTY #1234", "QWERTY #1234");
        Assertions.assertThat(contactUsFormPage.isAlertMessageDisplay()).isTrue();
    }


    @Test(priority = 4)
    public void shouldNotAllowToSandFormWithoutMessage() {
        ContactMassage contactMassage = new ContactMassage();
        topMenuPage.clickOnContactUsLink();
        contactMassage.setSubject(ContactMassageSubject.WEBMASTER);
        fillOutForm("test@example.com", "QWERTY #1234", "");
        Assertions.assertThat(contactUsFormPage.isAlertMessageDisplay()).isTrue();
    }

    @Test(priority = 5)
    public void canSendValidForm() {
        topMenuPage.clickOnContactUsLink();
        contactUsFormPage.setSubjectChoose("c");
        fillOutForm("test02@example.com", "QWERTY #1234", "QWERTY #1234");
        Assertions.assertThat(contactUsFormPage.isAlertSuccessDisplayed()).isTrue();
    }
}
