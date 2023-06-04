package Tests;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.PageTitlesUtils;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class ContactUsPageTest extends BaseTests {


    @Test
    public void shouldNotAllowToSendEmptyForm() {
        WebElement contactUsButton = driver.findElement(By.cssSelector("#contact-link"));
        contactUsButton.click();

        WebElement submitContactFormButton = driver.findElement(By.cssSelector("#submitMessage"));
        submitContactFormButton.click();

        WebElement alertMassage = driver.findElement(By.className("alert-danger"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(alertMassage));

        Assertions.assertThat(alertMassage.isDisplayed()).isTrue();

    }

//    @Test
//    public void shouldNotAllowToSandFormWithoutEmail(){
//        WebElement contactUsButton = driver.findElement(By.cssSelector("#contact-link"));
//        contactUsButton.click();
//
//        WebElement orderInput = driver.findElement(By.id("id_order"));
//        orderInput.sendKeys("Order number QWERTY#1234");
//
//
//
//    }

//    @Test
//    public void shouldNotAllowToSandFormWithoutSubject(){
//        WebElement contactUsButton = driver.findElement(By.cssSelector("#contact-link"));
//        contactUsButton.click();
//
//        WebElement emailInput = driver.findElement(By.id("email"));
//        emailInput.click();
//        emailInput.sendKeys("test@test.pl");
//    }
//
//
//    @Test
//    public void shouldNotAllowToSandFormWithoutMessage(){
//        WebElement contactUsButton = driver.findElement(By.cssSelector("#contact-link"));
//        contactUsButton.click();
//    }
//
//    @Test
//    public void validFormSubmission(){
//        WebElement contactUsButton = driver.findElement(By.cssSelector("#contact-link"));
//        contactUsButton.click();
//
//    }
//
//    @Test
//    public void shouldDisplayDescriptionToSubject(){
//        WebElement contactUsButton = driver.findElement(By.cssSelector("#contact-link"));
//        contactUsButton.click();
//    }
}
