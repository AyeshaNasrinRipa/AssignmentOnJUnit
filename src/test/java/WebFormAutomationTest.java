import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import com.github.javafaker.Faker;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WebFormAutomationTest extends BaseTest{

    LocalDate today = LocalDate.now();
    String month = today.format(DateTimeFormatter.ofPattern("MM"));
    String day   = today.format(DateTimeFormatter.ofPattern("dd"));
    String year  = today.format(DateTimeFormatter.ofPattern("yyyy"));

    @DisplayName("Verify that user can successfully submit the practice webform")
    @Test
    public void createUser() throws InterruptedException {

        Faker faker = new Faker();
        String fullName = faker.name().firstName() + " " + faker.name().lastName();
        String email = faker.internet().emailAddress().toLowerCase();
        String phoneNumber = faker.phoneNumber().subscriberNumber(11); // 11-digit phone
       // String aboutyourself = faker.lorem().sentence(10);
        String aboutyourself = "Hello! I am a test user trying out this webform. I enjoy learning new technologies and exploring different tools for web automation.";

        driver.get("https://www.digitalunite.com/practice-webform-learners");

        WebElement acceptButton = driver.findElement(By.id("onetrust-accept-btn-handler"));
        acceptButton.click();

        WebElement userName = driver.findElement(By.id("edit-name"));
        userName.sendKeys(fullName);

        WebElement phone = driver.findElement(By.id("edit-number"));
        phone.sendKeys(phoneNumber);

        WebElement date = driver.findElement(By.id("edit-date"));
        date.sendKeys(month);
        date.sendKeys(day);
        date.sendKeys(year);
        Utils.scroll(driver,300);

        WebElement emailField = driver.findElement(By.id("edit-email"));
        emailField.sendKeys(email);

        WebElement aboutYourself = driver.findElement(By.id("edit-tell-us-a-bit-about-yourself-"));
        Thread.sleep(3000);
        aboutYourself.sendKeys(aboutyourself);

        WebElement uploadFile = driver.findElement(By.id("edit-uploadocument-upload"));
        uploadFile.sendKeys("D:\\Profile.png");

        WebElement ageCheckbox = driver.findElement(By.id("edit-age"));
        Actions actions = new Actions(driver);
        actions.moveToElement(ageCheckbox).click().perform();
        Thread.sleep(3000);

        WebElement submitButton = driver.findElement(By.id("edit-submit"));
        Actions actions2 = new Actions(driver);
        actions2.moveToElement(submitButton).click().perform();

        WebElement submissionThankYouHeader = driver.findElement(By.tagName("h1"));
        String actualThankYouText = submissionThankYouHeader.getText();
        String expectedThankYouText = "Thank you for your submission!";
        Assertions.assertEquals(expectedThankYouText, actualThankYouText, "The 'Thank You' header message is not displayed correctly.");

        WebElement submissionConfirmationMessage = driver.findElement(By.className("webform-confirmation__message"));
        String actualConfirmationText = submissionConfirmationMessage.getText();
        String expectedConfirmationText = "New submission added to Practice webform for learners.";
        Assertions.assertEquals(expectedConfirmationText, actualConfirmationText, "The submission confirmation message is not displayed as expected.");

        WebElement backToFormLink = driver.findElement(By.cssSelector(".webform-confirmation__back a"));
        String actualLinkText = backToFormLink.getText();
        String expectedLinkText = "Back to form";
        Assertions.assertEquals(expectedLinkText, actualLinkText,
                "'Back to form' link text is incorrect.");

        String actualUrl = driver.getCurrentUrl();
        Assertions.assertTrue(actualUrl.contains("/webform/confirmation"), "Form submission may have failed: user was not redirected to the confirmation page.");
    }


}
